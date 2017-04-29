package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class VarListNode extends ParserNode{
    private VarReferenceNode var;
    private VarListNode next;

    public VarListNode(VarReferenceNode var) {
        init(var, null);
    }
    public VarListNode(VarReferenceNode var, VarListNode node) {
        init(var, node);
    }

    private void init(VarReferenceNode var, VarListNode node) {
        this.var = var;
        next = node;
    }
    @Override
    public String toString() {
        return (next == null? "": next + ", " ) + var;
    }
}
