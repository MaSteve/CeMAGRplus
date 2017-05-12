package cemagr;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by celia on 30/4/17.
 */
public class GlobalBlockNode extends ParserNode {
    private static final HashMap<String, FuncDeclarationNode> functions = new HashMap<>();
    private static final HashMap<String, Declaration> global_variables = new HashMap<>();

    private Declaration inst;
    private GlobalBlockNode next;

    public GlobalBlockNode(Declaration inst) {
        init(inst, null);
    }
    public GlobalBlockNode(Declaration inst, GlobalBlockNode node) {
        init(inst, node);
    }

    private void init(Declaration inst, GlobalBlockNode node) {
        this.inst = inst;
        next = node;
    }

    public void initGlobalReferences() {
        if (next != null) next.initGlobalReferences();
        if (inst.getType() == Declaration.VAR) global_variables.put(inst.getID(), inst);
        else if (inst.getType() == Declaration.FUNC) functions.put(inst.getID(), (FuncDeclarationNode) inst);
        initReferences();
    }

    private static void initReferences() {
        for (Map.Entry<String, FuncDeclarationNode> entry: functions.entrySet()) {
            entry.getValue().solveReferences(global_variables);
        }
    }

    public static Declaration getGlobalVarReference(String id) {
        return global_variables.get(id);
    }

    public static Declaration getFunctionReference(String id) {
        return functions.get(id);
    }

    @Override
    public String toString() {
        return (next == null? "": next + "\n" ) + inst + ";";
    }

    public static String getRefs() {
        String ret = "Func:\n";
        for (Map.Entry<String, FuncDeclarationNode> entry: functions.entrySet()) {
            ret += entry.getKey() + "\n";
        }
        ret += "Var:\n";
        for (Map.Entry<String, Declaration> entry: global_variables.entrySet()) {
            ret += entry.getKey() + "\n";
        }
        return ret;
    }
}
