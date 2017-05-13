package cemagr;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by celia on 30/4/17.
 */
public class BlockNode extends ParserNode {
    private HashMap<String, Declaration> variables;
    private HashSet<String> ids;

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
        ids = new HashSet<>();
        for (Map.Entry<String, Declaration> entry: previous.entrySet()) {
            variables.put(entry.getKey(), entry.getValue());
        }
        initBlockReferences(variables, ids);
        if (Application.debug()) System.out.println("BlockRef");
    }

    public Type getTYPE() {
        Type nextType = Type.OK;
        if (next != null) nextType = next.getTYPE();
        if (nextType == inst.getTYPE() && nextType == Type.OK) TYPE = Type.OK;
        else TYPE = Type.FAIL;
        return TYPE;
    }

    public HashMap<String, Declaration> getVariables() {
        return variables;
    }

    private void initBlockReferences(HashMap<String, Declaration> ref, HashSet<String> ids) {
        variables = ref;
        this.ids = ids;
        if (next != null) next.initBlockReferences(ref, ids);
        if (inst.isDecl()) {
            ref.put(((DeclarationNode) inst).getID(), ((DeclarationNode) inst));
            if (!ids.contains(((DeclarationNode) inst).getID()))
                ids.add(((DeclarationNode) inst).getID());
            else Application.notifyError(Application.DUPLICATED_MSG
                    + " " + ((DeclarationNode) inst).getID()
                    + " (" + inst.getLine() + ", " + inst.getColumn() + ")");
        }
        inst.solveReferences(ref);
    }

    @Override
    public String toString() {
        return (next == null? "": next + "\n" ) + inst + ";";
    }
}
