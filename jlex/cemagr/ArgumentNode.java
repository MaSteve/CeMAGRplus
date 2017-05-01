package cemagr;

import static cemagr.OperatorNode.DEREFERENCE;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArgumentNode extends ParserNode {
    private boolean array;
    private TypeNode type;
    private VarIDNode id;
    private StaticArrayNode arrayNode;
    private boolean ptr;

    public ArgumentNode(TypeNode type, VarIDNode id) {
        array = false;
        this.type = type;
        this.id = id;
    }

    public ArgumentNode(TypeNode type, VarIDNode id, StaticArrayNode arrayNode) {
        array = true;
        this.type = type;
        this.id = id;
        this.arrayNode = arrayNode;
    }

    public ArgumentNode(TypeNode type, VarIDNode id, boolean ptr) {
        array = false;
        this.type = type;
        this.id = id;
        if(ptr) this.ptr = true;
    }

    @Override
    public String toString() {
        return "Arg: " + type + (ptr? "ptr":"") + (array? arrayNode: "") + " ID: " + id;
    }
}
