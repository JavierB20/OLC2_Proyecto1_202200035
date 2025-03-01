using System.Globalization;
using System.Net;
using System.Text.RegularExpressions;
using analyzer;
using Antlr4.Runtime.Misc;
using Microsoft.VisualBasic;

class Visitor : AnalizadorLexicoBaseVisitor<Object> {

    public Stack<EntornoDTO> pilaEntornos = new Stack<EntornoDTO>();
    public EntornoDTO entornoInicial;
    public List<Object> listaSalida = new List<Object>();

    public Visitor(EntornoDTO entorno) {
        this.entornoInicial = entorno;
        pilaEntornos.Push(entorno);
    }

    /* INICIO */
    public override Object VisitInicio([NotNull] AnalizadorLexicoParser.InicioContext context)
    {
        if (context.listainstrucciones() != null) {
            return VisitListainstrucciones(context.listainstrucciones());
        }
        return true;
    }

    public override Object VisitListainstrucciones([NotNull] AnalizadorLexicoParser.ListainstruccionesContext context)
    {
        if (context.instruccion() == null)
            return true;

        foreach (AnalizadorLexicoParser.InstruccionContext instruccion in context.instruccion()) {
            VisitInstruccion(instruccion);
        }
        return true;
    }

    public override Object VisitInstruccion([NotNull] AnalizadorLexicoParser.InstruccionContext context) {
        if (context == null) 
            return false;

        if (context.print() != null) 
            Visit(context.print());
        else if (context.variables() != null) 
            //BreakDTO instanciaBreak = (BreakDTO) Visit(context.variables());
            Visit(context.variables());            
        else if (context.asignacion() != null)
            Visit(context.asignacion());
        else if (context.instruccion_if() != null)
            Visit(context.instruccion_if());

        return true;
    }
    /*FIN INICIO*/

    //Datos PRIMITIVOS
    public override Object VisitCadenaExpresion([NotNull] AnalizadorLexicoParser.CadenaExpresionContext context) {
        string rawText = context.GetText().Substring(1, context.GetText().Length - 2);
        string processedText = Regex.Unescape(rawText);
        return processedText;
    }
    public override object VisitCaracterExpresion([NotNull] AnalizadorLexicoParser.CaracterExpresionContext context) {
        string rawText = context.GetText().Substring(1, context.GetText().Length - 2);
        string processedText = Regex.Unescape(rawText);
        return processedText;
    }
    public override object VisitBoleanExpresion([NotNull] AnalizadorLexicoParser.BoleanExpresionContext context) {
        if (context.BOOL().GetText() == "true")
            return true;
        else if (context.BOOL().GetText() == "false")
            return false;
        return "NULL";
    }
    public override Object VisitIntExpresion([NotNull] AnalizadorLexicoParser.IntExpresionContext context) {
        return int.Parse(context.INT().GetText()); 
    }
    public override Object VisitDecimalExpresion([NotNull] AnalizadorLexicoParser.DecimalExpresionContext context) {
        return double.Parse(context.DECIMAL().GetText(), CultureInfo.InvariantCulture);
    }
    //FIN DATOS PRIMITIVOS

    
    /* IMPRIMIR */
    public override Object VisitPrint([NotNull] AnalizadorLexicoParser.PrintContext context) {
        if (context.expr() != null) {
            Object consola = Visit(context.expr());
            listaSalida.Add(consola);
        }
        return true;
    }

    /* VARIABLES*/
    //DECLARACION
    public override Object VisitDeclaracionVar([NotNull] AnalizadorLexicoParser.DeclaracionVarContext context) {
        EntornoDTO entorno = pilaEntornos.Peek();
        string nombreVariable = context.PALABRA().GetText();
        string tipoVariable = context.tipo().GetText();
        Object? valor = null;

        if (!entorno.variables.ContainsKey(nombreVariable)) {
            if (context.expr() != null)
                valor = Visit(context.expr());
            else 
                valor = ValorPorDefecto(tipoVariable);

            entorno.guardarVariable(nombreVariable, new SimbolosDTO(nombreVariable, tipoVariable, valor));
            Console.WriteLine("Nombre de la variable " + nombreVariable + " valor " + valor);
        }
        return true;//new BreakDTO("continue");
    }

