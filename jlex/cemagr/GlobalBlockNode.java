package cemagr;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by celia on 30/4/17.
 */
public class GlobalBlockNode extends ParserNode {
    private static final HashMap<String, FuncDeclarationNode> functions = new HashMap<>();
    private static final HashMap<String, Declaration> global_variables = new HashMap<>();
    private static final HashSet<String> ids = new HashSet<>();

    private Declaration inst;
    private GlobalBlockNode next;

    private static int declSize = 0;

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
        global_variables.put(inst.getID(), inst);
        if (!ids.contains(inst.getID())) ids.add(inst.getID());
        else Application.notifyError(Application.DUPLICATED_MSG
                    + " " + inst.getID()
                    + " (" + inst.getLine() + ", " + inst.getColumn() + ")");

        if (inst.getClassType() == Declaration.FUNC) {
            functions.put(inst.getID(), (FuncDeclarationNode) inst);
        } else {
            ((DeclarationNode) inst).setGlobal();
            declSize += inst.getDeclSize();
        }
        //initReferences();
    }

    public static void initReferences() {
        for (Map.Entry<String, FuncDeclarationNode> entry: functions.entrySet()) {
            entry.getValue().solveReferences(global_variables);
        }
    }

    public static boolean typeChecker() {
        boolean ret = true;
        for (Map.Entry<String, FuncDeclarationNode> entry: functions.entrySet()) {
            ret = entry.getValue().getTYPE() == Type.OK && ret;
        }
        return ret;
    }

    public static boolean hasMain() {
        boolean ok = functions.containsKey("main");
        if (!ok) Application.notifyError(Application.MAIN_MSG);
        return ok;
    }

    public int getDeclSize() {
        return declSize;
    }

    public void translate() {
        // Stack
        Application.newInst("ssp " + getDeclSize() + 5);
        // Solve addresses
        int address = functions.get("main").getInstSize() + 1;
        functions.get("main").setAddress(1);
        for (Map.Entry<String, FuncDeclarationNode> entry: functions.entrySet()) {
            if (!entry.getKey().equals("main")) {
                entry.getValue().setAddress(address);
                address += entry.getValue().getInstSize();
            }
        }
        // Main
        functions.get("main").translate();
        // Functions
        for (Map.Entry<String, FuncDeclarationNode> entry: functions.entrySet()) {
            if (!entry.getKey().equals("main")) entry.getValue().translate();
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
