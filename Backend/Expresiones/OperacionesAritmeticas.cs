using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using analyzer;
using Antlr4.Runtime;

namespace Backend.Expresiones
{
    public class OperacionesAritmeticas
    {
        public Nativo Operando1 { get; set; }
        public Nativo Operando2 { get; set; }
        public OperadorAritmetico Operador { get; set; }
        public OperacionesAritmeticas(Nativo operando1, Nativo operando2, OperadorAritmetico operador)
        {
            Operando1 = operando1;
            Operando2 = operando2;
            Operador = operador;
        }
       
        public static object RealizarOperacion(OperadorAritmetico operador, Nativo operando1, ParserRuleContext context, List<ErrorInfo> erroresSemanticos)        {
            try
            {
                switch (operador)
                {
                    case OperadorAritmetico.NEGACION:
                        return Negacion(operando1);
                    default:
                        throw new Exception("Operador no soportado");
                }
            }
            catch (Exception ex)
            {
                erroresSemanticos.Add(new ErrorInfo(
                    $"Error en operación aritmética: {ex.Message}",
                    context.Start.Line,
                    context.Start.Column,
                    "Semántico"
                ));
                return null;
            }
        }
        public static object RealizarOperacion(OperadorAritmetico operador, Nativo operando1, Nativo operando2, ParserRuleContext context, List<ErrorInfo> erroresSemanticos)        {
            try
            {
                switch (operador)
                {
                    case OperadorAritmetico.SUMA:
                        return Suma(operando1, operando2);
                    case OperadorAritmetico.RESTA:
                        return Resta(operando1, operando2);
                    case OperadorAritmetico.MULTIPLICACION:
                        return Multiplicacion(operando1, operando2);
                    case OperadorAritmetico.DIVISION:
                        return Division(operando1, operando2);
                    case OperadorAritmetico.MODULO:
                        return Modulo(operando1, operando2);
                    case OperadorAritmetico.NEGACION:
                        return Negacion(operando1);
                    default:
                        throw new Exception("Operador no soportado");
                }
            }
            catch (Exception ex)
            {
                erroresSemanticos.Add(new ErrorInfo(
                    $"Error en operación aritmética: {ex.Message}",
                    context.Start.Line,
                    context.Start.Column,
                    "Semántico"
                ));
                return null;
            }
        }

        private static object Suma(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.INT:
                    switch(tipo2) {
                        case TipoDato.INT:
                            return new Nativo(Convert.ToInt32(operando1.Valor) + Convert.ToInt32(operando2.Valor), TipoDato.INT, operando1.Linea, operando1.Columna);
                        case TipoDato.FLOAT64:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) + Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de suma INT no soportada");
                    }
                case TipoDato.FLOAT64:
                    switch(tipo2) {
                        case TipoDato.INT:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) + Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        case TipoDato.FLOAT64:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) + Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de suma flotante no soportada");
                    }
                case TipoDato.STRING:
                    switch(tipo2) {
                        case TipoDato.STRING:
                            return new Nativo(operando1.Valor.ToString() + operando2.Valor.ToString(), TipoDato.STRING, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de suma cadena no soportada");
                    }
                default:
                    throw new Exception("Tipo de resta no soportada");
            }
        }
        private static object Resta(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.INT:
                    switch(tipo2) {
                        case TipoDato.INT:
                            return new Nativo(Convert.ToInt32(operando1.Valor) - Convert.ToInt32(operando2.Valor), TipoDato.INT, operando1.Linea, operando1.Columna);
                        case TipoDato.FLOAT64:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) - Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de resta INT no soportada");
                    }
                case TipoDato.FLOAT64:
                    switch(tipo2) {
                        case TipoDato.INT:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) - Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        case TipoDato.FLOAT64:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) - Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de resta flotante no soportada");
                    }
                default:
                    throw new Exception("Tipo de resta no soportada");
            }
        }
        private static object Multiplicacion(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.INT:
                    switch(tipo2) {
                        case TipoDato.INT:
                            return new Nativo(Convert.ToInt32(operando1.Valor) * Convert.ToInt32(operando2.Valor), TipoDato.INT, operando1.Linea, operando1.Columna);
                        case TipoDato.FLOAT64:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) * Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de multiplicacion INT no soportada");
                    }
                case TipoDato.FLOAT64:
                    switch(tipo2) {
                        case TipoDato.INT:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) - Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        case TipoDato.FLOAT64:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) - Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de multiplicacion flotante no soportada");
                    }
                default:
                    throw new Exception("Tipo de multiplicacion no soportada");
            }
        }
        private static object Division(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.INT:
                    switch(tipo2) {
                        case TipoDato.INT:
                            return new Nativo(Convert.ToInt32(operando1.Valor) / Convert.ToInt32(operando2.Valor), TipoDato.INT, operando1.Linea, operando1.Columna);
                        case TipoDato.FLOAT64:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) / Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de division INT no soportada");
                    }
                case TipoDato.FLOAT64:
                    switch(tipo2) {
                        case TipoDato.INT:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) / Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        case TipoDato.FLOAT64:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) / Convert.ToDecimal(operando2.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de division flotante no soportada");
                    }
                default:
                    throw new Exception("Tipo de division no soportada");
            }
        }
        private static object Modulo(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.INT:
                    switch(tipo2) {
                        case TipoDato.INT:
                            return new Nativo(Convert.ToInt32(operando1.Valor) % Convert.ToInt32(operando2.Valor), TipoDato.INT, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de modulo INT no soportada");
                    }
                default:
                    throw new Exception("Tipo de modulo no soportada");
            }
        }
        private static object Negacion(Nativo operando1)
            {
                var tipo1 = operando1.Tipo;
                
                switch(tipo1) {
                    case TipoDato.INT:
                        return new Nativo(-1 * Convert.ToInt32(operando1.Valor), TipoDato.INT, operando1.Linea, operando1.Columna);
                    case TipoDato.FLOAT64:
                        return new Nativo(-1 * Convert.ToDecimal(operando1.Valor), TipoDato.FLOAT64, operando1.Linea, operando1.Columna);
                    default:
                        throw new Exception("Tipo de negacion no soportada");
                }
            }
    }
}


public enum OperadorAritmetico
{
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    MODULO,
    NEGACION,
}