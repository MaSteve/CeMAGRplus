package cemagr;

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

    @Override
    public String toString() {
        return "";
    }
}
