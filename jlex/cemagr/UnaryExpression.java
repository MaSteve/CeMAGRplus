package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class UnaryExpression extends ParserNode {
    private OperatorNode op;
    private ParserNode exp;

    public UnaryExpression(OperatorNode op, ParserNode exp) {
        this.op = op;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "UnaryExpression: \n" + op + "\n" + exp;
    }

    public Type getTYPE() {
        if (op.getTYPE() == Type.OK) { //TODO: Refactor
            if (op.getOp() == OperatorNode.ADDRESS) {
                if (exp.getTYPE() == Type.INT) TYPE = Type.PTR_INT;
                else if (exp.getTYPE() == Type.BOOL) TYPE = Type.PTR_BOOL;
                else TYPE = Type.FAIL;
            }
            if (op.getOp() == OperatorNode.DEREFERENCE) {
                if (exp.getTYPE() == Type.PTR_INT) TYPE = Type.INT;
                else if (exp.getTYPE() == Type.PTR_BOOL) TYPE = Type.BOOL;
                else TYPE = Type.FAIL;
            }
        } else {
            if (op.getTYPE() == exp.getTYPE()) TYPE = op.getTYPE();
            else {
                Application.notifyError(Application.TYPE_MSG + ": " + Application.TYPE_EXP_MSG + op.getTYPE()
                        + " (" + op.getLine() + ", " + op.getColumn() + ")");
                TYPE = Type.FAIL;
            }
        }
        return TYPE;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        exp.solveReferences(previous);
    }
}
