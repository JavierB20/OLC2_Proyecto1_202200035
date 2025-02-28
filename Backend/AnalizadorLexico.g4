grammar AnalizadorLexico;

options { caseInsensitive = false; }

NEWLINE : [ \r\n\t]+ -> channel(HIDDEN);
INT     : [0-9]+ ;
DECIMAL : [0-9]+('.'[0-9]+) ;
CARACTER : '\'' (ESC_SEQ | ~['\\\r\n]) '\'' ;
fragment ESC_SEQ : '\\' [btnr'\\] ; 
CADENA : '"' (ESC_SEQCA | ~["\\\r\n])* '"' ; 
fragment ESC_SEQCA : '\\' ["\\/bfnrt] ; 
BOOL : ('true'|'false') ;
PALABRA: [a-zA-Z]+('_')?([0-9]+)? ;
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip ;
COMENTARIO : '/*' .*? '*/' -> skip ;

IGUAL: '=' ;
DOSPUNTOS_IGUAL: ':=' ;
PARENTESIS_ABRE: '(' ;
PARENTESIS_CIERRA: ')' ;
ASIGNACION_SUMA: '+=' ;
ASIGNACION_RESTA: '-=' ;

inicio: listainstrucciones ;

listainstrucciones : instruccion (instruccion)* ;

instruccion: print 
| variables 
| asignacion 
| instruccion_if
;

print: 'fmt.Println' PARENTESIS_ABRE expr PARENTESIS_CIERRA ;

variables: 'var' PALABRA tipo (IGUAL expr)? #declaracionVar ;

asignacion: PALABRA signo=(IGUAL | DOSPUNTOS_IGUAL | ASIGNACION_SUMA | ASIGNACION_RESTA) expr #asignacionVar ;


tipo: 'int'
| 'float64'
| 'string'
| 'bool'
| 'rune'
;

instruccion_if: 'if' PARENTESIS_ABRE expr PARENTESIS_CIERRA 'then' listainstrucciones 'end if';

expr: '(' expr ')' #expreParentesis
|'[' expr ']' #expreCorchetes

| '-' right=expr #operadorNegativo

| INT #intExpresion
| DECIMAL #decimalExpresion
| CARACTER #caracterExpresion
| BOOL #boleanExpresion
| CADENA #cadenaExpresion
| PALABRA #idExpresion

| expr ('*'|'/') expr #multiplicacionYdivision
| expr ('+'|'-') expr #sumaYresta
| expr ('%') expr #modulo

| left=expr operador='&&' right=expr #operadorLogico
| left=expr operador='||' right=expr #operadorLogico
| '!' right=expr #operadorNegacion

| left=expr operador='==' right=expr #operadorRelacional
| left=expr operador='!=' right=expr #operadorRelacional
| left=expr operador='>=' right=expr #operadorRelacional
| left=expr operador='>' right=expr #operadorRelacional
| left=expr operador='<=' right=expr #operadorRelacional
| left=expr operador='<' right=expr #operadorRelacional
;