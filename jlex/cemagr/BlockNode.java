package cemagr;


/**
 * Created by celia on 30/4/17.
 */
public class BlockNode extends ParserNode {

    private ParserNode inst;
    private BlockNode next;

    public BlockNode (ParserNode inst) {
        init(inst, null);
    }
    public BlockNode (ParserNode inst, BlockNode node) {
        init(inst, node);
    }

    private void init(ParserNode inst, BlockNode node) {
        this.inst = inst;
        next = node;
    }

    @Override
    public String toString() {
        return (next == null? "": next + "\n" ) + inst + ";";
    }
}
