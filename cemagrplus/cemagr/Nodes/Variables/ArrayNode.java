package cemagr.Nodes.Variables;

import cemagr.Application;
import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;
import cemagr.Utils.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArrayNode extends ParserNode {
    private StaticArrayNode def;

    private List<ParserNode> expressions;

    public ArrayNode(ParserNode exp) {
        expressions = new ArrayList<>();
        expressions.add(exp);
    }
    public ArrayNode(ParserNode exp, ArrayNode node) {
        expressions = node.getExpressions();
        expressions.add(exp);
    }

    public List<ParserNode> getExpressions() {
        return expressions;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        for (ParserNode exp : expressions)
            exp.solveReferences(previous);
    }

    public int getDim() {
        return expressions.size();
    }

    public Type getTYPE() {
        TYPE = Type.OK;
        for (ParserNode exp : expressions) {
            if (exp.getTYPE() != Type.INT) TYPE = Type.FAIL;
        }
        return TYPE;
    }

    public void setStaticArrayNode(StaticArrayNode node) {
        def = node;
    }

    public void translate(){
        /*exp.translate();
        Application.newInst("chk " + 0 + " " + def.getSize());
        Application.newInst("ixa " + d);
        if (next != null) next.translate();
        Application.newComment("[idx]");*/
    }

    @Override
    public String toString() {
        String s = "";
        for (ParserNode exp : expressions) {
            s += "[" + exp.toString() + "]";
        }
        return s;
    }
}
