package cemagr;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by celia on 30/4/17.
 */
public class BlockNode extends ParserNode {
    private HashMap<String, Declaration> variables;

    private ParserNode inst;
    private BlockNode next;

    public BlockNode (ParserNode inst) {
        init(inst, null);
    }
    public BlockNode (ParserNode inst, BlockNode node) {
        init(inst, node);
    }

    private void init(ParserNode inst, BlockNode node) {
        this.inst = inst;
        next = node;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        variables = new HashMap<>();
        for (Map.Entry<String, Declaration> entry: previous.entrySet()) {
            variables.put(entry.getKey(), entry.getValue());
        }
        initBlockReferences(variables);
    }

    public HashMap<String, Declaration> getVariables() {
        return variables;
    }

    private void initBlockReferences(HashMap<String, Declaration> ref) {
        variables = ref;
        if (next != null) next.initBlockReferences(ref);
        if (inst.isDecl()) ref.put(((DeclarationNode) inst).getID(), ((DeclarationNode) inst));
        inst.solveReferences(ref);
    }

    @Override
    public String toString() {
        return (next == null? "": next + "\n" ) + inst + ";";
    }
}
