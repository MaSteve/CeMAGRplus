package cemagr;

import java.util.HashMap;

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

    public void solveReferences(HashMap<String, Declaration> previous) {
        if (next != null) next.solveReferences(previous);
        var.solveReferences(previous);
    }

    @Override
    public String toString() {
        return (next == null? "": next + ", " ) + var;
    }
}
