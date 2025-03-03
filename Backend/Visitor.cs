using System;
using System.Collections.Generic;
using System.Globalization;
using System.Net;
using System.Text.RegularExpressions;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using Backend.Expresiones;
using Microsoft.VisualBasic;

namespace analyzer
{
    class Visitor : AnalizadorLexicoBaseVisitor<Object>
    {
        public Stack<EntornoDTO> pilaEntornos = new Stack<EntornoDTO>();
        public EntornoDTO entornoInicial;
        public List<Object> listaSalida = new List<Object>();
        public List<ErrorInfo> erroresSemanticos = new List<ErrorInfo>();

        public Visitor(EntornoDTO entorno)
        {
            this.entornoInicial = entorno;
            pilaEntornos.Push(entorno);
        }

        // Metodo de ayuda para agregar ERRORES
        private void AddSemanticError(string descripcion, IToken token)
        {
            erroresSemanticos.Add(new ErrorInfo(
                $"Error Semántico: {descripcion}",
                token.Line,
                token.Column,
                "Semántico"
            ));
        }

        /* INICIO */
        public override Object VisitInicio([NotNull] AnalizadorLexicoParser.InicioContext context)
        {
            if (context.listainstrucciones() != null)
            {
                return VisitListainstrucciones(context.listainstrucciones());
            }
            return true;
        }
        public override Object VisitListainstrucciones([NotNull] AnalizadorLexicoParser.ListainstruccionesContext context)
        {
            if (context.instruccion() == null)
                return true;

            foreach (AnalizadorLexicoParser.InstruccionContext instruccion in context.instruccion())
            {
                VisitInstruccion(instruccion);
            }
            return true;
        }
        public override Object VisitInstruccion([NotNull] AnalizadorLexicoParser.InstruccionContext context)
        {
            if (context == null)
                return false;

            try
            {
                if (context.print() != null)
                    Visit(context.print());
                else if (context.variables() != null)
                    Visit(context.variables());
                else if (context.asignacion() != null)
                    Visit(context.asignacion());
                else if (context.instruccion_if() != null)
                    Visit(context.instruccion_if());
                else if (context.instruccion_switch != null)
                    Visit(context.instruccion_switch());
            }
            catch (Exception ex)
            {
                IToken token = context.Start;
                AddSemanticError(ex.Message, token);
            }

            return true;
        }
        /*FIN INICIO*/


        //Datos PRIMITIVOS
        public override Object VisitCadenaExpresion([NotNull] AnalizadorLexicoParser.CadenaExpresionContext context)
        {
            string rawText = context.GetText().Substring(1, context.GetText().Length - 2);
            string processedText = Regex.Unescape(rawText);
            return new Nativo(processedText, TipoDato.STRING, context.Start.Line, context.Start.Column);


        }
        public override object VisitCaracterExpresion([NotNull] AnalizadorLexicoParser.CaracterExpresionContext context)
        {
            string rawText = context.GetText().Substring(1, context.GetText().Length - 2);
            char processedText = Convert.ToChar(Regex.Unescape(rawText));
            return new Nativo(processedText, TipoDato.RUNE, context.Start.Line, context.Start.Column);

        }
        public override object VisitBoleanExpresion([NotNull] AnalizadorLexicoParser.BoleanExpresionContext context)
        {
            if (context.BOOL().GetText() == "true")
                return new Nativo(true, TipoDato.BOOL, context.Start.Line, context.Start.Column);
            else if (context.BOOL().GetText() == "false")
                return new Nativo(false, TipoDato.BOOL, context.Start.Line, context.Start.Column);

            AddSemanticError("Valor booleano no válido", context.Start);
            return false;
        }
        public override Object VisitIntExpresion([NotNull] AnalizadorLexicoParser.IntExpresionContext context)
        {
            return new Nativo(int.Parse(context.INT().GetText()), TipoDato.INT, context.Start.Line, context.Start.Column);
        }
        public override Object VisitDecimalExpresion([NotNull] AnalizadorLexicoParser.DecimalExpresionContext context)
        {
            return new Nativo(double.Parse(context.DECIMAL().GetText(), CultureInfo.InvariantCulture), TipoDato.FLOAT64, context.Start.Line, context.Start.Column);
        }
        /*FIN DATOS PRIMITIVOS*/


