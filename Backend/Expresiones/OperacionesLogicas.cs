using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using analyzer;
using Antlr4.Runtime;

namespace Backend.Expresiones
{
    public class OperacionesLogicas
    {
        public Nativo Operando1 { get; set; }
        public Nativo Operando2 { get; set; }
        public OperadorLogicos Operador { get; set; }

        public OperacionesLogicas(Nativo operando1, Nativo operando2, OperadorLogicos operador)
        {
            Operando1 = operando1;
            Operando2 = operando2;
            Operador = operador;
        }

        public static object RealizarOperacion(OperadorLogicos operador, Nativo operando1, ParserRuleContext context, List<ErrorInfo> erroresSemanticos)
        {
            try{
                switch(operador)
                {
                    case OperadorLogicos.NOT:
                        return OperacionNOT(operando1);
                    default:
                        throw new Exception("Operador no soportado");
                }
            }
            catch (Exception ex)
            {
                erroresSemanticos.Add(new ErrorInfo(
                    $"Error en operaciones logicas: {ex.Message}",
                    context.Start.Line,
                    context.Start.Column,
                    "Semántico"
                ));
                return null;
            }
            
        }        
        public static object RealizarOperacion(OperadorLogicos operador, Nativo operando1, Nativo operando2, ParserRuleContext context, List<ErrorInfo> erroresSemanticos)
        {
            try{
                switch(operador)
                {
                    case OperadorLogicos.AND:
                        return OperacionAND(operando1, operando2);
                    case OperadorLogicos.OR:
                        return OperacionOR(operando1, operando2);
                    default:
                        throw new Exception("Operador no soportado");
                }
            }
            catch (Exception ex)
            {
                erroresSemanticos.Add(new ErrorInfo(
                    $"Error en operaciones logicas: {ex.Message}",
                    context.Start.Line,
                    context.Start.Column,
                    "Semántico"
                ));
                return null;
            }
            
        }        

        private static object OperacionAND(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.BOOLEANO:
                    switch(tipo2) {
                        case TipoDato.BOOLEANO:
                            return new Nativo(Convert.ToBoolean(operando1.Valor) == Convert.ToBoolean(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de igualacion de booleano no soportada");
                    }
                default:
                    throw new Exception("Tipo de igualacion no soportada");
            }
        }
        private static object OperacionOR(Nativo operando1, Nativo operando2)
        {
            var tipo1 = operando1.Tipo;
            var tipo2 = operando2.Tipo;
            
            switch(tipo1) {
                case TipoDato.BOOLEANO:
                    switch(tipo2) {
                        case TipoDato.BOOLEANO:
                            return new Nativo(Convert.ToBoolean(operando1.Valor) || Convert.ToBoolean(operando2.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                        default:
                            throw new Exception("Tipo de or de booleano no soportada");
                    }
                default:
                    throw new Exception("Tipo de or no soportada");
            }
        }
        private static object OperacionNOT(Nativo operando1)
        {
            var tipo1 = operando1.Tipo;
            
            switch(tipo1) {
                case TipoDato.BOOLEANO:
                    return new Nativo(!Convert.ToBoolean(operando1.Valor), TipoDato.BOOLEANO, operando1.Linea, operando1.Columna);
                default:
                    throw new Exception("Tipo de not no soportada");
            }
        }
    }
}

public enum OperadorLogicos
{
    AND,
    OR,
    NOT
}