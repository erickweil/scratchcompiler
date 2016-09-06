grammar Simple;
@header {
    package br.erickweil.simplelang.generated;
}

file: block*;

block: IDENTIFIER statement;

statement : (assignment SEMICOLON) | (unarystat SEMICOLON) | if_stat | while_stat | for_stat | dowhile_stat | switch_stat | '{' statement* '}';

if_stat : 'if' expr statement ('else' statement)?;

for_stat: 'for' '(' (assignment | unarystat)? SEMICOLON expr? SEMICOLON (assignment | unarystat)? ')' statement;

while_stat : 'while' expr statement;
dowhile_stat : 'do' statement 'while' expr SEMICOLON;

switch_stat : 'switch' expr '{' cases '}';
cases: (case_label | default_label)*;
case_label: 'case' expr ':' statement*;
default_label: 'default' ':' statement*;

assignment : (variable | arrayaccess) ASSIGNOP (arraycreation | expr);

unarystat:
  variable DOUBLEADDMINUS
| DOUBLEADDMINUS variable
;

expr : 
  (arrayaccess | methodcall)
| expr (DOT | DOUBLEADDMINUS)
| (DOUBLEADDMINUS | ADDMINUS | NOTCOMP) expr
| expr MULTIPLICATIVE expr
| expr ADDMINUS expr
| expr SHIFT expr
| expr RELATIONAL expr
| expr EQUALITY expr
| expr BIT_AND expr
| expr BIT_XOR expr
| expr BIT_OR expr
| expr LOG_AND expr
| expr LOG_OR expr
| expr TERNARY expr
| expr ASSIGNOP expr
| '(' expr ')'
| (variable | literal);

arraycreation: NEW '[' (expr (',' expr)* )? ']' ;
arrayaccess: variable '[' expr ']' ;
methodcall: variable '(' expr ')' ;
variable : IDENTIFIER;
literal  :  
		INTLITERAL
	|   LONGLITERAL
	|   FLOATLITERAL
	|   DOUBLELITERAL
	|   CHARLITERAL
	|   STRINGLITERAL
	|   TRUE
	|   FALSE
	|   NULL
    ;

Ws : ( ' ' | '\t' | '\n' | '\r' )+ { skip(); };



SEMICOLON : ';';


DOT: '.';
DOUBLEADDMINUS: '++' | '--';
NOTCOMP: '~' | '!';
MULTIPLICATIVE:	'*' | '/' | '%';
ADDMINUS: '+' | '-' ;
SHIFT: '<<' | '>>' | '>>>';
RELATIONAL:	'<' | '>' | '<=' | '>=' | 'instanceof';
EQUALITY: '==' | '!=';
BIT_AND: '&';
BIT_XOR: '^';
BIT_OR: '|';
LOG_AND: '&&';
LOG_OR: '||';
TERNARY: '?' ':' ;
ASSIGNOP:	'=' | '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '^=' | '|=' | '<<=' | '>>=' | '>>>=';

/*

LITERALS

*/

LONGLITERAL
    :   IntegerNumber LongSuffix
    ;


INTLITERAL
    :   IntegerNumber
    ;

fragment
IntegerNumber
    :   '0'
    |   DecimalDigits
    |   '0' ('0'..'7')+
    |   HexPrefix HexDigits
    |   BinPrefix BinDigits
    ;

fragment
DecimalDigits
    : NonZeroDigit Digits?
    | NonZeroDigit ( '_' '_'* ) Digits
    ;

fragment
Digits
    : Digit
    | Digit ( (Digit | '_')+ )? Digit
    ;
	
fragment
Digit
    : '0'..'9'
    ;
	
fragment
NonZeroDigit
    : '1'..'9'
    ;

fragment
HexDigits
    : HexDigit+ | ( HexDigit ( HexDigit | '_' )* HexDigit )
    ;
	
fragment
HexPrefix
    :   '0x' | '0X'
    ;

fragment
HexDigit
    :   ('0'..'9'|'a'..'f'|'A'..'F')
    ;

fragment
BinDigits
    : BinDigit+ | ( BinDigit ( BinDigit | '_' )* BinDigit )
    ;
	
fragment
BinPrefix
    :   '0b' | '0B'
    ;

fragment
BinDigit
    :   ('0'|'1')
    ;

fragment
LongSuffix
    :   'l' | 'L'
    ;


fragment
NonIntegerNumber
    :   ('0' .. '9')+ '.' ('0' .. '9')* Exponent?
    |   '.' ( '0' .. '9' )+ Exponent?
    |   ('0' .. '9')+ Exponent
    |   ('0' .. '9')+
    |
        HexPrefix (HexDigit )*
        (    ()
        |    ('.' (HexDigit )* )
        )
        ( 'p' | 'P' )
        ( '+' | '-' )?
        ( '0' .. '9' )+
        ;

fragment
Exponent
    :   ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
    ;

fragment
FloatSuffix
    :   'f' | 'F'
    ;

fragment
DoubleSuffix
    :   'd' | 'D'
    ;

FLOATLITERAL
    :   NonIntegerNumber FloatSuffix
    ;

DOUBLELITERAL
    :   NonIntegerNumber DoubleSuffix?
    ;

CHARLITERAL
    :   '\''
        (   EscapeSequence
        |   ~( '\'' | '\\' | '\r' | '\n' )
        )
        '\''
    ;

STRINGLITERAL
    :   '"'
        (   EscapeSequence
        |   ~( '\\' | '"' | '\r' | '\n' )
        )*
        '"'
    ;

fragment
EscapeSequence
    :   '\\' (
                 'b'
             |   't'
             |   'n'
             |   'f'
             |   'r'
             |   '\"'
             |   '\''
             |   '\\'
             |
                 ('0'..'3') ('0'..'7') ('0'..'7')
             |
                 ('0'..'7') ('0'..'7')
             |
                 ('0'..'7')
             )
;

TRUE
    :   'true'
    ;

FALSE
    :   'false'
    ;

NULL
    :   'null'
    ;
	
NEW
	: 'new'
	;
	
IDENTIFIER : [A-Za-z_$][A-Za-z_$0-9]*;