        /*OPERACIONES ARITMETICAS*/
        public override Object VisitSumaYresta([NotNull] AnalizadorLexicoParser.SumaYrestaContext context)
        {
            try
            {
                string operador = context.operador.Text;

                var leftVisit = Visit(context.left);
                var rightVisit = Visit(context.right);

                Nativo left = ConvertirANativo(leftVisit, context.Start);
                Nativo right = ConvertirANativo(rightVisit, context.Start);

                var resultado = OperacionesAritmeticas.RealizarOperacion(
                    operador == "+" ? OperadorAritmetico.SUMA : OperadorAritmetico.RESTA,
                    left,
                    right,
                    context,
                    erroresSemanticos 
                );
                return resultado;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación de suma/resta: {ex.Message}", context.Start);
                return 0;
            }
        }
        public override Object VisitMultiplicacionYdivision([NotNull] AnalizadorLexicoParser.MultiplicacionYdivisionContext context)
        {
            try
            {
                string operador = context.operador.Text;

                var leftVisit = Visit(context.left);
                var rightVisit = Visit(context.right);

                Nativo left = ConvertirANativo(leftVisit, context.Start);
                Nativo right = ConvertirANativo(rightVisit, context.Start);

                var resultado = OperacionesAritmeticas.RealizarOperacion(
                    operador == "*" ? OperadorAritmetico.MULTIPLICACION : OperadorAritmetico.DIVISION,
                    left,
                    right,
                    context,
                    erroresSemanticos 
                );
                return resultado;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación de multiplicacion/division: {ex.Message}", context.Start);
                return 0;
            }
        }
        public override Object VisitModulo([NotNull] AnalizadorLexicoParser.ModuloContext context)
        {
            try
            {
                string operador = context.operador.Text;

                var leftVisit = Visit(context.left);
                var rightVisit = Visit(context.right);

                Nativo left = ConvertirANativo(leftVisit, context.Start);
                Nativo right = ConvertirANativo(rightVisit, context.Start);

                var resultado = OperacionesAritmeticas.RealizarOperacion(
                    OperadorAritmetico.MODULO,
                    left,
                    right,
                    context,
                    erroresSemanticos 
                );
                return resultado;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación de suma/resta: {ex.Message}", context.Start);
                return 0;
            }
        }
        public override Object VisitOperadorNegativo([NotNull] AnalizadorLexicoParser.OperadorNegativoContext context)
        {
            try
            {
                string operador = context.operador.Text;

                var rightVisit = Visit(context.right);

                Nativo right = ConvertirANativo(rightVisit, context.Start);

                var resultado = OperacionesAritmeticas.RealizarOperacion(
                    OperadorAritmetico.NEGACION,
                    right,
                    context,
                    erroresSemanticos 
                );
                return resultado;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación de suma/resta: {ex.Message}", context.Start);
                return 0;
            }
        }
        /*FIN OPERACIONES ARITMETICAS*/

