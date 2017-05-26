package cemagr.Nodes.Functions;

import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class VarListNode extends ParserNode {
    private ParserNode var;
    private VarListNode next;
    private int size = -1, instSize = -1;

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

    public int getSize() {
        if (size == -1) {
            if (next == null) size = 1;
            else size = next.getSize() + 1;
        }
        return size;
    }

    public int getInstSize() {
        if (instSize == -1) {
            if (next == null) instSize = var.getInstSize();
            else instSize = next.getInstSize() + var.getInstSize();
        }
        return instSize;
    }

    public void translate() {
        if (next != null) next.translate();
        var.translate();
    }

    @Override
    public String toString() {
        return (next == null? "": next + ", " ) + var;
    }
}
