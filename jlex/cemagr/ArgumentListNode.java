package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArgumentListNode extends ParserNode {
    private ArgumentNode arg;
    private ArgumentListNode next;

    public ArgumentListNode(ArgumentNode arg) {
        init(arg, null);
    }
    public ArgumentListNode(ArgumentNode arg, ArgumentListNode node) {
        init(arg, node);
    }

    private void init(ArgumentNode arg, ArgumentListNode node) {
        this.arg = arg;
        next = node;
    }
    @Override
    public String toString() {
        return (next == null? "": next + ", " ) + arg;
    }
}
