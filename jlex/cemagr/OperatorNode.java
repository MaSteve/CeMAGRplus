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

    public int getOp() {
        return op;
    }

    public int getInstSize() {
        return op == NEQ ? 2 : 1;
    }

    public Type retType() {
        switch (op) {
            case ASS: return TYPE.FAIL;
            case LT: return TYPE.BOOL;
            case GT: return TYPE.BOOL;
            case LE: return TYPE.BOOL;
            case GE: return TYPE.BOOL;
            case EQ: return TYPE.BOOL;
            case NEQ: return TYPE.BOOL;
            case PLUS: return TYPE.INT;
            case MINUS: return TYPE.INT;
            case TIMES: return TYPE.INT;
            case DIV: return TYPE.INT;
            case MOD: return TYPE.INT;
            case AND: return TYPE.BOOL;
            case OR: return TYPE.BOOL;
            case NOT: return TYPE.BOOL;
            case ADDRESS: return TYPE.FAIL;
            case DEREFERENCE: return TYPE.FAIL;
            default: return TYPE.FAIL;
        }
    }

    public void translate() {
        switch (op) {
            case LT: Application.newInst("les"); break;
            case GT: Application.newInst("grt"); break;
            case LE: Application.newInst("leq"); break;
            case GE: Application.newInst("geq"); break;
            case EQ: Application.newInst("equ"); break;
            case NEQ: Application.newInst("equ"); Application.newInst("not"); break;
            case PLUS: Application.newInst("add"); break;
            case MINUS: Application.newInst("sub"); break;
            case TIMES: Application.newInst("mul"); break;
            case DIV: Application.newInst("div"); break;
            case MOD: Application.newInst("ERROR"); break;
            case AND: Application.newInst("and"); break;
            case OR: Application.newInst("or"); break;
            case NOT: Application.newInst("not"); break;
        }
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
