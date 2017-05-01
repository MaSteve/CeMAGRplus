package cemagr;
import java.lang.System;
import java_cup.runtime.Symbol;

class Sample {
    public static void main(String argv[]) throws java.io.IOException {
        /*Yylex yy = new Yylex(System.in);
        Yytoken t;
        while ((t = yy.yylex()) != null)
            System.out.println(t);*/
    }
}

class Utility {
    public static void assertExp (boolean expr) {
        if (false == expr) {
            throw (new Error("Error: Assertion failed."));
        }
    }

    private static final String errorMsg[] = {
        "Error: Unmatched end-of-comment punctuation.",
        "Error: Unmatched start-of-comment punctuation.",
        "Error: Unclosed string.",
        "Error: Illegal character."
    };

    public static final int E_ENDCOMMENT = 0;
    public static final int E_STARTCOMMENT = 1;
    public static final int E_UNCLOSEDSTR = 2;
    public static final int E_UNMATCHED = 3;

    public static void error(int code) {
        System.out.println(errorMsg[code]);
    }
}

class Yytoken extends Symbol{
    Yytoken(int symb, int index, String text, int line, int charBegin, int charEnd, int col) {
        super(symb);
        this.value = this;
        m_index = index;
        m_text = new String(text);
        m_line = line;
        m_charBegin = charBegin;
        m_charEnd = charEnd;
        m_col = col;
        //System.out.println(this);
    }

    public int m_index;
    public String m_text;
    public int m_line;
    public int m_charBegin;
    public int m_charEnd;
    public int m_col;
    public String toString() {
        return "Token #"+m_index+": "+m_text+" (line "+m_line+" col "+m_col+")";
    }
}

%%

%{
    private int col_offset = 0;
%}
%unicode
%line
%char
%cup
%state COMMENT

ALPHA=[A-Za-z]
EURO=[€]
SHARP=[#]
DIGIT=[0-9]
WHITE_SPACE_CHAR=[\ \t\b]
END_LINE = (\n)*
STRING_TEXT=([^\n\"])*
COMMENT_TEXT=([^\n])*

%%

<YYINITIAL> ";" { return (new Yytoken(sym.SEMI, 0,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> ":=" { return (new Yytoken(sym.ASS, 1,yytext(),yyline,yychar,yychar+2,yychar-col_offset)); }
<YYINITIAL> "{" { return (new Yytoken(sym.LB, 2,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "}" { return (new Yytoken(sym.RB, 3,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "(" { return (new Yytoken(sym.LP, 4,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> ")" { return (new Yytoken(sym.RP, 5,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "<" { return (new Yytoken(sym.LT, 6,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> ">" { return (new Yytoken(sym.GT, 7,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "<=" { return (new Yytoken(sym.LE, 8,yytext(),yyline,yychar,yychar+2,yychar-col_offset)); }
<YYINITIAL> ">=" { return (new Yytoken(sym.GE, 9,yytext(),yyline,yychar,yychar+2,yychar-col_offset)); }
<YYINITIAL> "==" { return (new Yytoken(sym.EQ, 10,yytext(),yyline,yychar,yychar+2,yychar-col_offset)); }
<YYINITIAL> "!=" { return (new Yytoken(sym.NEQ, 11,yytext(),yyline,yychar,yychar+2,yychar-col_offset)); }
<YYINITIAL> "+" { return (new Yytoken(sym.PLUS, 12,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "-" { return (new Yytoken(sym.MINUS, 13,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "*" { return (new Yytoken(sym.TIMES, 14,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "/" { return (new Yytoken(sym.DIV, 15,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "%" { return (new Yytoken(sym.MOD, 16,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "&&" { return (new Yytoken(sym.AND, 17,yytext(),yyline,yychar,yychar+2,yychar-col_offset)); }
<YYINITIAL> "||" { return (new Yytoken(sym.OR, 18,yytext(),yyline,yychar,yychar+2,yychar-col_offset)); }
<YYINITIAL> "!" { return (new Yytoken(sym.NOT, 19,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "," { return (new Yytoken(sym.COMMA, 20,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "=>" { return (new Yytoken(sym.THEN, 21,yytext(),yyline,yychar,yychar+2,yychar-col_offset)); }
<YYINITIAL> ":" { return (new Yytoken(sym.ADDRESS, 22,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "@" { return (new Yytoken(sym.DEREFERENCE, 23,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }


<YYINITIAL> {END_LINE} { col_offset = yychar + yytext().length(); }

<YYINITIAL> {WHITE_SPACE_CHAR}+ { }

<YYINITIAL> \"{STRING_TEXT}\" {
	String str =  yytext().substring(1,yytext().length() - 1);

	Utility.assertExp(str.length() == yytext().length() - 2);
	return (new Yytoken(sym.STRING, 40,str,yyline,yychar,yychar + str.length(), yychar-col_offset));
}
<YYINITIAL> \"{STRING_TEXT} {
	String str =  yytext().substring(1,yytext().length());

	Utility.error(Utility.E_UNCLOSEDSTR);
	Utility.assertExp(str.length() == yytext().length() - 1);
	return (new Yytoken(sym.SEMI, 41,str,yyline,yychar,yychar + str.length(), yychar-col_offset));
}
<YYINITIAL> {DIGIT}+ {
	return (new Yytoken(sym.NUM, 42,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
}
<YYINITIAL> {EURO}{ALPHA}({ALPHA}|{DIGIT}|_)* {
	return (new Yytoken(sym.VAR_NAME, 43,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
}
<YYINITIAL> {ALPHA}({ALPHA}|{DIGIT}|_)* {
    String str = yytext();
    switch(str) {
        case "If": return (new Yytoken(sym.IF, 50, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "Else": return (new Yytoken(sym.ELSE, 51, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "Loop": return (new Yytoken(sym.LOOP, 52, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "Foop": return (new Yytoken(sym.FOOP, 53, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "func": return (new Yytoken(sym.FUNC, 54, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "return": return (new Yytoken(sym.RETURN, 55, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "switch": return (new Yytoken(sym.SWITCH, 56, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "case": return (new Yytoken(sym.CASE, 57, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "otherwise": return (new Yytoken(sym.OTHERWISE, 58, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "ptr": return (new Yytoken(sym.PTR, 59, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "int": return (new Yytoken(sym.TYPE, 60, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "bool": return (new Yytoken(sym.TYPE, 61, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "string": return (new Yytoken(sym.TYPE, 62, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "YEAH": return (new Yytoken(sym.BOOL, 70, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "NO": return (new Yytoken(sym.BOOL, 71, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        default: return (new Yytoken(sym.FUNC_ID, 44, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
    }
}

<YYINITIAL> {SHARP} { yybegin(COMMENT); }

<COMMENT> {COMMENT_TEXT} { }

<COMMENT> {END_LINE} { yybegin(YYINITIAL); }

<YYINITIAL,COMMENT> . {
        System.out.println("Illegal character: <" + yytext() + ">");
	Utility.error(Utility.E_UNMATCHED);
}
