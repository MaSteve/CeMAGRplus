package cemagr.Nodes.Expressions;

import cemagr.Application;
import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;
import cemagr.Utils.Type;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class BinaryExpression extends ParserNode {
    private OperatorNode op;
    private ParserNode exp1, exp2;
    private int instSize = -1;

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
        if (exp1Type == exp2.getTYPE() && exp1Type == op.getTYPE()) TYPE = op.retType();
        else {
            Application.notifyError(Application.TYPE_MSG + ": " + Application.TYPE_EXP_MSG + op.getTYPE()
                    + " (" + op.getLine() + ", " + op.getColumn() + ")");
            TYPE = Type.FAIL;
        }
        return TYPE;
    }

    public void translate() {
        exp1.translate();
        exp2.translate();
        op.translate();
    }

    @Override
    public String toString() {
        return "BinaryExpression: \n" + exp1 + "\n" + op + "\n" + exp2;
    }
}
