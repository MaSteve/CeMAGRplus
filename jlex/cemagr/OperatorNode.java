package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class OperatorNode extends ParserNode {

    protected int op;

    public OperatorNode(Yytoken token) {
        super(token);
        op = token.m_index;
        switch (op) { //TODO: Multitype operator
            case ASS: TYPE = Type.OK; break;
            case LT: TYPE = Type.INT; break;
            case GT: TYPE = Type.INT; break;
            case LE: TYPE = Type.INT; break;
            case GE: TYPE = Type.INT; break;
            case EQ: TYPE = Type.INT; break;
            case NEQ: TYPE = Type.INT; break;
            case PLUS: TYPE = Type.INT; break;
            case MINUS: TYPE = Type.INT; break;
            case TIMES: TYPE = Type.INT; break;
            case DIV: TYPE = Type.INT; break;
            case MOD: TYPE = Type.INT; break;
            case AND: TYPE = Type.BOOL; break;
            case OR: TYPE = Type.BOOL; break;
            case NOT: TYPE = Type.BOOL; break;
            case ADDRESS: TYPE = Type.OK; break;
            case DEREFERENCE: TYPE = Type.OK; break;
            default: TYPE = Type.FAIL; break;
        }
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
