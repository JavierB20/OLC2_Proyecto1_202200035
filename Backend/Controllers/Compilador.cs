using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using analyzer;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace Backend.Controllers
{
    [Route("[controller]")]
    public class Compilador : Controller
    {
        private readonly ILogger<Compilador> _logger;

        public Compilador(ILogger<Compilador> logger)
        {
            _logger = logger;
        }

        public class CompiladorRequest
        {   
            [Required]
            public required string Code { get; set; }
        }

        [HttpPost]
        public IActionResult Post([FromBody] CompiladorRequest request)
        {
            if(!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            List<ErrorInfo> allErrors = new List<ErrorInfo>();
            var inputStream = new AntlrInputStream(request.Code);

            // Setup error listeners for lexical and syntax errors
            var customErrorListener = new CustomErrorListener();

            // Análisis léxico
            var analisisLexico = new AnalizadorLexicoLexer(inputStream);
            analisisLexico.RemoveErrorListeners();
            analisisLexico.AddErrorListener(customErrorListener);
            
            // Análisis sintáctico
            var listaTokens = new CommonTokenStream(analisisLexico);
            var analisiSintactico = new AnalizadorLexicoParser(listaTokens);
            analisiSintactico.RemoveErrorListeners();
            analisiSintactico.AddErrorListener(customErrorListener);

            try
            {
                // Parsing and visiting
                var arbol = analisiSintactico.inicio();
                
                EntornoDTO entornoInicial = new EntornoDTO("Primero", null);        
                Visitor visitor = new Visitor(entornoInicial);
                visitor.Visit(arbol);

                // Collect all types of errors
                allErrors.AddRange(customErrorListener.Errores); // Lexical and syntactical errors
                allErrors.AddRange(visitor.erroresSemanticos);   // Semantic errors

                // Return both the output and the errors
                return Ok(new { 
                    result = visitor.listaSalida,
                    errors = allErrors
                });
            }
            catch (Exception ex)
            {
                // In case of catastrophic failure
                allErrors.Add(new ErrorInfo(
                    $"Error crítico: {ex.Message}",
                    0, 0, "Sistema"
                ));

                return Ok(new { 
                    result = new List<object>() { $"Error crítico: {ex.Message}" },
                    errors = allErrors
                });
            }
        }
    }
}