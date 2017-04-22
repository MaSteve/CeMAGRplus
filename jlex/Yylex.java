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
        m_index = index;
        m_text = new String(text);
        m_line = line;
        m_charBegin = charBegin;
        m_charEnd = charEnd;
        m_col = col;
        System.out.println(this);
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


class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

    private int col_offset = 0;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int COMMENT = 1;
	private final int yy_state_dtrans[] = {
		0,
		29
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NO_ANCHOR,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NOT_ACCEPT,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"26:8,19:2,18,26:2,21,26:18,19,10,20,26:2,15,16,26,6,7,13,11,26,12,26,14,22:" +
"10,2,1,8,3,9,26:2,24:26,26:4,25,26,24:26,4,17,5,26:8238,23,26:57171,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,36,
"0,1:2,2,1:4,3,4,5,1:5,6,7,8,9,1:8,10,11,12,13,14,15,16,1")[0];

	private int yy_nxt[][] = unpackFromString(17,27,
"1,2,3,31,4,5,6,7,8,9,10,11,12,13,14,15,32,33,30,16,17,-1,18,34,19,35:2,-1:3" +
"0,20,-1:26,22,-1:26,23,-1:26,24,-1:42,16,-1:8,17:17,-1,17,27,17:6,-1:22,18," +
"-1:26,19,-1,19:2,-1:23,28,-1,28:2,-1,1,35:17,-1,35:2,-1,35:5,-1:18,30,-1:11" +
",21,-1:39,25,-1:27,26,-1:33,28,-1:2");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 0:
						{ col_offset = yychar + yytext().length(); }
					case -2:
						break;
					case 1:
						
					case -3:
						break;
					case 2:
						{ return (new Yytoken(sym.SEMI, 0,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -4:
						break;
					case 3:
						{
        System.out.println("Illegal character: <" + yytext() + ">");
	Utility.error(Utility.E_UNMATCHED);
}
					case -5:
						break;
					case 4:
						{ return (new Yytoken(sym.SEMI, 2,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -6:
						break;
					case 5:
						{ return (new Yytoken(sym.SEMI, 3,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -7:
						break;
					case 6:
						{ return (new Yytoken(sym.LP, 4,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -8:
						break;
					case 7:
						{ return (new Yytoken(sym.RP, 5,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -9:
						break;
					case 8:
						{ return (new Yytoken(sym.LT, 6,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -10:
						break;
					case 9:
						{ return (new Yytoken(sym.GT, 7,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -11:
						break;
					case 10:
						{ return (new Yytoken(sym.NOT, 19,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -12:
						break;
					case 11:
						{ return (new Yytoken(sym.PLUS, 12,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -13:
						break;
					case 12:
						{ return (new Yytoken(sym.MINUS, 13,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -14:
						break;
					case 13:
						{ return (new Yytoken(sym.TIMES, 14,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -15:
						break;
					case 14:
						{ return (new Yytoken(sym.DIV, 15,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -16:
						break;
					case 15:
						{ return (new Yytoken(sym.MOD, 16,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -17:
						break;
					case 16:
						{ }
					case -18:
						break;
					case 17:
						{
	String str =  yytext().substring(1,yytext().length());
	Utility.error(Utility.E_UNCLOSEDSTR);
	Utility.assertExp(str.length() == yytext().length() - 1);
	return (new Yytoken(sym.SEMI, 41,str,yyline,yychar,yychar + str.length(), yychar-col_offset));
}
					case -19:
						break;
					case 18:
						{
	return (new Yytoken(sym.NUM, 42,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
}
					case -20:
						break;
					case 19:
						{
    String str = yytext();
    switch(str) {
        case "If": return (new Yytoken(sym.SEMI, 50, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "Else": return (new Yytoken(sym.SEMI, 51, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "Loop": return (new Yytoken(sym.SEMI, 52, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "Foop": return (new Yytoken(sym.SEMI, 53, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "func": return (new Yytoken(sym.SEMI, 54, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "return": return (new Yytoken(sym.SEMI, 55, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "int": return (new Yytoken(sym.SEMI, 60, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "bool": return (new Yytoken(sym.SEMI, 61, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "YES": return (new Yytoken(sym.BOOL, 70, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        case "NO": return (new Yytoken(sym.BOOL, 71, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
        default: return (new Yytoken(sym.SEMI, 44, yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
    }
}
					case -21:
						break;
					case 20:
						{ return (new Yytoken(sym.ASS, 1,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -22:
						break;
					case 21:
						{ return (new Yytoken(sym.EQ, 10,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -23:
						break;
					case 22:
						{ return (new Yytoken(sym.LE, 8,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -24:
						break;
					case 23:
						{ return (new Yytoken(sym.GE, 9,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -25:
						break;
					case 24:
						{ return (new Yytoken(sym.NEQ, 11,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -26:
						break;
					case 25:
						{ return (new Yytoken(sym.AND, 17,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -27:
						break;
					case 26:
						{ return (new Yytoken(sym.OR, 18,yytext(),yyline,yychar,yychar+1,yychar-col_offset)); }
					case -28:
						break;
					case 27:
						{
	String str =  yytext().substring(1,yytext().length() - 1);
	Utility.assertExp(str.length() == yytext().length() - 2);
	return (new Yytoken(sym.SEMI, 30,str,yyline,yychar,yychar + str.length(), yychar-col_offset));
}
					case -29:
						break;
					case 28:
						{
	return (new Yytoken(sym.VAR_NAME, 43,yytext(),yyline,yychar,yychar + yytext().length(), yychar-col_offset));
}
					case -30:
						break;
					case 30:
						{ col_offset = yychar + yytext().length(); }
					case -31:
						break;
					case 31:
						{
        System.out.println("Illegal character: <" + yytext() + ">");
	Utility.error(Utility.E_UNMATCHED);
}
					case -32:
						break;
					case 32:
						{
        System.out.println("Illegal character: <" + yytext() + ">");
	Utility.error(Utility.E_UNMATCHED);
}
					case -33:
						break;
					case 33:
						{
        System.out.println("Illegal character: <" + yytext() + ">");
	Utility.error(Utility.E_UNMATCHED);
}
					case -34:
						break;
					case 34:
						{
        System.out.println("Illegal character: <" + yytext() + ">");
	Utility.error(Utility.E_UNMATCHED);
}
					case -35:
						break;
					case 35:
						{
        System.out.println("Illegal character: <" + yytext() + ">");
	Utility.error(Utility.E_UNMATCHED);
}
					case -36:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}