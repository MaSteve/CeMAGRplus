package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArrayNode extends ParserNode{
    private ParserNode exp;
    private ArrayNode next;
    private int len = -1;

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

    public void solveReferences(HashMap<String, Declaration> previous) {
        if (next != null) next.solveReferences(previous);
        exp.solveReferences(previous);
    }

    public int getDim() {
        if (len == -1) {
            if (next == null) len = 1;
            else len = next.getDim() + 1;
        }
        return len;
    }

    public ParserNode getExp(){
        return exp;
    }

    public ArrayNode getArrayNode(){
        return next;
    }

    public Type getTYPE() {
        Type nextType = Type.OK;
        if (next != null) nextType = next.getTYPE();
        if (nextType == Type.OK && exp.getTYPE() == Type.INT) TYPE = Type.OK;
        else TYPE = Type.FAIL;
        return TYPE;
    }

    @Override
    public String toString() {
        return (next == null? "": next) + "[" + exp + "]";
    }
}
