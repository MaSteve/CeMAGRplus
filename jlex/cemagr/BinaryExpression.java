package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class BinaryExpression extends ParserNode {
    private OperatorNode op;
    private ParserNode exp1, exp2;

    public BinaryExpression(ParserNode exp1, OperatorNode op, ParserNode exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        exp1.solveReferences(previous);
        exp2.solveReferences(previous);
    }

    public Type getTYPE() {
        Type exp1Type = exp1.getTYPE();
        if (exp1Type == exp2.getTYPE() && exp1Type == op.getTYPE()) TYPE = op.getTYPE();
        else {
            Application.notifyError(Application.TYPE_MSG + ": " + Application.TYPE_EXP_MSG + op.getTYPE()
                    + " (" + getLine() + ", " + getColumn() + ")");
            TYPE = Type.FAIL;
        }
        return TYPE;
    }

    @Override
    public String toString() {
        return "BinaryExpression: \n" + exp1 + "\n" + op + "\n" + exp2;
    }
}
