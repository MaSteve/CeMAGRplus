package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class StaticArrayNode extends ParserNode {
    private ParserNode exp;
    private StaticArrayNode next;
    private int len = -1;

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

    public int getLen() {
        if (len == -1) {
            if (next == null) len = 1;
            else len = next.getLen() + 1;
        }
        return len;
    }
    @Override
    public String toString() {
        return (next == null? "": next) + "[" + exp + "]";
    }
}
