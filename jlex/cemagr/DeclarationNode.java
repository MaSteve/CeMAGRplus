package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class DeclarationNode extends ParserNode {
    private boolean array;
    private TypeNode type;
    private VarIDNode id;
    private StaticArrayNode arrayNode;

    public DeclarationNode(TypeNode type, VarIDNode id) {
        array = false;
        this.type = type;
        this.id = id;
    }

    public DeclarationNode(TypeNode type, VarIDNode id, StaticArrayNode arrayNode) {
        array = true;
        this.type = type;
        this.id = id;
        this.arrayNode = arrayNode;
    }

    @Override
    public String toString() {
        return "Var: " + type + (array? arrayNode: "") + " ID: " + id;
    }
}