        /*OPERACIONES RELACIONALES*/  
        public override Object VisitOperadorRelacional([NotNull] AnalizadorLexicoParser.OperadorRelacionalContext context)
        {
            try
            {
                string operador = context.operador.Text;

                var leftVisit = Visit(context.left);
                var rightVisit = Visit(context.right);

                Nativo left = ConvertirANativo(leftVisit, context.Start);
                Nativo right = ConvertirANativo(rightVisit, context.Start);
                
                OperadorRelacionales operadorRelacional;
                
                switch(operador) {
                    case "==":
                        operadorRelacional = OperadorRelacionales.IGUALACION;
                        break;
                    case "!=":
                        operadorRelacional = OperadorRelacionales.DIFERENCIA;
                        break;
                    case "<":
                        operadorRelacional = OperadorRelacionales.MENORQUE;
                        break;
                    case "<=":
                        operadorRelacional = OperadorRelacionales.MENOROIGUAL;
                        break;
                    case ">":
                        operadorRelacional = OperadorRelacionales.MAYORQUE;
                        break;
                    case ">=":
                        operadorRelacional = OperadorRelacionales.MAYOROIGUAL;
                        break;
                    default:
                        AddSemanticError($"Operador relacional no reconocido: {operador}", context.Start);
                        return 0; 
                }

                var resultado = OperacionesRelacionales.RealizarOperacion(
                    operadorRelacional,
                    left,
                    right,
                    context,
                    erroresSemanticos 
                );
                return resultado;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación relacional: {ex.Message}", context.Start);
                return 0;
            }
        }
        /*FIN OPERACIONES RELACIONALES*/

        /*OPERACIONES LOGICAS*/
        public override Object VisitOperadorLogico([NotNull] AnalizadorLexicoParser.OperadorLogicoContext context)
        {
            try
            {
                string operador = context.operador.Text;
                
                var leftVisit = Visit(context.left);
                var rightVisit = Visit(context.right);

                Nativo left = ConvertirANativo(leftVisit, context.Start);
                Nativo right = ConvertirANativo(rightVisit, context.Start);

                OperadorLogicos operadorLogico;
                
                switch(operador) {
                    case "&&":
                        operadorLogico = OperadorLogicos.AND;
                        break;
                    case "||":
                        operadorLogico = OperadorLogicos.OR;
                        break;
                    default:
                        AddSemanticError($"Operador logico no reconocido: {operador}", context.Start);
                        return 0; 
                }

                var resultado = OperacionesLogicas.RealizarOperacion(
                    operadorLogico,
                    left,
                    right,
                    context,
                    erroresSemanticos 
                );
                return resultado;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación logica: {ex.Message}", context.Start);
                return 0;
            }
        }
        public override Object VisitOperadorNegacion([NotNull] AnalizadorLexicoParser.OperadorNegacionContext context)
        {
            try
            {
                string operador = context.operador.Text;

                var rightVisit = Visit(context.right);

                Nativo right = ConvertirANativo(rightVisit, context.Start);

                OperadorLogicos operadorLogico;

                switch(operador) {
                    case "!":
                        operadorLogico = OperadorLogicos.NOT;
                        break;
                    default:
                        AddSemanticError($"Operador logico no reconocido: {operador}", context.Start);
                        return 0; 
                }

                var resultado = OperacionesLogicas.RealizarOperacion(
                    operadorLogico,
                    right,
                    context,
                    erroresSemanticos 
                );
                return resultado;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación logica: {ex.Message}", context.Start);
                return 0;
            }
        }
        /*FIN OPERACIONES LOGICAS*/

        /*SIGNOS DE AGRUPACION*/
        public override Object VisitExpreParentesis(AnalizadorLexicoParser.ExpreParentesisContext context)
        {
            try
            {
                Console.WriteLine("Encontro expresion en parentesis");
                return Visit(context.expr());
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en expresión entre paréntesis: {ex.Message}", context.Start);
                return null;
            }
        }
        public override Object VisitExpreCorchetes(AnalizadorLexicoParser.ExpreCorchetesContext context)
        {
            try
            {
                return Visit(context.expr());
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en expresión entre corchetes: {ex.Message}", context.Start);
                return null;
            }
        }
        /*FIN SIGNOS DE AGRUPACION*/