    //ASIGNACION
    public override Object VisitAsignacionVar([NotNull] AnalizadorLexicoParser.AsignacionVarContext context) {
        EntornoDTO entorno = pilaEntornos.Peek();
        string nombreVariable = context.PALABRA().GetText();
        string signo = context.GetChild(1).GetText();
        Object valor = Visit(context.expr());

        if (signo == ":=") {
            if (!entorno.variables.ContainsKey(nombreVariable)) {
                if (context.expr() != null)
                    valor = Visit(context.expr());
                /*else 
                    valor = ValorPorDefecto(valor.GetType());*/

                entorno.guardarVariable(nombreVariable, new SimbolosDTO(nombreVariable, "int", valor));
                Console.WriteLine("Nombre de la variable " + nombreVariable + " valor " + valor);
            }
        } else if (signo == "=") {
            entorno.actualizarValorSimbolo(nombreVariable, valor);
        } else if (signo == "+=") {
            var left = valor;
            var right = entorno.buscarVariable(nombreVariable).valor;

                if (left is int && right is int) {
                    int valorActualizado = (int)left + (int)right;
                    entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                }
                
                if (left is string && right is string) {
                    string valorActualizado = (string)left + (string)right;
                    entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                }

                if (left is double && right is double) {
                    double valorActualizado = (double)left + (double)right;
                    entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                }

                if ((left is double || left is int) && (right is double || right is int)) {
                    double leftValue = Convert.ToDouble(left);
                    double rightValue = Convert.ToDouble(right);
                    double valorActualizado = leftValue + rightValue;
                    entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                }

        } else if (signo == "-=") {
            var left = valor;
            var right = entorno.buscarVariable(nombreVariable).valor;

                if (left is int && right is int) {
                    int valorActualizado = (int)left + (int)right;
                    entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                }
                
                if (left is double && right is double) {
                    double valorActualizado = (double)left + (double)right;
                    entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                }

                if ((left is double || left is int) && (right is double || right is int)) {
                    double leftValue = Convert.ToDouble(left);
                    double rightValue = Convert.ToDouble(right);
                    double valorActualizado = leftValue + rightValue;
                    entorno.actualizarValorSimbolo(nombreVariable, valorActualizado);
                }
        }
        return true;
    }

    /*FIN DE VARIABLES*/

    /* INSTUCCION IF */
    public override object VisitInstruccion_if([NotNull] AnalizadorLexicoParser.Instruccion_ifContext context) {
        // validar expresion (tiene que existir y ser de tipo bool)
        if ((bool) Visit(context.expr())) {
            EntornoDTO entorno = new EntornoDTO("If", pilaEntornos.Peek());
            pilaEntornos.Peek().punteroASiguiente = entorno;
            pilaEntornos.Push(entorno);
            VisitListainstrucciones(context.listainstrucciones());
            pilaEntornos.Pop();
            pilaEntornos.Peek().punteroASiguiente = null;            
        }
        return "";
    }

    /* EXPRESIONES */
    //OPERACIONES ARITMETICAS
    public override Object VisitMultiplicacionYdivision([NotNull] AnalizadorLexicoParser.MultiplicacionYdivisionContext context) {
        string operador = context.GetChild(1).GetText();
        var left = Visit(context.expr(0));
        var rigth = Visit(context.expr(1));

        if (left is int && rigth is int) {
            return operador == "*" ? (int)left * (int)rigth : (int)left / (int)rigth;
        }

        if (left is double && rigth is double) {
            return operador == "*" ? (double)left * (double)rigth : (double)left / (double)rigth;
        }

        if ((left is double || left is int) && (rigth is double || rigth is int)) {
            double leftValue = Convert.ToDouble(left);
            double rigthValue = Convert.ToDouble(rigth);
            double resultado = operador == "*" ? leftValue * rigthValue : leftValue / rigthValue;
            return resultado;
        }

        return "-999999999999999999";
    }

