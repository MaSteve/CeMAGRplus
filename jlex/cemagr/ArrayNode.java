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
    private int d = 1;

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
        if (next != null) next.setStaticArrayNode(node.getStaticArrayNode());
     }

    public void translate(){
        exp.translate();
        Application.newInst("chk " + 0 + " " + def.getSize());
        if (next != null) d = d * def.getSize() * next.d;
        Application.newInst("ixa " + d);
        next.translate();
    }

    @Override
    public String toString() {
        return (next == null? "": next) + "[" + exp + "]";
    }
}
