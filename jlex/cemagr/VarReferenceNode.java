package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class VarReferenceNode extends ParserNode{
    private String id;
    private boolean array;
    private ArrayNode arrayNode;

    public VarReferenceNode(Yytoken token) {
        super(token);
        id = token.m_text;
        array = false;
    }

    public VarReferenceNode (Yytoken token, ArrayNode arrayNode) {
        super(token);
        id = token.m_text;
        array = true;
        this.arrayNode = arrayNode;
    }

    @Override
    public String toString() {
        return "Ref: " + id + (array? arrayNode: "");
    }
}
