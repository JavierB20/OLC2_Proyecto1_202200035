using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using analyzer;
using Antlr4.Runtime;

namespace Backend.Expresiones
{
    public class OperacionesRelacionales
    {
        public Nativo Operando1 { get; set; }
        public Nativo Operando2 { get; set; }
        public OperadorRelacionales Operador { get; set; }       

        public OperacionesRelacionales(Nativo operando1, Nativo operando2, OperadorRelacionales operador)
        {
            Operando1 = operando1;
            Operando2 = operando2;
            Operador = operador;
        }

        public static object RealizarOperacion(OperadorRelacionales operador, Nativo operando1, Nativo operando2, ParserRuleContext context, List<ErrorInfo> erroresSemanticos)        
        {
            try
            {
                switch (operador)
                {
                    case OperadorRelacionales.IGUALACION:
                        return Igualacion(operando1, operando2);
                    case OperadorRelacionales.DIFERENCIA:
                        return Diferencia(operando1, operando2);
                    case OperadorRelacionales.MENORQUE:
                        return MenorQue(operando1, operando2);
                    case OperadorRelacionales.MENOROIGUAL:
                        return MenorIGualQue(operando1, operando2);
                    case OperadorRelacionales.MAYORQUE:
                        return MayorQue(operando1, operando2);
                    case OperadorRelacionales.MAYOROIGUAL:
                        return MayorIGualQue(operando1, operando2);
                    default:
                        throw new Exception("Operador no soportado");
                }
            }
            catch (Exception ex)
            {
                erroresSemanticos.Add(new ErrorInfo(
                    $"Error en operaciones relacionales: {ex.Message}",
                    context.Start.Line,
                    context.Start.Column,
                    "Semántico"
                ));
                return null;
            }
        }

        private static object Igualacion(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.ENTERO:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToInt32(operando1.Valor) == Convert.ToInt32(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) == Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de igualacion entero no soportada");
                    }
                case TipoDato.DECIMAL:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) == Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) == Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de igualacion flotante no soportada");
                    }
                case TipoDato.BOOLEANO:
                    switch(tipo2) {
                        case TipoDato.BOOLEANO:
                            return new Nativo(Convert.ToBoolean(operando1.Valor) == Convert.ToBoolean(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de igualacion booleano no soportada");
                    }
                case TipoDato.CADENA:
                    switch(tipo2) {
                        case TipoDato.CADENA:
                            return new Nativo(Convert.ToString(operando1.Valor) == Convert.ToString(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de igualacion cadena no soportada");
                    }
                case TipoDato.RUNE:
                    switch(tipo2) {
                        case TipoDato.RUNE:
                            return new Nativo(Convert.ToChar(operando1.Valor) == Convert.ToChar(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de igualacion rune no soportada");
                    }
                default:
                    throw new Exception("Tipo de igualacion no soportada");
            }
        }
        private static object Diferencia(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.ENTERO:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToInt32(operando1.Valor) != Convert.ToInt32(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) != Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de negacion entero no soportada");
                    }
                case TipoDato.DECIMAL:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) != Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) != Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de negacion flotante no soportada");
                    }
                case TipoDato.BOOLEANO:
                    switch(tipo2) {
                        case TipoDato.BOOLEANO:
                            return new Nativo(Convert.ToBoolean(operando1.Valor) != Convert.ToBoolean(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de negacion booleano no soportada");
                    }
                case TipoDato.CADENA:
                    switch(tipo2) {
                        case TipoDato.CADENA:
                            return new Nativo(Convert.ToString(operando1.Valor) != Convert.ToString(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de negacion cadena no soportada");
                    }
                case TipoDato.RUNE:
                    switch(tipo2) {
                        case TipoDato.RUNE:
                            return new Nativo(Convert.ToChar(operando1.Valor) != Convert.ToChar(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de negacion rune no soportada");
                    }
                default:
                    throw new Exception("Tipo de negacion no soportada");
            }
        }
        private static object MenorQue(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.ENTERO:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToInt32(operando1.Valor) < Convert.ToInt32(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) < Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de menor que entero no soportada");
                    }
                case TipoDato.DECIMAL:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) < Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) < Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de menor que flotante no soportada");
                    }
                case TipoDato.RUNE:
                    switch(tipo2) {
                        case TipoDato.RUNE:
                            return new Nativo(Convert.ToChar(operando1.Valor) < Convert.ToChar(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de menor que rune no soportada");
                    }
                default:
                    throw new Exception("Tipo de menor que no soportada");
            }
        }
        private static object MenorIGualQue(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.ENTERO:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToInt32(operando1.Valor) <= Convert.ToInt32(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) <= Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de menor o igual que entero no soportada");
                    }
                case TipoDato.DECIMAL:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) <= Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) <= Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de menor o igual que flotante no soportada");
                    }
                case TipoDato.RUNE:
                    switch(tipo2) {
                        case TipoDato.RUNE:
                            return new Nativo(Convert.ToChar(operando1.Valor) <= Convert.ToChar(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de menor o igual que rune no soportada");
                    }
                default:
                    throw new Exception("Tipo de menor o igual que no soportada");
            }
        }
        private static object MayorQue(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.ENTERO:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToInt32(operando1.Valor) > Convert.ToInt32(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) > Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de mayor que entero no soportada");
                    }
                case TipoDato.DECIMAL:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) > Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) > Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de mayor que flotante no soportada");
                    }
                case TipoDato.RUNE:
                    switch(tipo2) {
                        case TipoDato.RUNE:
                            return new Nativo(Convert.ToChar(operando1.Valor) > Convert.ToChar(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de mayor que rune no soportada");
                    }
                default:
                    throw new Exception("Tipo de mayor que no soportada");
            }
        }
        private static object MayorIGualQue(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.ENTERO:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToInt32(operando1.Valor) >= Convert.ToInt32(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) >= Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de mayor o igual que entero no soportada");
                    }
                case TipoDato.DECIMAL:
                    switch(tipo2) {
                        case TipoDato.ENTERO:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) >= Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        case TipoDato.DECIMAL:
                            return new Nativo(Convert.ToDecimal(operando1.Valor) >= Convert.ToDecimal(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de mayor o igual que flotante no soportada");
                    }
                case TipoDato.RUNE:
                    switch(tipo2) {
                        case TipoDato.RUNE:
                            return new Nativo(Convert.ToChar(operando1.Valor) >= Convert.ToChar(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de mayor o igual que rune no soportada");
                    }
                default:
                    throw new Exception("Tipo de mayor o igual que no soportada");
            }
        }    
    }
}

public enum OperadorRelacionales
{
    IGUALACION,
    DIFERENCIA,
    MENORQUE,
    MENOROIGUAL,
    MAYORQUE,
    MAYOROIGUAL
}