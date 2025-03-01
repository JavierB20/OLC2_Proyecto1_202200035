using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.IO;

namespace analyzer
{
    public class ErrorInfo
    {
        public string Descripcion { get; set; }
        public int Linea { get; set; }
        public int Columna { get; set; }
        public string Tipo { get; set; }

        public ErrorInfo(string descripcion, int linea, int columna, string tipo)
        {
            Descripcion = descripcion;
            Linea = linea;
            Columna = columna;
            Tipo = tipo;
        }
    }

    public class CustomErrorListener : IAntlrErrorListener<int>, IAntlrErrorListener<IToken>
    {
        public List<ErrorInfo> Errores { get; } = new List<ErrorInfo>();

        // Implementación para el lexer (IAntlrErrorListener<int>)
        public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            Errores.Add(new ErrorInfo(
                $"Error Léxico: {msg}", 
                line, 
                charPositionInLine,
                "Léxico"
            ));
        }

        // Implementación para el parser (IAntlrErrorListener<IToken>)
        public void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            Errores.Add(new ErrorInfo(
                $"Error Sintáctico: {msg}", 
                line, 
                charPositionInLine,
                "Sintáctico"
            ));
        }
    }
}