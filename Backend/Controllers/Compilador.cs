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

            var inputStream = new AntlrInputStream(request.Code);

            //Analisis lexico
            var analisisLexico = new AnalizadorLexicoLexer(inputStream);
            
            //Analisis sintactico
            var listaTokens = new CommonTokenStream(analisisLexico);
            var analisiSintactico = new AnalizadorLexicoParser(listaTokens);
            
            //Errores
            // var errorListener = new MyErrorListener();
            // analisiSintactico.RemoveErrorListeners(); 
            // analisiSintactico.AddErrorListener(errorListener);

            var arbol = analisiSintactico.inicio();
            
            EntornoDTO entornoInicial = new EntornoDTO("Primero", null);        
            Visitor visitor = new Visitor(entornoInicial);
            visitor.Visit(arbol);

            // Console.WriteLine(string.Join("\n", errorListener.Errores));

            return Ok(new { result = visitor.listaSalida });
        }

    }
}