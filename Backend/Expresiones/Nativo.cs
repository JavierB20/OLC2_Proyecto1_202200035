using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Backend.Expresiones
{
    public class Nativo
    {
        private int resultado;
        private TipoDato iNT;
        private double resultado1;
        private TipoDato fLOAT64;

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

        public Nativo(int resultado, TipoDato iNT)
        {
            this.resultado = resultado;
            this.iNT = iNT;
        }

        public Nativo(double resultado1, TipoDato fLOAT64)
        {
            this.resultado1 = resultado1;
            this.fLOAT64 = fLOAT64;
        }
    }
}

public enum TipoDato
{
    INT,
    FLOAT64,
    BOOL,
    STRING,
    NULO,
    RUNE
}