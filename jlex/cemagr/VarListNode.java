package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class VarListNode extends ParserNode{
    private ParserNode var;
    private VarListNode next;

    public VarListNode(ParserNode var) {
        init(var, null);
    }
    public VarListNode(ParserNode var, VarListNode node) {
        init(var, node);
    }

    private void init(ParserNode var, VarListNode node) {
        this.var = var;
        next = node;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        if (next != null) next.solveReferences(previous);
        var.solveReferences(previous);
    }

    public ParserNode getExp() {
        return var;
    }

    public VarListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return (next == null? "": next + ", " ) + var;
    }
}
