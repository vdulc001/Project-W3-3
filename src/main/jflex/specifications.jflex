package edu.odu.cs.cs350;
//@SuppressWarnings("unused")

%%

%public
%class GeneratedScanner

%line
%column

%type Token

%{
  StringBuilder string = new StringBuilder();
  
  private Token symbol(TokenKinds type) {
    return new Token(type, yyline+1, yycolumn+1);
  }

  private Token symbol(TokenKinds type, String value) {
    return new Token(type, yyline+1, yycolumn+1, value);
  }



%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
OctDigit = [0-7]

WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | 
          {DocumentationComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"

/* identifiers */
Identifier = [:jletter:][:jletterdigit:]*

/* integer literals */
IntegerLiteral = [0-9][0-9]* | [0-9][_0-9]*[0-9]

%%

<YYINITIAL> {

/* keywords */
  "alignas"                     { return symbol(TokenKinds.ALIGNAS); }
  "alignof"                     { return symbol(TokenKinds.ALIGNOF); }
  "and"							{ return symbol(TokenKinds.AND); }
  "and_eq"						{ return symbol(TokenKinds.AND_EQ); }
  "asm"							{ return symbol(TokenKinds.ASM); }
  "atomic_cancel"				{ return symbol(TokenKinds.ATOMIC_CANCEL); }
  "atomic_commit"				{ return symbol(TokenKinds.ATOMIC_COMMIT); }
  "atomic_noexcept"				{ return symbol(TokenKinds.ATOMIC_NOEXCEPT); }
  "auto"						{ return symbol(TokenKinds.AUTO); }
  "bitand"						{ return symbol(TokenKinds.BITAND); }
  "bitor"						{ return symbol(TokenKinds.BITOR); }
  "bool"						{ return symbol(TokenKinds.BOOL); }
  "break"						{ return symbol(TokenKinds.BREAK); }
  "case"						{ return symbol(TokenKinds.CASE); }
  "catch"						{ return symbol(TokenKinds.CATCH); }
  "char"						{ return symbol(TokenKinds.CHAR); }
  "char8_t"						{ return symbol(TokenKinds.CHAR8_T); }
  "char16_t"					{ return symbol(TokenKinds.CHAR16_T); }
  "char32_t"					{ return symbol(TokenKinds.CHAR32_T); }
  "class"						{ return symbol(TokenKinds.CLASS); }
  "compl"						{ return symbol(TokenKinds.COMPL); }
  "concept"						{ return symbol(TokenKinds.CONCEPT); }
  "const"						{ return symbol(TokenKinds.CONST); }
  "consteval"					{ return symbol(TokenKinds.CONSTEVAL); }
  "constexpr"					{ return symbol(TokenKinds.CONSTEXPR); }
  "constinit"					{ return symbol(TokenKinds.CONSTINIT); }
  "const_cast"					{ return symbol(TokenKinds.CONST_CAST); }
  "continue"					{ return symbol(TokenKinds.CONTINUE); }
  "co_await"					{ return symbol(TokenKinds.CO_AWAIT); }
  "co_return"					{ return symbol(TokenKinds.CO_RETURN); }
  "co_yield"					{ return symbol(TokenKinds.CO_YIELD); }
  "decltype"					{ return symbol(TokenKinds.DECLTYPE); }
  "default"						{ return symbol(TokenKinds.DEFAULT); }
  "delete"						{ return symbol(TokenKinds.DELETE); }
  "do"							{ return symbol(TokenKinds.DO); }
  "double"						{ return symbol(TokenKinds.DOUBLE); }
  "dynamic_cast"				{ return symbol(TokenKinds.DYNAMIC_CAST); }
  "else"						{ return symbol(TokenKinds.ELSE); }
  "enum"						{ return symbol(TokenKinds.ENUM); }
  "explicit"					{ return symbol(TokenKinds.EXPLICIT); }
  "export"						{ return symbol(TokenKinds.EXPORT); }
  "extern"						{ return symbol(TokenKinds.EXTERN); }
  "false"						{ return symbol(TokenKinds.FALSE); }
  "float"						{ return symbol(TokenKinds.FLOAT); }
  "for"							{ return symbol(TokenKinds.FOR); }
  "friend"						{ return symbol(TokenKinds.FRIEND); }
  "goto"						{ return symbol(TokenKinds.GOTO); }
  "if"							{ return symbol(TokenKinds.IF); }
  "inline"						{ return symbol(TokenKinds.INLINE); }
  "int"							{ return symbol(TokenKinds.INT); }
  "long"						{ return symbol(TokenKinds.LONG); }
  "mutable"						{ return symbol(TokenKinds.MUTABLE); }
  "namespace"					{ return symbol(TokenKinds.NAMESPACE); }
  "new"							{ return symbol(TokenKinds.NEW); }
  "noexcept"					{ return symbol(TokenKinds.NOEXCEPT); }
  "not"							{ return symbol(TokenKinds.NOT); }
  "not_eq"						{ return symbol(TokenKinds.NOT_EQ); }
  "nullptr"						{ return symbol(TokenKinds.NULLPTR); }
  "operator"					{ return symbol(TokenKinds.OPERATOR); }
  "or"							{ return symbol(TokenKinds.OR); }
  "or_eq"						{ return symbol(TokenKinds.OR_EQ); }
  "private"						{ return symbol(TokenKinds.PRIVATE); }
  "protected"					{ return symbol(TokenKinds.PROTECTED); }
  "public"						{ return symbol(TokenKinds.PUBLIC); }
  "reflexpr"					{ return symbol(TokenKinds.REFLEXPR); }
  "register"					{ return symbol(TokenKinds.REGISTER); }
  "reinterpret_cast"			{ return symbol(TokenKinds.REINTERPRET_CAST); }
  "requires"					{ return symbol(TokenKinds.REQUIRES); }
  "return"						{ return symbol(TokenKinds.RETURN); }
  "short"						{ return symbol(TokenKinds.SHORT); }
  "signed"						{ return symbol(TokenKinds.SIGNED); }
  "sizeof"						{ return symbol(TokenKinds.SIZEOF); }
  "static"						{ return symbol(TokenKinds.STATIC); }
  "static_assert"				{ return symbol(TokenKinds.STATIC_ASSERT); }
  "static_cast"					{ return symbol(TokenKinds.CAST); }
  "struct"						{ return symbol(TokenKinds.STRUCT); }
  "switch"						{ return symbol(TokenKinds.SWITCH); }
  "synchronized"				{ return symbol(TokenKinds.SYNCHRONIZED); }
  "template"					{ return symbol(TokenKinds.TEMPLATE); }
  "this"						{ return symbol(TokenKinds.THIS); }
  "thread_local"				{ return symbol(TokenKinds.THREAD_LOCAL); }
  "throw"						{ return symbol(TokenKinds.THROW); }
  "true"						{ return symbol(TokenKinds.TRUE); }
  "try"							{ return symbol(TokenKinds.TRY); }
  "typedef"						{ return symbol(TokenKinds.TYPEDEF); }
  "typeid"						{ return symbol(TokenKinds.TYPEID); }
  "typename"					{ return symbol(TokenKinds.TYPENAME); }
  "union"						{ return symbol(TokenKinds.UNION); }
  "unsigned"					{ return symbol(TokenKinds.UNSIGNED); }
  "using"						{ return symbol(TokenKinds.USING); }
  "virtual"						{ return symbol(TokenKinds.VIRTUAL); }
  "void"						{ return symbol(TokenKinds.VOID); }
  "volatile"					{ return symbol(TokenKinds.VOLATILE); }
  "wchar_t"						{ return symbol(TokenKinds.WCHAR_T); }
  "while"						{ return symbol(TokenKinds.WHILE); }
  "xor"							{ return symbol(TokenKinds.XOR); }
  "xor_eq"						{ return symbol(TokenKinds.XOR_EQ); }
  
  /* preprocessor symbols */
  "#define" 					{ return symbol(TokenKinds.PREPROCESSOR); }
  "#elif" 						{ return symbol(TokenKinds.PREPROCESSOR); }
  "#else" 						{ return symbol(TokenKinds.PREPROCESSOR); }
  "#endif" 						{ return symbol(TokenKinds.PREPROCESSOR); }
  "#error" 						{ return symbol(TokenKinds.PREPROCESSOR); }
  "#ifdef" 						{ return symbol(TokenKinds.PREPROCESSOR); }
  "#ifndef" 					{ return symbol(TokenKinds.PREPROCESSOR); }
  "#if" 						{ return symbol(TokenKinds.PREPROCESSOR); }
  "#import" 					{ return symbol(TokenKinds.PREPROCESSOR); }
  "#include" 					{ return symbol(TokenKinds.PREPROCESSOR); }
  "#line" 						{ return symbol(TokenKinds.PREPROCESSOR); }
  "#pragma" 					{ return symbol(TokenKinds.PREPROCESSOR); }
  "#undef" 						{ return symbol(TokenKinds.PREPROCESSOR); }
  "#using"						{ return symbol(TokenKinds.PREPROCESSOR); }
  
  /** C++ standard and built-in objects */
  "cin"							{ return symbol(TokenKinds.CIN); }
  "cout"						{ return symbol(TokenKinds.COUT); }
  
 /* null literal */
  "null"                         { return symbol(TokenKinds.NULL_LITERAL); }

/* Punctuators and operators*/
  "("                            { return symbol(TokenKinds.LPAREN); }
  ")"                            { return symbol(TokenKinds.RPAREN); }
  "{"                            { return symbol(TokenKinds.LBRACE); }
  "}"                            { return symbol(TokenKinds.RBRACE); }
  "["                            { return symbol(TokenKinds.LBRACK); }
  "]"                            { return symbol(TokenKinds.RBRACK); }
  ";"                            { return symbol(TokenKinds.SEMICOLON); }
  ","                            { return symbol(TokenKinds.COMMA); }
  "."                            { return symbol(TokenKinds.DOT); }
  "="                            { return symbol(TokenKinds.EQ); }
  ">"                            { return symbol(TokenKinds.GT); }
  "<"                            { return symbol(TokenKinds.LT); }
  "!"                            { return symbol(TokenKinds.NOT_OP); }
  "~"                            { return symbol(TokenKinds.COMP); }
  "?"                            { return symbol(TokenKinds.QUESTION); }
  "=="                           { return symbol(TokenKinds.EQEQ); }
  "<="                           { return symbol(TokenKinds.LTEQ); }
  ">="                           { return symbol(TokenKinds.GTEQ); }
  "!="                           { return symbol(TokenKinds.NOTEQ); }
  "&&"                           { return symbol(TokenKinds.ANDAND); }
  "||"                           { return symbol(TokenKinds.OROR); }
  "++"                           { return symbol(TokenKinds.PLUSPLUS); }
  "--"                           { return symbol(TokenKinds.MINUSMINUS); }
  "+"                            { return symbol(TokenKinds.PLUS); }
  "-"                            { return symbol(TokenKinds.MINUS); }
  "*"                            { return symbol(TokenKinds.MULT); }
  "/"                            { return symbol(TokenKinds.DIV); }
  "&"                            { return symbol(TokenKinds.AND_OP); }
  "|"                            { return symbol(TokenKinds.OR); }
  "^"                            { return symbol(TokenKinds.XOR_OP); }
  "%"                            { return symbol(TokenKinds.MOD); }
  "<<"                           { return symbol(TokenKinds.LSHIFT); }
  ">>"                           { return symbol(TokenKinds.RSHIFT); }
  "+="                           { return symbol(TokenKinds.PLUSEQ); }
  "-="                           { return symbol(TokenKinds.MINUSEQ); }
  "*="                           { return symbol(TokenKinds.MULTEQ); }
  "/="                           { return symbol(TokenKinds.DIVEQ); }
  "&="                           { return symbol(TokenKinds.ANDEQ); }
  "|="                           { return symbol(TokenKinds.OREQ); }
  "^="                           { return symbol(TokenKinds.XOREQ); }
  "%="                           { return symbol(TokenKinds.MODEQ); }
  "<<="                          { return symbol(TokenKinds.LSHIFTEQ); }
  ">>="                          { return symbol(TokenKinds.RSHIFTEQ); }
  "::"							 { return symbol(TokenKinds.SCOPE); }
  "->"							 { return symbol(TokenKinds.MEMBERACCESS); }
  "->*"							 { return symbol(TokenKinds.ACCESSPTR); }
  ".*"							 { return symbol(TokenKinds.ACCESSPTRDOT); }
  
  
  {IntegerLiteral}            	 { return symbol(TokenKinds.INTEGER_LITERAL, yytext()); }

  {Identifier}                   { return symbol(TokenKinds.IDENTIFIER, yytext()); } 
  
  {WhiteSpace}                   {/* Ignore: don't return anything. */}  

/* comments */
  {Comment}                      { /* ignore */ }
}

/* literals */
(\" ( [^\"\n\\] | \\[^\n] )* (\n | \\\n | \")) |
  (\' ( [^\'\n\\] | \\[^\n] )* (\n | \\\n | \')) 
 	{ return symbol(TokenKinds.STRING); }

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return symbol(TokenKinds.EOF); }