        //VARIABLES
        /*DECLARACION*/
        public override Object VisitDeclaracionVar([NotNull] AnalizadorLexicoParser.DeclaracionVarContext context)
        {
            try
            {
                EntornoDTO entorno = pilaEntornos.Peek();
                string nombreVariable = context.ID().GetText();
                string tipoVariable = context.tipo().GetText();
                Object? valor = null;

                if (!entorno.variables.ContainsKey(nombreVariable))
                {
                    if (context.expr() != null)
                    {
                        valor = (Nativo)Visit(context.expr());

                        // Permitir únicamente INT en FLOAT64
                        if (tipoVariable.ToUpper().Equals("FLOAT64") && ((Nativo)valor).Tipo.ToString().Equals("INT"))
                        {
                            decimal nuevoValor = Convert.ToDecimal(((Nativo)valor).Valor);

                            var variable = new SimbolosDTO(nombreVariable, tipoVariable, new Nativo(nuevoValor, TipoDato.FLOAT64, context.Start.Line, context.Start.Column));
                            entorno.guardarVariable(nombreVariable, variable);
                            Console.WriteLine($"Variable '{nombreVariable}' guardada con valor {nuevoValor}");
                            return variable;  
                        }

                        // Validar que sea el mismo tipo
                        if (tipoVariable.ToUpper() != ((Nativo)valor).Tipo.ToString())
                        {
                            AddSemanticError($"Tipo de dato incompatible en asignación a variable '{nombreVariable}'. Se esperaba {tipoVariable}", context.Start);
                            return null;
                        }

                        var nuevaVariable = new SimbolosDTO(nombreVariable, tipoVariable, valor);
                        entorno.guardarVariable(nombreVariable, nuevaVariable);
                        Console.WriteLine($"Variable '{nombreVariable}' guardada con valor {((Nativo)valor).Valor}");

                        return nuevaVariable;  
                    }
                    else
                    {
                        valor = ValorPorDefecto(tipoVariable);
                        
                        Console.WriteLine("Por defecto tipo" + tipoVariable);

                        Nativo valorPorDefecto = new Nativo(
                            valor,
                            tipoVariable switch
                            {
                                "int" => TipoDato.INT,
                                "float64" => TipoDato.FLOAT64,
                                "string" => TipoDato.STRING,
                                "bool" => TipoDato.BOOL,
                                "rune" => TipoDato.RUNE,
                                _ => throw new Exception($"Tipo de dato no soportado: {tipoVariable}")
                            },
                            context.Start.Line,
                            context.Start.Column
                        );

                        var nuevaVariable = new SimbolosDTO(nombreVariable, tipoVariable, valorPorDefecto);
                        entorno.guardarVariable(nombreVariable, nuevaVariable);
                        Console.WriteLine($"Variable '{nombreVariable}' guardada con valor por defecto {valorPorDefecto}");

                        return nuevaVariable; 
                    }
                }
                else
                {
                    AddSemanticError($"Variable '{nombreVariable}' ya ha sido declarada en este ámbito", context.Start);
                    return null;
                }
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en declaración de variable: {ex.Message}", context.Start);
                return null;
            }
        }
        /*ASIGNACION*/
        public override Object VisitAsignacionVar([NotNull] AnalizadorLexicoParser.AsignacionVarContext context)
        {
            try
            {
                EntornoDTO entorno = pilaEntornos.Peek();
                string nombreVariable = context.ID().GetText();
                string signo = context.signo.Text;
                Object valor = Visit(context.expr());

                if (valor is SimbolosDTO)
                {
                    valor = ((SimbolosDTO)valor).valor;
                }

                if (valor is Nativo)
                {
                    valor = (Nativo)valor;
                }

                switch (signo)
                {
                    case ":=": // Declaración y asignación
                        if (!entorno.variables.ContainsKey(nombreVariable))
                        {
                            // Si no existe, se declara y asigna
                            entorno.guardarVariable(nombreVariable, new SimbolosDTO(nombreVariable, "int", valor));
                            Console.WriteLine($"Variable '{nombreVariable}' declarada y asignada con valor: {valor}");
                        }
                        else
                        {
                            AddSemanticError($"Variable '{nombreVariable}' ya ha sido declarada en este ámbito", context.Start);
                        }
                        break;

                    case "=": // Asignación simple
                        var simbolo = entorno.buscarVariable(nombreVariable);
                        if (simbolo == null)
                        {
                            AddSemanticError($"Variable '{nombreVariable}' no ha sido declarada", context.Start);
                            return false;
                        }

                        // Verificar compatibilidad de tipos
                        if (simbolo.tipo.ToUpper() != ((Nativo)valor).Tipo.ToString())
                        {
                            AddSemanticError($"Tipo de dato incompatible en asignación a variable '{nombreVariable}'. Se esperaba {simbolo.tipo}", context.Start);
                            return false;
                        }

                        // Actualizar el valor de la variable
                        entorno.actualizarValorSimbolo(nombreVariable, valor);
                        Console.WriteLine($"Variable '{nombreVariable}' actualizada con valor: {valor}");
                        break;

                    case "+=": // Asignación con suma
                        simbolo = entorno.buscarVariable(nombreVariable);
                        if (simbolo == null)
                        {
                            AddSemanticError($"Variable '{nombreVariable}' no ha sido declarada", context.Start);
                            return false;
                        }

                        if (simbolo.tipo.ToUpper() != ((Nativo)valor).Tipo.ToString())
                        {
                            AddSemanticError($"Tipo de dato incompatible en asignación con suma a variable '{nombreVariable}'. Se esperaba {simbolo.tipo}", context.Start);
                            return false;
                        }
                            
                        Nativo valorNativo = (Nativo)valor;
                        Nativo simboloNativo = (Nativo)simbolo.valor;

                        if (simboloNativo.Tipo == TipoDato.INT)
                        {
                            int valorActual = (int)simboloNativo.Valor;
                            int valorSumar = (int)valorNativo.Valor;
                            int resultado = valorActual + valorSumar;

                            entorno.actualizarValorSimbolo(nombreVariable, new Nativo(resultado, TipoDato.INT, context.Start.Line, context.Start.Column));
                        }
                        else if (simboloNativo.Tipo == TipoDato.FLOAT64)
                        {
                            decimal valorActual = (decimal)simboloNativo.Valor;
                            decimal valorSumar = (decimal)valorNativo.Valor;
                            decimal resultado = valorActual + valorSumar;

                            entorno.actualizarValorSimbolo(nombreVariable, new Nativo(resultado, TipoDato.FLOAT64, context.Start.Line, context.Start.Column));
                        }
                        else
                        {
                            AddSemanticError($"No se puede aplicar el operador += para los tipos de datos de '{nombreVariable}' y la expresión", context.Start);
                        }
                        break;

                    case "-=": // Asignación con resta
                        simbolo = entorno.buscarVariable(nombreVariable);
                        if (simbolo == null)
                        {
                            AddSemanticError($"Variable '{nombreVariable}' no ha sido declarada", context.Start);
                            return false;
                        }

                        else if (simbolo.tipo.ToUpper() != ((Nativo)valor).Tipo.ToString())
                        {
                            AddSemanticError($"Tipo de dato incompatible en asignación con resta a variable '{nombreVariable}'. Se esperaba {simbolo.tipo}", context.Start);
                            return false;
                        }

                        valorNativo = (Nativo)valor;
                        simboloNativo = (Nativo)simbolo.valor;

                        if (simboloNativo.Tipo == TipoDato.INT)
                        {
                            int valorActual = (int)simboloNativo.Valor;
                            int valorRestar = (int)valorNativo.Valor;
                            int resultado = valorActual - valorRestar;

                            entorno.actualizarValorSimbolo(nombreVariable, new Nativo(resultado, TipoDato.INT, context.Start.Line, context.Start.Column));
                        }
                        else if (simboloNativo.Tipo == TipoDato.FLOAT64)
                        {
                            decimal valorActual = (decimal)simboloNativo.Valor;
                            decimal valorRestar = (decimal)valorNativo.Valor;
                            decimal resultado = valorActual - valorRestar;

                            entorno.actualizarValorSimbolo(nombreVariable, new Nativo(resultado, TipoDato.FLOAT64, context.Start.Line, context.Start.Column));
                        }
                        else
                        {
                            AddSemanticError($"No se puede aplicar el operador -= para los tipos de datos de '{nombreVariable}' y la expresión", context.Start);
                        }
                        break;

                    default:
                        AddSemanticError($"Operador de asignación no reconocido: {signo}", context.Start);
                        return false;
                }

                return true;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en asignación de variable: {ex.Message}", context.Start);
                return false;
            }
        }
        public override Object VisitIdExpresion([NotNull] AnalizadorLexicoParser.IdExpresionContext context)
        {
            EntornoDTO entorno = pilaEntornos.Peek();
            string variableName = context.ID().GetText();
            SimbolosDTO? simbolo = entorno.buscarVariable(variableName);
            
            if (simbolo != null)
            {
                return simbolo.valor;
            }
            
            AddSemanticError($"Variable '{variableName}' no ha sido declarada", context.Start);
            return "NULL";
        }
        public Object ValorPorDefecto(string tipo)
        {
            return tipo switch
            {
                "int" => 0,
                "float64" => 0.0,
                "string" => "",
                "bool" => false,
                "rune" => "\0",
                _ => throw new Exception($"Tipo desconocido: {tipo}")
            };
        }
        /*FIN DE VARIABLES*/


