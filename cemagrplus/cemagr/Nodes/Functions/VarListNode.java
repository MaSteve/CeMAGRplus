package cemagr.Nodes.Functions;

import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class VarListNode extends ParserNode {

    private List<ParserNode> variables;

    public VarListNode(ParserNode var) {
        variables = new ArrayList<>();
        variables.add(var);
    }
    public VarListNode(ParserNode var, VarListNode node) {
        variables = node.getVariables();
        variables.add(var);
    }

    public List<ParserNode> getVariables() {
        return variables;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        for (ParserNode var: variables) {
            var.solveReferences(previous);
        }
    }

    public void translate() {
        /*if (next != null) next.translate();
        var.translate();*/
    }

    @Override
    public String toString() {
        String s = "";
        boolean first = false;
        for (ParserNode var : variables) {
            if (first) s += ", ";
            else first = true;
            s += var.toString();
        }
        return s;
    }
}