    public override Object VisitSumaYresta([NotNull] AnalizadorLexicoParser.SumaYrestaContext context) {
        string operador = context.GetChild(1).GetText();
        var left =  Visit(context.expr(0));
        var right = Visit(context.expr(1));
        
        if (left is int && right is int) {
            return operador == "+" ? (int)left + (int)right : (int)left - (int)right;
        }
        
        if (left is string && right is string && operador == "+") {
            return (string)left + (string)right;
        }

        if (left is double && right is double) {
            double resultado = operador == "+" ? (double)left + (double)right : (double)left - (double)right;
            return resultado;
        }

        if ((left is double || left is int) && (right is double || right is int)) {
            double leftValue = Convert.ToDouble(left);
            double rightValue = Convert.ToDouble(right);
            double resultado = operador == "+" ? leftValue + rightValue : leftValue - rightValue;
            return resultado;
        }

        return -9999999999;
    }
   
    public override Object VisitModulo([NotNull] AnalizadorLexicoParser.ModuloContext context){
        var left = Visit(context.expr(0));
        var right = Visit(context.expr(1));
        if (left is int && right is int) {
            return (int)left % (int)right;
        }
        return -9999999999;
    }
    //FIN OPERACIONES ARITMETICAS
    public override Object VisitExpreParentesis(AnalizadorLexicoParser.ExpreParentesisContext context) {
        Console.WriteLine("Encontro expresion en parentesis");
        return Visit(context.expr());
    }

    public override Object VisitIdExpresion([NotNull] AnalizadorLexicoParser.IdExpresionContext context) {
        EntornoDTO entorno = pilaEntornos.Peek();
        SimbolosDTO? simbolo = entorno.buscarVariable(context.PALABRA().GetText());
        if (simbolo != null)  {
            return simbolo.valor;
        } 
        return "NULL";
    }



    public override Object VisitOperadorLogico([NotNull] AnalizadorLexicoParser.OperadorLogicoContext context) {
        string operador = context.GetChild(1).GetText();
        dynamic left = Visit(context.left);
        dynamic right = Visit(context.right);

        return operador switch {
            "&&" => left == right,
            "||" => left != right,
            _ => throw new Exception("Operador logico no reconocido: " + operador)
        };
    }

    public override Object VisitOperadorNegacion([NotNull] AnalizadorLexicoParser.OperadorNegacionContext context) {
        if ((bool) Visit(context.right)) 
            return false;
        else 
            return true;
    }

    public override Object VisitOperadorRelacional([NotNull] AnalizadorLexicoParser.OperadorRelacionalContext context) {
        string operador = context.GetChild(1).GetText();
        dynamic left = Visit(context.left);
        dynamic right = Visit(context.right);

        return operador switch {
            "==" => left == right,
            "!=" => left != right,
            ">"  => left > right,
            ">=" => left >= right,
            "<"  => left < right,
            "<=" => left <= right,
            _ => throw new Exception("Operador relacional no reconocido: " + operador)
        };
    }

    //AUXILIARES
    public Object ValorPorDefecto(string tipo) {
        return tipo switch {
            "int" => 0,
            "float64" => 0.0,
            "string" => "",
            "bool" => false,
            "rune" => "\0",
            _ => throw new Exception("Tipo desconocido")
        };
    }

    public bool TipoCompatible(string tipo, object valor){
        return tipo switch {
            "int" => valor is int,
            "float64" => valor is float,
            "string" => valor is string,
            "bool" => valor is bool,
            "rune" => valor is char,
            _ => throw new Exception("Tipo desconocido")
        };
    }
    //FINAUXILIARES



}