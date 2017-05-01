package cemagr;

import static cemagr.OperatorNode.DEREFERENCE;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class VarReferenceNode extends ParserNode{
    private String id;
    private boolean array;
    private ArrayNode arrayNode;
    private boolean ptr;

    public VarReferenceNode(Yytoken token) {
        super(token);
        id = token.m_text;
        array = false;
        ptr = false;
    }

    public VarReferenceNode (Yytoken token, ArrayNode arrayNode) {
        super(token);
        id = token.m_text;
        array = true;
        this.arrayNode = arrayNode;
        ptr = false;
    }

    public VarReferenceNode (Yytoken token, OperatorNode opNode) {
        super(token);
        id = token.m_text;
        array = false;
        if(opNode.op == DEREFERENCE) ptr = true;
    }

    @Override
    public String toString() {
        return "Ref: " + (ptr? "ptr ":"")  + id + (array? arrayNode: "");
    }
}
