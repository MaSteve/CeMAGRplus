package cemagr;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArgumentListNode extends ParserNode {
    private ArgumentNode arg;
    private ArgumentListNode next;
    private HashMap<String, Declaration> variables;

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
        for (Map.Entry<String, Declaration> entry: previous.entrySet()) {
            variables.put(entry.getKey(), entry.getValue());
        }
        initBlockReferences(variables);
    }

    private void initBlockReferences(HashMap<String, Declaration> ref) {
        variables = ref;
        if (next != null) next.initBlockReferences(ref);
        ref.put(arg.getID(), arg);
    }

    public HashMap<String, Declaration> getVariables() {
        return variables;
    }
    @Override
    public String toString() {
        return (next == null? "": next + ", " ) + arg;
    }
}