        //SENTENCIAS DE CONTROL
        /* INSTUCCION IF */
        public override object VisitInstruccion_if([NotNull] AnalizadorLexicoParser.Instruccion_ifContext context)
        {
            try
            {
                var expr = Visit(context.expr());
                Nativo exprResult = ConvertirANativo(expr, context.Start);

                if (exprResult.Tipo != TipoDato.BOOL)
                {
                    AddSemanticError("La expresión en la instrucción if debe ser de tipo booleano", context.expr().Start);
                    return false;
                }

                if ((bool)exprResult.Valor)
                {
                    EntornoDTO entornoIf = new EntornoDTO("If", pilaEntornos.Peek());
                    pilaEntornos.Peek().punteroASiguiente = entornoIf;
                    pilaEntornos.Push(entornoIf);

                    Visit(context.listainstrucciones(0)); 

                    pilaEntornos.Pop();
                    pilaEntornos.Peek().punteroASiguiente = null;
                }
                else if (context.GetText().Contains("else"))
                {
                    // Verificar si el else contiene otro if o simplemente un bloque de código
                    if (context.instruccion_if() != null)
                    {
                        // Es un else if, visitar la instrucción if dentro del else
                        Visit(context.instruccion_if());
                    }
                    else
                    {
                        // Es un else con un bloque de instrucciones
                        EntornoDTO entornoElse = new EntornoDTO("Else", pilaEntornos.Peek());
                        pilaEntornos.Peek().punteroASiguiente = entornoElse;
                        pilaEntornos.Push(entornoElse);

                        Visit(context.listainstrucciones(1));

                        pilaEntornos.Pop();
                        pilaEntornos.Peek().punteroASiguiente = null;
                    }
                }

                return true;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en instrucción if: {ex.Message}", context.Start);
                return false;
            }
        }
        /* INSTRUCCION SWITCH*/
        public override object VisitInstruccion_switch([NotNull] AnalizadorLexicoParser.Instruccion_switchContext context)
        {
            try
            {
                var expr = Visit(context.expr());
                Nativo switchExpr = ConvertirANativo(expr, context.Start);

                // Bandera para saber si algún caso coincidió
                bool casoCumplido = false;

                // Recorrer todos los casos
                for (int i = 0; i < context.caso().Length; i++)
                {
                    var casoContext = context.caso(i);
                    var casoExpr = Visit(casoContext.expr());
                    Nativo casoValue = ConvertirANativo(casoExpr, casoContext.expr().Start);

                    // Verificar que los tipos sean comparables
                    if (switchExpr.Tipo != casoValue.Tipo)
                    {
                        AddSemanticError($"Tipo de caso ({casoValue.Tipo}) no coincide con el tipo de la expresión del switch ({switchExpr.Tipo})", 
                                        casoContext.expr().Start);
                        continue;
                    }

                    bool coincide = false;
                    
                    switch (switchExpr.Tipo)
                    {
                        case TipoDato.INT:
                            coincide = (int)switchExpr.Valor == (int)casoValue.Valor;
                            break;
                        case TipoDato.FLOAT64:
                            coincide = (decimal)switchExpr.Valor == (decimal)casoValue.Valor;
                            break;
                        case TipoDato.STRING:
                            coincide = switchExpr.Valor.ToString() == casoValue.Valor.ToString();
                            break;
                        case TipoDato.BOOL:
                            coincide = (bool)switchExpr.Valor == (bool)casoValue.Valor;
                            break;
                        case TipoDato.RUNE: 
                            coincide = switchExpr.Valor.ToString() == casoValue.Valor.ToString();
                            break;
                        default:
                            AddSemanticError($"Tipo de dato no soportado en switch: {switchExpr.Tipo}", context.expr().Start);
                            break;
                    }

                    if (coincide)
                    {
                        EntornoDTO entornoCaso = new EntornoDTO("Case", pilaEntornos.Peek());
                        pilaEntornos.Peek().punteroASiguiente = entornoCaso;
                        pilaEntornos.Push(entornoCaso);

                        Visit(casoContext.listainstrucciones());

                        pilaEntornos.Pop();
                        pilaEntornos.Peek().punteroASiguiente = null;

                        casoCumplido = true;
                        break; 
                    }
                }

                // Ejecucion de Default; sino hay coicidencias
                if (!casoCumplido && context.caso_default() != null)
                {
                    EntornoDTO entornoDefault = new EntornoDTO("Default", pilaEntornos.Peek());
                    pilaEntornos.Peek().punteroASiguiente = entornoDefault;
                    pilaEntornos.Push(entornoDefault);

                    Visit(context.caso_default().listainstrucciones());

                    pilaEntornos.Pop();
                    pilaEntornos.Peek().punteroASiguiente = null;
                }

                return true;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en instrucción switch: {ex.Message}", context.Start);
                return false;
            }
        }

