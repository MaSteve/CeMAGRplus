import java.lang.System;

class Sample {
    public static void main(String argv[]) throws java.io.IOException {
        Yylex yy = new Yylex(System.in);
        Yytoken t;
        while ((t = yy.yylex()) != null)
            System.out.println(t);
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

class Yytoken {
    Yytoken(int index, String text, int line, int charBegin, int charEnd, int col) {
        m_index = index;
        m_text = new String(text);
        m_line = line;
        m_charBegin = charBegin;
        m_charEnd = charEnd;
        m_col = col;
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
%state COMMENT

ALPHA=[A-Za-z]
EURO=[€]
DIGIT=[0-9]
WHITE_SPACE_CHAR=[\ \t\b]
END_LINE = (\n)*
STRING_TEXT=([^\n\"])*


%%

<YYINITIAL> ";" { return (new Yytoken(0,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> ":=" { return (new Yytoken(1,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "{" { return (new Yytoken(2,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "}" { return (new Yytoken(3,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "(" { return (new Yytoken(4,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> ")" { return (new Yytoken(5,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "<" { return (new Yytoken(6,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> ">" { return (new Yytoken(7,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "<=" { return (new Yytoken(8,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> ">=" { return (new Yytoken(9,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "==" { return (new Yytoken(10,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "!=" { return (new Yytoken(11,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "+" { return (new Yytoken(12,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "-" { return (new Yytoken(13,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "*" { return (new Yytoken(14,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "/" { return (new Yytoken(15,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "%" { return (new Yytoken(16,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "&&" { return (new Yytoken(17,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "||" { return (new Yytoken(18,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
<YYINITIAL> "!" { return (new Yytoken(19,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }


<YYINITIAL> {END_LINE} { col_offset = yychar + yytext().length(); }

<YYINITIAL> {WHITE_SPACE_CHAR}+ { }

<YYINITIAL> \"{STRING_TEXT}\" {
	String str =  yytext().substring(1,yytext().length() - 1);

	Utility.assertExp(str.length() == yytext().length() - 2);
	return (new Yytoken(30,str,yyline,yychar,yychar + str.length(), yychar-col_offset));
}
<YYINITIAL> \"{STRING_TEXT} {
	String str =  yytext().substring(1,yytext().length());

	Utility.error(Utility.E_UNCLOSEDSTR);
	Utility.assertExp(str.length() == yytext().length() - 1);
	return (new Yytoken(41,str,yyline,yychar,yychar + str.length(), yychar-col_offset));
}
<YYINITIAL> {DIGIT}+ {
	return (new Yytoken(42,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
}
<YYINITIAL> {EURO}{ALPHA}({ALPHA}|{DIGIT}|_)* {
	return (new Yytoken(43,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
}
<YYINITIAL> {ALPHA}({ALPHA}|{DIGIT}|_)* {
    String str = yytext();
    switch(str) {
        case "If": return (new Yytoken(50,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "Else": return (new Yytoken(51,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "Loop": return (new Yytoken(52,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "Foop": return (new Yytoken(53,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "func": return (new Yytoken(54,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "return": return (new Yytoken(55,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "int": return (new Yytoken(60,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "bool": return (new Yytoken(61,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        default: return (new Yytoken(44,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
    }
}
<YYINITIAL,COMMENT> . {
        System.out.println("Illegal character: <" + yytext() + ">");
	Utility.error(Utility.E_UNMATCHED);
}
