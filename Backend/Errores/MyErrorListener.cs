using Antlr4.Runtime;
using System;
using System.IO;


public class MyErrorListener : BaseErrorListener
{
    public List<string> Errores { get; } = new List<string>(); 

    public virtual void SyntaxError(
        IRecognizer recognizer,
        IToken offendingSymbol,
        int line,
        int charPositionInLine,
        string msg,
        RecognitionException e)
    {
        string errorMessage = $"Error en línea {line}, posición {charPositionInLine}: {msg}";
        Console.WriteLine("Algo");
        Errores.Add(errorMessage); 
    }
}