        public override object VisitCaso([NotNull] AnalizadorLexicoParser.CasoContext context)
        {
            return Visit(context.listainstrucciones());
        }

        public override object VisitCaso_default([NotNull] AnalizadorLexicoParser.Caso_defaultContext context)
        {
            return Visit(context.listainstrucciones());
        }
        /*FIN SENTENCIAS DE CONTROL*/


        /* IMPRIMIR */
        public override Object VisitPrint([NotNull] AnalizadorLexicoParser.PrintContext context)
        {
            try
            {
                if (context.expr() != null)
                {
                    var resultado = Visit(context.expr());
                    if (resultado is Nativo)
                        listaSalida.Add(((Nativo)resultado).Valor);
                    else if (resultado is SimbolosDTO)
                        listaSalida.Add(((SimbolosDTO)resultado).valor);
                    else
                        listaSalida.Add(resultado);
                }
                return true;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en instrucción print: {ex.Message}", context.Start);
                return false;
            }
        }


        // //AUXILIARES
        private Nativo ConvertirANativo(object valor, IToken token)
        {
            if (valor is Nativo)
            {
                return (Nativo)valor;
            }
            else if (valor is SimbolosDTO)
            {
                var simbolo = (SimbolosDTO)valor;
                if (simbolo.valor is Nativo)
                {
                    return (Nativo)simbolo.valor;
                }
                else
                {
                    throw new Exception($"El valor de la variable '{simbolo.identificador}' no es un Nativo válido.");
                }
            }
            else
            {
                throw new Exception($"Tipo de dato no soportado para operación aritmética: {valor.GetType().Name}");
            }
        }
        // //FINAUXILIARES
    }
}