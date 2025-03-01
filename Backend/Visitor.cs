using System;
using System.Collections.Generic;
using System.Globalization;
using System.Net;
using System.Text.RegularExpressions;
using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
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

        // Helper method to add semantic errors
        private void AddSemanticError(string descripcion, IToken token)
        {
            erroresSemanticos.Add(new ErrorInfo(
                $"Error Semántico: {descripcion}",
                token.Line,
                token.Column,
                "Semántico"
            ));
            // Also add to output so user can see it
            listaSalida.Add($"Error Semántico: {descripcion} en línea {token.Line}, columna {token.Column}");
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
            }
            catch (Exception ex)
            {
                // Get the token for line and column info
                IToken token = context.Start;
                AddSemanticError(ex.Message, token);
            }

            return true;
        }
        /*FIN INICIO*/

        //Datos PRIMITIVOS
        public override Object VisitCadenaExpresion([NotNull] AnalizadorLexicoParser.CadenaExpresionContext context)
        {
            try
            {
                string rawText = context.GetText().Substring(1, context.GetText().Length - 2);
                string processedText = Regex.Unescape(rawText);
                return processedText;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error al procesar cadena: {ex.Message}", context.Start);
                return "";
            }
        }

        public override object VisitCaracterExpresion([NotNull] AnalizadorLexicoParser.CaracterExpresionContext context)
        {
            try
            {
                string rawText = context.GetText().Substring(1, context.GetText().Length - 2);
                string processedText = Regex.Unescape(rawText);
                return processedText;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error al procesar carácter: {ex.Message}", context.Start);
                return '\0';
            }
        }

        public override object VisitBoleanExpresion([NotNull] AnalizadorLexicoParser.BoleanExpresionContext context)
        {
            if (context.BOOL().GetText() == "true")
                return true;
            else if (context.BOOL().GetText() == "false")
                return false;

            AddSemanticError("Valor booleano no válido", context.Start);
            return false;
        }

        public override Object VisitIntExpresion([NotNull] AnalizadorLexicoParser.IntExpresionContext context)
        {
            try
            {
                return int.Parse(context.INT().GetText());
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error al procesar entero: {ex.Message}", context.Start);
                return 0;
            }
        }

        public override Object VisitDecimalExpresion([NotNull] AnalizadorLexicoParser.DecimalExpresionContext context)
        {
            try
            {
                return double.Parse(context.DECIMAL().GetText(), CultureInfo.InvariantCulture);
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error al procesar decimal: {ex.Message}", context.Start);
                return 0.0;
            }
        }
        //FIN DATOS PRIMITIVOS

        /* IMPRIMIR */
        public override Object VisitPrint([NotNull] AnalizadorLexicoParser.PrintContext context)
        {
            try
            {
                if (context.expr() != null)
                {
                    Object consola = Visit(context.expr());
                    listaSalida.Add(consola);
                }
                return true;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en instrucción print: {ex.Message}", context.Start);
                return false;
            }
        }

        /* VARIABLES*/
        //DECLARACION
        public override Object VisitDeclaracionVar([NotNull] AnalizadorLexicoParser.DeclaracionVarContext context)
        {
            try
            {
                EntornoDTO entorno = pilaEntornos.Peek();
                string nombreVariable = context.PALABRA().GetText();
                string tipoVariable = context.tipo().GetText();
                Object? valor = null;

                if (!entorno.variables.ContainsKey(nombreVariable))
                {
                    if (context.expr() != null)
                    {
                        valor = Visit(context.expr());
                        
                        // Type compatibility check
                        if (!TipoCompatible(tipoVariable, valor))
                        {
                            AddSemanticError($"Tipo de dato incompatible en asignación a variable '{nombreVariable}'. Se esperaba {tipoVariable}", context.Start);
                            valor = ValorPorDefecto(tipoVariable);
                        }
                    }
                    else
                        valor = ValorPorDefecto(tipoVariable);

                    entorno.guardarVariable(nombreVariable, new SimbolosDTO(nombreVariable, tipoVariable, valor));
                    Console.WriteLine("Nombre de la variable " + nombreVariable + " valor " + valor);
                }
                else
                {
                    AddSemanticError($"Variable '{nombreVariable}' ya ha sido declarada en este ámbito", context.Start);
                }
                return true;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en declaración de variable: {ex.Message}", context.Start);
                return false;
            }
        }

        //ASIGNACION
        public override Object VisitAsignacionVar([NotNull] AnalizadorLexicoParser.AsignacionVarContext context)
        {
            try
            {
                EntornoDTO entorno = pilaEntornos.Peek();
                string nombreVariable = context.PALABRA().GetText();
                string signo = context.GetChild(1).GetText();
                Object valor = Visit(context.expr());

                if (signo == ":=")
                {
                    if (!entorno.variables.ContainsKey(nombreVariable))
                    {
                        if (context.expr() != null)
                            valor = Visit(context.expr());

                        entorno.guardarVariable(nombreVariable, new SimbolosDTO(nombreVariable, "int", valor));
                        Console.WriteLine("Nombre de la variable " + nombreVariable + " valor " + valor);
                    }
                    else
                    {
                        AddSemanticError($"Variable '{nombreVariable}' ya ha sido declarada en este ámbito", context.Start);
                    }
                }
                else if (signo == "=")
                {
                    var simbolo = entorno.buscarVariable(nombreVariable);
                    if (simbolo == null)
                    {
                        AddSemanticError($"Variable '{nombreVariable}' no ha sido declarada", context.Start);
                        return false;
                    }
                    
                    // Type compatibility check
                    if (!TipoCompatible(simbolo.tipo, valor))
                    {
                        AddSemanticError($"Tipo de dato incompatible en asignación a variable '{nombreVariable}'. Se esperaba {simbolo.tipo}", context.Start);
                        return false;
                    }
                    
                    entorno.actualizarValorSimbolo(nombreVariable, valor);
                }
                else if (signo == "+=")
                {
                    var simbolo = entorno.buscarVariable(nombreVariable);
                    if (simbolo == null)
                    {
                        AddSemanticError($"Variable '{nombreVariable}' no ha sido declarada", context.Start);
                        return false;
                    }
                    
                    var right = simbolo.valor;
                    var left = valor;

                    if (left is int && right is int)
                    {
                        int valorActualizado = (int)left + (int)right;
                        entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                    }
                    else if (left is string && right is string)
                    {
                        string valorActualizado = (string)left + (string)right;
                        entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                    }
                    else if (left is double && right is double)
                    {
                        double valorActualizado = (double)left + (double)right;
                        entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                    }
                    else if ((left is double || left is int) && (right is double || right is int))
                    {
                        double leftValue = Convert.ToDouble(left);
                        double rightValue = Convert.ToDouble(right);
                        double valorActualizado = leftValue + rightValue;
                        entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                    }
                    else
                    {
                        AddSemanticError($"No se puede aplicar el operador += para los tipos de datos de '{nombreVariable}' y la expresión", context.Start);
                    }
                }
                else if (signo == "-=")
                {
                    var simbolo = entorno.buscarVariable(nombreVariable);
                    if (simbolo == null)
                    {
                        AddSemanticError($"Variable '{nombreVariable}' no ha sido declarada", context.Start);
                        return false;
                    }
                    
                    var right = simbolo.valor;
                    var left = valor;

                    if (left is int && right is int)
                    {
                        int valorActualizado = (int)right - (int)left;
                        entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                    }
                    else if (left is double && right is double)
                    {
                        double valorActualizado = (double)right - (double)left;
                        entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                    }
                    else if ((left is double || left is int) && (right is double || right is int))
                    {
                        double leftValue = Convert.ToDouble(left);
                        double rightValue = Convert.ToDouble(right);
                        double valorActualizado = rightValue - leftValue;
                        entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                    }
                    else
                    {
                        AddSemanticError($"No se puede aplicar el operador -= para los tipos de datos de '{nombreVariable}' y la expresión", context.Start);
                    }
                }
                return true;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en asignación de variable: {ex.Message}", context.Start);
                return false;
            }
        }
        /*FIN DE VARIABLES*/

        /* INSTUCCION IF */
        public override object VisitInstruccion_if([NotNull] AnalizadorLexicoParser.Instruccion_ifContext context)
        {
            try
            {
                var exprResult = Visit(context.expr());
                if (!(exprResult is bool))
                {
                    AddSemanticError("La expresión en la instrucción if debe ser de tipo booleano", context.expr().Start);
                    return false;
                }
                
                if ((bool)exprResult)
                {
                    EntornoDTO entorno = new EntornoDTO("If", pilaEntornos.Peek());
                    pilaEntornos.Peek().punteroASiguiente = entorno;
                    pilaEntornos.Push(entorno);
                    VisitListainstrucciones(context.listainstrucciones());
                    pilaEntornos.Pop();
                    pilaEntornos.Peek().punteroASiguiente = null;
                }
                return true;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en instrucción if: {ex.Message}", context.Start);
                return false;
            }
        }

        //OPERACIONES ARITMETICAS
        public override Object VisitMultiplicacionYdivision([NotNull] AnalizadorLexicoParser.MultiplicacionYdivisionContext context)
        {
            try
            {
                string operador = context.GetChild(1).GetText();
                var left = Visit(context.expr(0));
                var right = Visit(context.expr(1));

                if (left is int && right is int)
                {
                    if (operador == "/" && (int)right == 0)
                    {
                        AddSemanticError("División por cero", context.Start);
                        return 0;
                    }
                    return operador == "*" ? (int)left * (int)right : (int)left / (int)right;
                }

                if (left is double && right is double)
                {
                    if (operador == "/" && (double)right == 0)
                    {
                        AddSemanticError("División por cero", context.Start);
                        return 0.0;
                    }
                    return operador == "*" ? (double)left * (double)right : (double)left / (double)right;
                }

                if ((left is double || left is int) && (right is double || right is int))
                {
                    double leftValue = Convert.ToDouble(left);
                    double rightValue = Convert.ToDouble(right);
                    
                    if (operador == "/" && rightValue == 0)
                    {
                        AddSemanticError("División por cero", context.Start);
                        return 0.0;
                    }
                    
                    double resultado = operador == "*" ? leftValue * rightValue : leftValue / rightValue;
                    return resultado;
                }

                AddSemanticError($"No se puede aplicar el operador {operador} a los tipos proporcionados", context.Start);
                return 0;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación de multiplicación/división: {ex.Message}", context.Start);
                return 0;
            }
        }

        public override Object VisitSumaYresta([NotNull] AnalizadorLexicoParser.SumaYrestaContext context)
        {
            try
            {
                string operador = context.GetChild(1).GetText();
                var left = Visit(context.expr(0));
                var right = Visit(context.expr(1));

                if (left is int && right is int)
                {
                    return operador == "+" ? (int)left + (int)right : (int)left - (int)right;
                }

                if (left is string && right is string && operador == "+")
                {
                    return (string)left + (string)right;
                }
                else if ((left is string || right is string) && operador == "-")
                {
                    AddSemanticError("No se puede aplicar el operador - a strings", context.Start);
                    return "";
                }

                if (left is double && right is double)
                {
                    double resultado = operador == "+" ? (double)left + (double)right : (double)left - (double)right;
                    return resultado;
                }

                if ((left is double || left is int) && (right is double || right is int))
                {
                    double leftValue = Convert.ToDouble(left);
                    double rightValue = Convert.ToDouble(right);
                    double resultado = operador == "+" ? leftValue + rightValue : leftValue - rightValue;
                    return resultado;
                }

                AddSemanticError($"No se puede aplicar el operador {operador} a los tipos proporcionados", context.Start);
                return 0;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación de suma/resta: {ex.Message}", context.Start);
                return 0;
            }
        }

        public override Object VisitModulo([NotNull] AnalizadorLexicoParser.ModuloContext context)
        {
            try
            {
                var left = Visit(context.expr(0));
                var right = Visit(context.expr(1));
                
                if (left is int && right is int)
                {
                    if ((int)right == 0)
                    {
                        AddSemanticError("Módulo por cero", context.Start);
                        return 0;
                    }
                    return (int)left % (int)right;
                }
                
                AddSemanticError("El operador módulo solo es válido para enteros", context.Start);
                return 0;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación de módulo: {ex.Message}", context.Start);
                return 0;
            }
        }

        public override Object VisitOperadorNegativo([NotNull] AnalizadorLexicoParser.OperadorNegativoContext context)
        {
            try
            {
                var number = Visit(context.right);
                
                if (number is int)
                {
                    return -1 * (int)number;
                }
                
                if (number is double)
                {
                    return -1 * (double)number;
                }

                AddSemanticError("El operador negativo solo es válido para números", context.Start);
                return 0;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operador negativo: {ex.Message}", context.Start);
                return 0;
            }
        }
        //FIN OPERACIONES ARITMETICAS

        //OPERACIONES RELACIONALES  
        public override Object VisitOperadorRelacional([NotNull] AnalizadorLexicoParser.OperadorRelacionalContext context)
        {
            try
            {
                string operador = context.GetChild(1).GetText();
                dynamic left = Visit(context.left);
                dynamic right = Visit(context.right);

                // Check type compatibility for comparison
                if (!AreComparable(left, right))
                {
                    AddSemanticError($"No se pueden comparar tipos incompatibles con el operador {operador}", context.Start);
                    return false;
                }

                return operador switch
                {
                    "==" => left == right,
                    "!=" => left != right,
                    ">" => left > right,
                    ">=" => left >= right,
                    "<" => left < right,
                    "<=" => left <= right,
                    _ => throw new Exception("Operador relacional no reconocido: " + operador)
                };
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación relacional: {ex.Message}", context.Start);
                return false;
            }
        }
        //FIN OPERACIONES RELACIONALES

        //OPERACIONES LOGICAS
        public override Object VisitOperadorLogico([NotNull] AnalizadorLexicoParser.OperadorLogicoContext context)
        {
            try
            {
                string operador = context.GetChild(1).GetText();
                dynamic left = Visit(context.left);
                dynamic right = Visit(context.right);

                // Check that both operands are boolean
                if (!(left is bool) || !(right is bool))
                {
                    AddSemanticError($"Los operadores lógicos requieren operandos booleanos", context.Start);
                    return false;
                }

                return operador switch
                {
                    "&&" => (bool)left && (bool)right,
                    "||" => (bool)left || (bool)right,
                    _ => throw new Exception("Operador lógico no reconocido: " + operador)
                };
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operación lógica: {ex.Message}", context.Start);
                return false;
            }
        }

        public override Object VisitOperadorNegacion([NotNull] AnalizadorLexicoParser.OperadorNegacionContext context)
        {
            try
            {
                var result = Visit(context.right);
                
                if (!(result is bool))
                {
                    AddSemanticError("El operador de negación requiere un operando booleano", context.Start);
                    return false;
                }
                
                return !(bool)result;
            }
            catch (Exception ex)
            {
                AddSemanticError($"Error en operador de negación: {ex.Message}", context.Start);
                return false;
            }
        }
        //FIN OPERACIONES LOGICAS

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

        //AUXILIARES
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

        public override Object VisitIdExpresion([NotNull] AnalizadorLexicoParser.IdExpresionContext context)
        {
            EntornoDTO entorno = pilaEntornos.Peek();
            string variableName = context.PALABRA().GetText();
            SimbolosDTO? simbolo = entorno.buscarVariable(variableName);
            
            if (simbolo != null)
            {
                return simbolo.valor;
            }
            
            AddSemanticError($"Variable '{variableName}' no ha sido declarada", context.Start);
            return "NULL";
        }

        public bool TipoCompatible(string tipo, object valor)
        {
            try
            {
                return tipo switch
                {
                    "int" => valor is int,
                    "float64" => valor is double || valor is int, // int can be assigned to float64
                    "string" => valor is string,
                    "bool" => valor is bool,
                    "rune" => valor is string && ((string)valor).Length == 1,
                    _ => throw new Exception("Tipo desconocido")
                };
            }
            catch
            {
                return false;
            }
        }

        private bool AreComparable(object left, object right)
        {
            // Numbers can be compared with numbers
            if ((left is int || left is double) && (right is int || right is double))
                return true;
                
            // Strings can be compared with strings
            if (left is string && right is string)
                return true;
                
            // Booleans can be compared with booleans
            if (left is bool && right is bool)
                return true;
                
            return false;
        }
        //FINAUXILIARES
    }
}