
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package cemagr;

import java_cup.runtime.*;
import java.io.FileInputStream;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\052\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\003\003\000\002\003\003\000\002\003\003" +
    "\000\002\004\006\000\002\007\005\000\002\007\003\000" +
    "\002\010\003\000\002\010\003\000\002\010\003\000\002" +
    "\010\003\000\002\010\003\000\002\010\003\000\002\011" +
    "\005\000\002\011\003\000\002\012\003\000\002\012\003" +
    "\000\002\012\003\000\002\013\005\000\002\013\003\000" +
    "\002\014\003\000\002\014\003\000\002\014\003\000\002" +
    "\014\003\000\002\015\004\000\002\015\003\000\002\016" +
    "\003\000\002\016\003\000\002\017\003\000\002\017\003" +
    "\000\002\017\003\000\002\017\005\000\002\021\003\000" +
    "\002\021\004\000\002\023\004\000\002\023\003\000\002" +
    "\022\005\000\002\005\011\000\002\005\015\000\002\006" +
    "\011" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\106\000\010\012\014\034\012\036\005\001\002\000" +
    "\014\002\ufffe\012\ufffe\031\ufffe\034\ufffe\036\ufffe\001\002" +
    "\000\004\030\103\001\002\000\014\002\ufffd\012\ufffd\031" +
    "\ufffd\034\ufffd\036\ufffd\001\002\000\014\002\uffff\012\uffff" +
    "\031\uffff\034\uffff\036\uffff\001\002\000\012\002\102\012" +
    "\014\034\012\036\005\001\002\000\004\013\077\001\002" +
    "\000\004\030\064\001\002\000\014\002\ufffc\012\ufffc\031" +
    "\ufffc\034\ufffc\036\ufffc\001\002\000\044\004\uffdf\005\uffdf" +
    "\006\uffdf\007\uffdf\010\uffdf\011\uffdf\013\uffdf\014\uffdf\015" +
    "\uffdf\016\uffdf\017\uffdf\020\uffdf\021\uffdf\023\uffdf\024\uffdf" +
    "\027\uffdf\030\015\001\002\000\016\006\021\012\014\022" +
    "\022\025\032\026\025\030\023\001\002\000\044\004\uffde" +
    "\005\uffde\006\uffde\007\uffde\010\uffde\011\uffde\013\uffde\014" +
    "\uffde\015\uffde\016\uffde\017\uffde\020\uffde\021\uffde\023\uffde" +
    "\024\uffde\027\uffde\030\015\001\002\000\044\004\uffdc\005" +
    "\uffdc\006\uffdc\007\uffdc\010\uffdc\011\uffdc\013\uffdc\014\uffdc" +
    "\015\uffdc\016\uffdc\017\uffdc\020\uffdc\021\uffdc\023\uffdc\024" +
    "\uffdc\027\uffdc\030\uffdc\001\002\000\044\004\uffdd\005\uffdd" +
    "\006\uffdd\007\uffdd\010\uffdd\011\uffdd\013\uffdd\014\uffdd\015" +
    "\uffdd\016\uffdd\017\uffdd\020\uffdd\021\uffdd\023\uffdd\024\uffdd" +
    "\027\uffdd\030\uffdd\001\002\000\016\006\uffe4\012\uffe4\022" +
    "\uffe4\025\uffe4\026\uffe4\030\uffe4\001\002\000\040\004\uffe2" +
    "\005\uffe2\006\uffe2\007\uffe2\010\uffe2\011\uffe2\014\uffe2\015" +
    "\uffe2\016\uffe2\017\uffe2\020\uffe2\021\uffe2\023\uffe2\024\uffe2" +
    "\027\uffe2\001\002\000\016\006\021\012\014\022\022\025" +
    "\032\026\025\030\023\001\002\000\016\006\021\012\014" +
    "\022\022\025\032\026\025\030\023\001\002\000\040\004" +
    "\uffe1\005\uffe1\006\uffe1\007\uffe1\010\uffe1\011\uffe1\014\uffe1" +
    "\015\uffe1\016\uffe1\017\uffe1\020\uffe1\021\uffe1\023\uffe1\024" +
    "\uffe1\027\uffe1\001\002\000\040\004\uffe3\005\uffe3\006\uffe3" +
    "\007\uffe3\010\uffe3\011\uffe3\014\uffe3\015\uffe3\016\uffe3\017" +
    "\uffe3\020\uffe3\021\uffe3\023\uffe3\024\uffe3\027\uffe3\001\002" +
    "\000\040\004\uffe6\005\uffe6\006\uffe6\007\uffe6\010\uffe6\011" +
    "\uffe6\014\uffe6\015\uffe6\016\uffe6\017\uffe6\020\uffe6\021\uffe6" +
    "\023\uffe6\024\uffe6\027\uffe6\001\002\000\040\004\uffec\005" +
    "\uffec\006\uffec\007\uffec\010\uffec\011\uffec\014\uffec\015\uffec" +
    "\016\uffec\017\uffec\020\uffec\021\uffec\023\uffec\024\uffec\027" +
    "\uffec\001\002\000\040\004\ufff1\005\ufff1\006\ufff1\007\046" +
    "\010\045\011\042\014\ufff1\015\ufff1\016\ufff1\017\ufff1\020" +
    "\ufff1\021\ufff1\023\044\024\ufff1\027\ufff1\001\002\000\016" +
    "\006\uffe5\012\uffe5\022\uffe5\025\uffe5\026\uffe5\030\uffe5\001" +
    "\002\000\012\005\035\006\037\024\040\027\036\001\002" +
    "\000\016\006\021\012\014\022\022\025\032\026\025\030" +
    "\023\001\002\000\016\006\ufff0\012\ufff0\022\ufff0\025\ufff0" +
    "\026\ufff0\030\ufff0\001\002\000\044\004\uffdb\005\uffdb\006" +
    "\uffdb\007\uffdb\010\uffdb\011\uffdb\013\uffdb\014\uffdb\015\uffdb" +
    "\016\uffdb\017\uffdb\020\uffdb\021\uffdb\023\uffdb\024\uffdb\027" +
    "\uffdb\030\uffdb\001\002\000\016\006\uffef\012\uffef\022\uffef" +
    "\025\uffef\026\uffef\030\uffef\001\002\000\016\006\uffee\012" +
    "\uffee\022\uffee\025\uffee\026\uffee\030\uffee\001\002\000\040" +
    "\004\ufff2\005\ufff2\006\ufff2\007\046\010\045\011\042\014" +
    "\ufff2\015\ufff2\016\ufff2\017\ufff2\020\ufff2\021\ufff2\023\044" +
    "\024\ufff2\027\ufff2\001\002\000\016\006\uffe9\012\uffe9\022" +
    "\uffe9\025\uffe9\026\uffe9\030\uffe9\001\002\000\016\006\021" +
    "\012\014\022\022\025\032\026\025\030\023\001\002\000" +
    "\016\006\uffe8\012\uffe8\022\uffe8\025\uffe8\026\uffe8\030\uffe8" +
    "\001\002\000\016\006\uffea\012\uffea\022\uffea\025\uffea\026" +
    "\uffea\030\uffea\001\002\000\016\006\uffeb\012\uffeb\022\uffeb" +
    "\025\uffeb\026\uffeb\030\uffeb\001\002\000\040\004\uffed\005" +
    "\uffed\006\uffed\007\uffed\010\uffed\011\uffed\014\uffed\015\uffed" +
    "\016\uffed\017\uffed\020\uffed\021\uffed\023\uffed\024\uffed\027" +
    "\uffed\001\002\000\040\004\uffe7\005\uffe7\006\uffe7\007\uffe7" +
    "\010\uffe7\011\uffe7\014\uffe7\015\uffe7\016\uffe7\017\uffe7\020" +
    "\uffe7\021\uffe7\023\uffe7\024\uffe7\027\uffe7\001\002\000\030" +
    "\004\ufff9\005\035\006\037\014\057\015\056\016\061\017" +
    "\055\020\062\021\060\024\040\027\ufff9\001\002\000\004" +
    "\027\053\001\002\000\040\004\uffe0\005\uffe0\006\uffe0\007" +
    "\uffe0\010\uffe0\011\uffe0\014\uffe0\015\uffe0\016\uffe0\017\uffe0" +
    "\020\uffe0\021\uffe0\023\uffe0\024\uffe0\027\uffe0\001\002\000" +
    "\016\006\021\012\014\022\022\025\032\026\025\030\023" +
    "\001\002\000\016\006\ufff5\012\ufff5\022\ufff5\025\ufff5\026" +
    "\ufff5\030\ufff5\001\002\000\016\006\ufff7\012\ufff7\022\ufff7" +
    "\025\ufff7\026\ufff7\030\ufff7\001\002\000\016\006\ufff8\012" +
    "\ufff8\022\ufff8\025\ufff8\026\ufff8\030\ufff8\001\002\000\016" +
    "\006\ufff3\012\ufff3\022\ufff3\025\ufff3\026\ufff3\030\ufff3\001" +
    "\002\000\016\006\ufff6\012\ufff6\022\ufff6\025\ufff6\026\ufff6" +
    "\030\ufff6\001\002\000\016\006\ufff4\012\ufff4\022\ufff4\025" +
    "\ufff4\026\ufff4\030\ufff4\001\002\000\014\004\ufffa\005\035" +
    "\006\037\024\040\027\ufffa\001\002\000\016\006\021\012" +
    "\014\022\022\025\032\026\025\030\023\001\002\000\012" +
    "\005\035\006\037\024\040\027\066\001\002\000\004\032" +
    "\067\001\002\000\010\012\014\034\012\036\005\001\002" +
    "\000\012\012\014\031\072\034\012\036\005\001\002\000" +
    "\014\002\001\012\001\031\001\034\001\036\001\001\002" +
    "\000\016\002\uffda\012\uffda\031\uffda\034\uffda\035\073\036" +
    "\uffda\001\002\000\004\032\074\001\002\000\010\012\014" +
    "\034\012\036\005\001\002\000\012\012\014\031\076\034" +
    "\012\036\005\001\002\000\014\002\uffd9\012\uffd9\031\uffd9" +
    "\034\uffd9\036\uffd9\001\002\000\016\006\021\012\014\022" +
    "\022\025\032\026\025\030\023\001\002\000\004\004\101" +
    "\001\002\000\014\002\ufffb\012\ufffb\031\ufffb\034\ufffb\036" +
    "\ufffb\001\002\000\004\002\000\001\002\000\016\006\021" +
    "\012\014\022\022\025\032\026\025\030\023\001\002\000" +
    "\012\005\035\006\037\024\040\027\105\001\002\000\004" +
    "\032\106\001\002\000\010\012\014\034\012\036\005\001" +
    "\002\000\012\012\014\031\110\034\012\036\005\001\002" +
    "\000\014\002\uffd8\012\uffd8\031\uffd8\034\uffd8\036\uffd8\001" +
    "\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\106\000\016\002\007\003\006\004\003\005\005\006" +
    "\012\021\010\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\014\003\070\004" +
    "\003\005\005\006\012\021\010\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\022\016\023" +
    "\015\001\001\000\016\011\032\013\030\015\027\016\023" +
    "\017\026\021\025\001\001\000\004\022\017\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\020\007\051\011\050\013\030\015\027\016" +
    "\023\017\026\021\025\001\001\000\012\015\047\016\023" +
    "\017\026\021\025\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\014\042" +
    "\001\001\000\002\001\001\000\004\012\033\001\001\000" +
    "\014\013\040\015\027\016\023\017\026\021\025\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\014\042\001\001\000\002\001\001" +
    "\000\012\015\046\016\023\017\026\021\025\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\010\053\012\033\001" +
    "\001\000\002\001\001\000\002\001\001\000\016\011\062" +
    "\013\030\015\027\016\023\017\026\021\025\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\012" +
    "\033\001\001\000\016\011\064\013\030\015\027\016\023" +
    "\017\026\021\025\001\001\000\004\012\033\001\001\000" +
    "\002\001\001\000\016\002\067\003\006\004\003\005\005" +
    "\006\012\021\010\001\001\000\014\003\070\004\003\005" +
    "\005\006\012\021\010\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\016\002\074\003\006\004" +
    "\003\005\005\006\012\021\010\001\001\000\014\003\070" +
    "\004\003\005\005\006\012\021\010\001\001\000\002\001" +
    "\001\000\020\007\077\011\050\013\030\015\027\016\023" +
    "\017\026\021\025\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\016\011\103\013\030\015\027" +
    "\016\023\017\026\021\025\001\001\000\004\012\033\001" +
    "\001\000\002\001\001\000\016\002\106\003\006\004\003" +
    "\005\005\006\012\021\010\001\001\000\014\003\070\004" +
    "\003\005\005\006\012\021\010\001\001\000\002\001\001" +
    "" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



	public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("example.txt"));
		new parser(new Yylex(System.in)).parse();
	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // inst_block ::= inst_block inst 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("inst_block",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= inst_block EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // inst_block ::= inst 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("inst_block",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // inst ::= ass_inst 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("inst",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // inst ::= if_inst 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("inst",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // inst ::= loop_inst 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("inst",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // ass_inst ::= VAR ASS E0 SEMI 
            {
              Object RESULT =null;
		 System.out.println("ASS"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ass_inst",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // E0 ::= E1 OP0 E1 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E0",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // E0 ::= E1 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E0",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // OP0 ::= EQ 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP0",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // OP0 ::= NEQ 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP0",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // OP0 ::= GT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP0",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // OP0 ::= GE 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP0",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // OP0 ::= LT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP0",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // OP0 ::= LE 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP0",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // E1 ::= E1 OP1 E2 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E1",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // E1 ::= E2 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E1",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // OP1 ::= PLUS 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP1",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // OP1 ::= MINUS 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP1",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // OP1 ::= OR 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP1",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // E2 ::= E2 OP2 E3 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E2",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // E2 ::= E3 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E2",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // OP2 ::= TIMES 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP2",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // OP2 ::= DIV 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP2",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // OP2 ::= MOD 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP2",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // OP2 ::= AND 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP2",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // E3 ::= OP3 E3 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E3",11, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // E3 ::= E4 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E3",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // OP3 ::= NOT 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP3",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // OP3 ::= MINUS 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("OP3",12, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // E4 ::= VAR 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E4",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // E4 ::= NUM 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E4",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // E4 ::= BOOL 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E4",13, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // E4 ::= LP E0 RP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("E4",13, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // VAR ::= VAR_NAME 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("VAR",15, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // VAR ::= VAR_NAME ARRAY_LIST 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("VAR",15, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // ARRAY_LIST ::= ARRAY_LIST ARRAY 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ARRAY_LIST",17, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // ARRAY_LIST ::= ARRAY 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ARRAY_LIST",17, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // ARRAY ::= LP E1 RP 
            {
              Object RESULT =null;
		 System.out.println("IDX"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ARRAY",16, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // if_inst ::= IF LP E1 RP LB inst_block RB 
            {
              Object RESULT =null;
		 System.out.println("IF"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("if_inst",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // if_inst ::= IF LP E1 RP LB inst_block RB ELSE LB inst_block RB 
            {
              Object RESULT =null;
		 System.out.println("IFELSE"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("if_inst",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-10)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // loop_inst ::= LOOP LP E1 RP LB inst_block RB 
            {
              Object RESULT =null;
		 System.out.println("LOOP"); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("loop_inst",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
