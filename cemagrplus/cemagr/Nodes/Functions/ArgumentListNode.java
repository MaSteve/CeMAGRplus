package cemagr.Nodes.Functions;

import cemagr.Application;
import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;
import cemagr.Utils.AddressSolver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArgumentListNode extends ParserNode {
    private ArgumentNode arg;
    private ArgumentListNode next;
    private HashMap<String, Declaration> variables;
    private HashSet<String> ids;
    private int declSize = -1;

    public ArgumentListNode(ArgumentNode arg) {
        init(arg, null);
    }
    public ArgumentListNode(ArgumentNode arg, ArgumentListNode node) {
        init(arg, node);
    }

    private void init(ArgumentNode arg, ArgumentListNode node) {
        this.arg = arg;
        next = node;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        variables = new HashMap<>();
        ids = new HashSet<>();
        for (Map.Entry<String, Declaration> entry: previous.entrySet()) {
            variables.put(entry.getKey(), entry.getValue());
        }
        initBlockReferences(variables, ids);
    }

    private void initBlockReferences(HashMap<String, Declaration> ref,  HashSet<String> ids) {
        variables = ref;
        this.ids = ids;
        if (next != null) next.initBlockReferences(ref, ids);
        ref.put(arg.getID(), arg);
        if (!ids.contains(arg.getID()))
            ids.add(arg.getID());
        else Application.notifyError(Application.DUPLICATED_MSG
                + " " + arg.getID()
                + " (" + arg.getLine() + ", " + arg.getColumn() + ")");
    }

    public ArgumentNode getArgument() {
        return arg;
    }

    public ArgumentListNode getNext() {
        return next;
    }

    public HashMap<String, Declaration> getVariables() {
        return variables;
    }

    public int getDeclSize() {
        if (declSize == -1) {
            if (next == null) declSize = arg.getDeclSize();
            else declSize = next.getDeclSize() + arg.getDeclSize();
        }
        return declSize;
    }

    public int sizeAndSolve(AddressSolver solver) {
        if (next != null) next.sizeAndSolve(solver);
        arg.sizeAndSolve(solver);
        declSize = solver.getSize();
        return declSize;
    }

    @Override
    public String toString() {
        return (next == null? "": next + ", " ) + arg;
    }
}
