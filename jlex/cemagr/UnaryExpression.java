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

    public void solveReferences(HashMap<String, Declaration> previous) {
        exp.solveReferences(previous);
    }
}
