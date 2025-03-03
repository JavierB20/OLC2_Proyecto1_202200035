grammar AnalizadorLexico;

options { caseInsensitive = false; }

NEWLINE : [ \r\n\t]+ -> channel(HIDDEN);

INT     : [0-9]+ ;
DECIMAL : [0-9]+'.'[0-9]+ ; 
fragment ESC_SEQ : '\\' ["'\\tnr] ;
CARACTER : '\'' (ESC_SEQ | ~['\\\r\n]) '\'' ;
CADENA : '"' (ESC_SEQ | ~["\\\r\n])* '"' ; 
BOOL : ('true'|'false') ;

ID: [a-zA-Z_][a-zA-Z0-9_]* ; 

// Comentarios
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip ;
COMENTARIO_BLOQUE : '/*' .*? '*/' -> skip ;  


// Operadores
IGUAL: '=' ;
DOSPUNTOS_IGUAL: ':=' ;
PARENTESIS_ABRE: '(' ;
PARENTESIS_CIERRA: ')' ;
CORCHETE_ABRE: '[' ;
CORCHETE_CIERRA: ']' ;
LLAVE_ABRE: '{' ;
LLAVE_CIERRA: '}' ;
ASIGNACION_SUMA: '+=' ;
ASIGNACION_RESTA: '-=' ;
MAS: '+' ;
MENOS: '-' ;
MULT: '*' ;
DIV: '/' ;
MODULO: '%' ;
Y_LOGICO: '&&' ;
O_LOGICO: '||' ;
NEGACION: '!' ;
IGUAL_IGUAL: '==' ;
DIFERENTE: '!=' ;
MAYOR_IGUAL: '>=' ;
MAYOR: '>' ;
MENOR_IGUAL: '<=' ;
MENOR: '<' ;
INCREMENTO: '++';
DECREMENTO: '--';

inicio: listainstrucciones EOF;

listainstrucciones : instruccion* ;

instruccion: print 
            | variables 
            | asignacion 
            | instruccion_if
            | instruccion_switch
            | incrementoDecremento
            | instruccion_for
            | instruccion_forcondicional
            ;

print: 'fmt.Println' PARENTESIS_ABRE expr PARENTESIS_CIERRA ;

variables: 'var' identificador=ID tipoVar=tipo (IGUAL valor=expr)? #declaracionVar ;

asignacion: ID signo=(IGUAL | DOSPUNTOS_IGUAL | ASIGNACION_SUMA | ASIGNACION_RESTA) expr #asignacionVar ;

incrementoDecremento: ID (INCREMENTO | DECREMENTO) #incrementoDecrementoInstruccion ;

instruccion_for: 'for' expr LLAVE_ABRE listainstrucciones LLAVE_CIERRA ;

instruccion_forcondicional : 'for' asignacion ';' expr ';' incrementoDecremento LLAVE_ABRE listainstrucciones LLAVE_CIERRA ;

tipo: 'int'
    | 'float64'
    | 'string'
    | 'bool'
    | 'rune'
    ;

instruccion_if: 'if' PARENTESIS_ABRE expr PARENTESIS_CIERRA LLAVE_ABRE listainstrucciones LLAVE_CIERRA 
                ( 'else' (instruccion_if | LLAVE_ABRE listainstrucciones LLAVE_CIERRA) )?;

instruccion_switch: 'switch' expr  LLAVE_ABRE 
                    (caso)* 
                    (caso_default)? 
                    LLAVE_CIERRA;

caso: 'case' expr ':' listainstrucciones;

caso_default: 'default' ':' listainstrucciones;

expr: '(' expr ')' #expreParentesis
    | '[' expr ']' #expreCorchetes

    | operador='-' right=expr #operadorNegativo
    | operador='!' right=expr #operadorNegacion

    | left=expr operador=('*'|'/') right=expr #multiplicacionYdivision
    | left=expr operador='%' right=expr #modulo
    | left=expr operador=('+'|'-') right=expr #sumaYresta

    | left=expr operador='<' right=expr #operadorRelacional
    | left=expr operador='<=' right=expr #operadorRelacional
    | left=expr operador='>' right=expr #operadorRelacional
    | left=expr operador='>=' right=expr #operadorRelacional
    | left=expr operador='==' right=expr #operadorRelacional
    | left=expr operador='!=' right=expr #operadorRelacional

    | left=expr operador='&&' right=expr #operadorLogico
    | left=expr operador='||' right=expr #operadorLogico

    | INT #intExpresion
    | DECIMAL #decimalExpresion
    | CARACTER #caracterExpresion
    | BOOL #boleanExpresion
    | CADENA #cadenaExpresion
    | ID #idExpresion
    ;

