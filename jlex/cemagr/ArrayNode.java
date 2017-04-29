package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArrayNode extends ParserNode{
    private ParserNode exp;
    private ArrayNode next;

    public ArrayNode(ParserNode exp) {
        init(exp, null);
    }
    public ArrayNode(ParserNode exp, ArrayNode node) {
        init(exp, node);
    }

    private void init(ParserNode exp, ArrayNode node) {
        this.exp = exp;
        next = node;
    }
    @Override
    public String toString() {
        return (next == null? "": next) + "[" + exp + "]";
    }
}
