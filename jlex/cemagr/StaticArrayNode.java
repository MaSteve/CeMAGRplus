package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class StaticArrayNode extends ParserNode {
    private ParserNode exp;
    private StaticArrayNode next;

    public StaticArrayNode(ParserNode exp) {
        init(exp, null);
    }
    public StaticArrayNode(ParserNode exp, StaticArrayNode node) {
        init(exp, node);
    }

    private void init(ParserNode exp, StaticArrayNode node) {
        this.exp = exp;
        next = node;
    }
    @Override
    public String toString() {
        return (next == null? "": next) + "[" + exp + "]";
    }
}
