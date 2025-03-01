using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Backend.Expresiones
{
    public class Nativo
    {
        public object Valor { get; set; }
        public TipoDato Tipo { get; set; }
        public int Linea { get; set; }
        public int Columna { get; set; }

        public Nativo(object valor, TipoDato tipo, int linea, int columna)
        {
            Valor = valor;
            Tipo = tipo;
            Linea = linea;
            Columna = columna;
        }
    }
}

public enum TipoDato
{
    ENTERO,
    DECIMAL,
    BOOLEANO,
    CADENA,
    NULO,
    RUNE
}