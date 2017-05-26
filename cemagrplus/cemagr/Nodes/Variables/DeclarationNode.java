package cemagr.Nodes.Variables;

import cemagr.Nodes.Declaration;
import cemagr.Nodes.TypeNode;
import cemagr.Utils.AddressSolver;
import cemagr.Utils.Type;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class DeclarationNode extends Declaration {
    private boolean array;
    private VarIDNode id;
    private StaticArrayNode arrayNode;
    private boolean ptr;
    private boolean global;
    private int declSize = -1;

    public DeclarationNode(TypeNode type, VarIDNode id) {
        super(Declaration.VAR, id.token);
        array = false;
        this.type = type;
        this.id = id;
        ptr = false;
    }

    public DeclarationNode(TypeNode type, VarIDNode id, StaticArrayNode arrayNode) {
        super(Declaration.VAR, id.token);
        array = true;
        this.type = type;
        this.id = id;
        this.arrayNode = arrayNode;
        ptr = false;
    }

    public DeclarationNode(TypeNode type, VarIDNode id, boolean ptr) {
        super(Declaration.VAR, id.token);
        array = false;
        this.type = type;
        this.id = id;
        this.ptr = ptr;
    }

    public void setGlobal() {
        global = true;
    }

    public boolean isGlobal() {
        return global;
    }

    public int getDeclSize() {
        if (declSize == -1) {
            if (array) {
                declSize = arrayNode.getDeclSize();
            } else declSize = 1;
        }
        return declSize;
    }

    public int sizeAndSolve(AddressSolver solver) {
        declSize = getDeclSize();
        address = solver.getAddress(declSize);
        return declSize;
    }

    public boolean isArray() {
        return array;
    }

    public boolean isPtr() {
        return ptr;
    }

    public StaticArrayNode getArrayNode() {
        return arrayNode;
    }

    public Type getTYPE() {
        if (array) {
            return arrayNode.getTYPE();
        }
        return TYPE;
    }

    @Override
    public String toString() {
        return "Var: " + type + (ptr? " ptr":"") + (array? arrayNode: "") + " ID: " + id;
    }

    @Override
    public String getID() {
        return id.toString();
    }
}
