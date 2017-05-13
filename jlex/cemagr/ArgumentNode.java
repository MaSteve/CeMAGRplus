package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class ArgumentNode extends DeclarationNode {

    public ArgumentNode(TypeNode type, VarIDNode id) {
        super(type, id);
        //super(Declaration.ARG);
    }

    public ArgumentNode(TypeNode type, VarIDNode id, StaticArrayNode arrayNode) {
        super(type, id, arrayNode);
        //super(Declaration.ARG);
    }

    public ArgumentNode(TypeNode type, VarIDNode id, boolean ptr) {
        super(type, id, ptr);
        //super(Declaration.ARG);
    }

    /*@Override
    public String toString() {
        return "Arg: " + type + (ptr? "ptr":"") + (array? arrayNode: "") + " ID: " + id;
    }

    @Override
    public String getID() {
        return id.toString();
    }*/
}
