package cemagr.Nodes.Functions;

import cemagr.Application;
import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;
import cemagr.Utils.AddressSolver;

import java.util.*;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArgumentListNode extends ParserNode {
    private HashMap<String, Declaration> variables;
    private HashSet<String> ids;
    private int declSize = -1;

    private List<ArgumentNode> arguments;

    public ArgumentListNode(ArgumentNode arg) {
        arguments = new ArrayList<>();
        arguments.add(arg);
    }
    public ArgumentListNode(ArgumentNode arg, ArgumentListNode node) {
        arguments = node.getArguments();
        arguments.add(arg);
    }

    public List<ArgumentNode> getArguments() {
        return arguments;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        variables = new HashMap<>();
        ids = new HashSet<>(); // TODO: WTF
        for (Map.Entry<String, Declaration> entry: previous.entrySet()) {
            variables.put(entry.getKey(), entry.getValue());
        }

        for (ArgumentNode arg : arguments) {
            variables.put(arg.getID(), arg);
            if (!ids.contains(arg.getID()))
                ids.add(arg.getID());
            else Application.notifyError(Application.DUPLICATED_MSG
                    + " " + arg.getID()
                    + " (" + arg.getLine() + ", " + arg.getColumn() + ")");
        }
    }

    public HashMap<String, Declaration> getVariables() { // TODO: Rename
        return variables;
    }

    @Override
    public String toString() {
        String s = "";
        boolean first = false;
        for (ArgumentNode arg : arguments) {
            if (first) s += ", ";
            else first = true;
            s += arg.toString();
        }
        return s;
    }
}
