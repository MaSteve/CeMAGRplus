package cemagr;

import static cemagr.OperatorNode.DEREFERENCE;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class DeclarationNode extends ParserNode {
    private boolean array;
    private TypeNode type;
    private VarIDNode id;
    private StaticArrayNode arrayNode;
    private boolean ptr;

    public DeclarationNode(TypeNode type, VarIDNode id) {
        array = false;
        this.type = type;
        this.id = id;
        ptr = false;
    }

    public DeclarationNode(TypeNode type, VarIDNode id, StaticArrayNode arrayNode) {
        array = true;
        this.type = type;
        this.id = id;
        this.arrayNode = arrayNode;
        ptr = false;
    }

    public DeclarationNode(TypeNode type, VarIDNode id, boolean ptr) {
        array = false;
        this.type = type;
        this.id = id;
        if(ptr) this.ptr = true;
    }

    @Override
    public String toString() {
        return "Var: " + type + (ptr? " ptr":"") + (array? arrayNode: "") + " ID: " + id;
    }
}
