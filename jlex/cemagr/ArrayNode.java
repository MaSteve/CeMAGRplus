package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArrayNode extends ParserNode{
    private ParserNode exp;
    private ArrayNode next;
    private int len = -1;
    private StaticArrayNode def;
    private int d = -1;
    private int instSize = -1;

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

    public Type getTYPE() {
        Type nextType = Type.OK;
        if (next != null) nextType = next.getTYPE();
        if (nextType == Type.OK && exp.getTYPE() == Type.INT) TYPE = Type.OK;
        else TYPE = Type.FAIL;
        return TYPE;
    }

    public void setStaticArrayNode(StaticArrayNode node) {
        def = node;
        d = 1;
        if (next != null) {
            next.setStaticArrayNode(node.getStaticArrayNode());
            d = next.def.getSize() * next.d;
        }
    }

    public int getInstSize() {
        if (instSize == -1) {
            instSize = 0;
            if (next != null) instSize = next.getInstSize();
            instSize += exp.getInstSize() +  2;
        }
        return instSize;
    }

    public void translate(){
        exp.translate();
        Application.newInst("chk " + 0 + " " + def.getSize());
        Application.newInst("ixa " + d);
        if (next != null) next.translate();
        Application.newComment("[idx]");
    }

    @Override
    public String toString() {
        return (next == null? "": next) + "[" + exp + "]";
    }
}
