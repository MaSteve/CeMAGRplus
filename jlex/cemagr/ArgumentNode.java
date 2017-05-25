package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArgumentNode extends DeclarationNode {

    public ArgumentNode(TypeNode type, VarIDNode id) {
        super(type, id);
        typeClass = Declaration.ARG;
    }

    public ArgumentNode(TypeNode type, VarIDNode id, StaticArrayNode arrayNode) {
        super(type, id, arrayNode);
        typeClass = Declaration.ARG;
    }

    public ArgumentNode(TypeNode type, VarIDNode id, boolean ptr) {
        super(type, id, ptr);
        typeClass = Declaration.ARG;
    }

    public int getDeclSize() {
        return 1;
    }
}
