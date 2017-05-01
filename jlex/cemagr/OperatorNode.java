package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class OperatorNode extends ParserNode {

    protected int op;

    public OperatorNode(Yytoken token) {
        super(token);
        op = token.m_index;
    }

    @Override
    public String toString() {
        return "OP" + op;
    }


    public static final int ASS = 1;
    public static final int LT = 6;
    public static final int GT = 7;
    public static final int LE = 8;
    public static final int GE = 9;
    public static final int EQ = 10;
    public static final int NEQ = 11;
    public static final int PLUS = 12;
    public static final int MINUS = 13;
    public static final int TIMES = 14;
    public static final int DIV = 15;
    public static final int MOD = 16;
    public static final int AND = 17;
    public static final int OR = 18;
    public static final int NOT = 19;
    public static final int ADDRESS = 22;
    public static final int DEREFERENCE = 23;
}
