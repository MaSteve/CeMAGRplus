package cemagr;

import java.util.HashMap;

import static cemagr.OperatorNode.ADDRESS;
import static cemagr.OperatorNode.DEREFERENCE;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class VarReferenceNode extends ParserNode{
    private String id;
    private boolean array;
    private ArrayNode arrayNode;

    private boolean dereference;
    private boolean address;

    private Declaration def;

    public VarReferenceNode(Yytoken token) {
        super(token);
        id = token.m_text;
        array = false;
        dereference = false;
        address = false;
    }

    public VarReferenceNode (Yytoken token, ArrayNode arrayNode) {
        super(token);
        id = token.m_text;
        array = true;
        this.arrayNode = arrayNode;
        dereference = false;
        address = false;
    }

    public VarReferenceNode (Yytoken token, OperatorNode opNode) {
        super(token);
        id = token.m_text;
        array = false;
        if (opNode.op == DEREFERENCE) dereference = true; //TODO: Refactor
        else if (opNode.op == ADDRESS) address = true;
    }

    public boolean isArray() {
        return !array && ((DeclarationNode) def).isArray();
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        if (!previous.containsKey(id)) {
            Application.notifyError(Application.UNKNOWN_MSG
                    + " " + id
                    + " (" + getLine() + ", " + getColumn() + ")");
        } else {
            def = previous.get(id);
        }
        if (array) arrayNode.solveReferences(previous);
    }

    public Type getTYPE() {
        if (def == null || def.getClassType() == Declaration.FUNC) {
            TYPE = Type.FAIL;
        } else {
            if (dereference) {
                if (((DeclarationNode)def).isPtr()) TYPE = def.getDeclTYPE();
                else {
                    Application.notifyError(Application.TYPE_MSG + ": "
                            + Application.DEREFENCE_MSG + id
                            + " (" + getLine() + ", " + getColumn() + ")");
                    TYPE = Type.FAIL;
                }
            } else if (address) {
                if (!((DeclarationNode)def).isPtr() && !((DeclarationNode)def).isArray()) {
                    if (def.getDeclTYPE() == Type.INT) TYPE = Type.PTR_INT;
                    else if (def.getDeclTYPE() == Type.BOOL) TYPE = Type.PTR_BOOL;
                } else {
                    Application.notifyError(Application.TYPE_MSG + ": "
                            + Application.ADDRESS_MSG + id
                            + " (" + getLine() + ", " + getColumn() + ")");
                    TYPE = Type.FAIL;
                }
            } else if (array) {
                if (((DeclarationNode)def).isArray()){
                    StaticArrayNode staticArrayNode = (((DeclarationNode)def).getArrayNode());
                    Type arrayType = arrayNode.getTYPE();
                    if (staticArrayNode.getLen() == arrayNode.getLen() && arrayType == Type.OK) {
                        TYPE = def.getDeclTYPE();
                    } else {
                        Application.notifyError(Application.TYPE_MSG + ": "
                                + Application.ARRAY2_MSG + id
                                + " (" + getLine() + ", " + getColumn() + ")");
                        TYPE = Type.FAIL;
                    }
                } else {
                    Application.notifyError(Application.TYPE_MSG + ": "
                            + Application.ARRAY_MSG + id
                            + " (" + getLine() + ", " + getColumn() + ")");
                    TYPE = Type.FAIL;
                }
            } else {
                if (((DeclarationNode)def).isPtr()) {
                    if (def.getDeclTYPE() == Type.INT) TYPE = Type.PTR_INT;
                    else if (def.getDeclTYPE() == Type.BOOL) TYPE = Type.PTR_BOOL;
                } else if (((DeclarationNode)def).isArray()) {
                    Application.notifyError(Application.TYPE_MSG + ": "
                            + id + Application.ARRAY3_MSG
                            + " (" + getLine() + ", " + getColumn() + ")");
                    TYPE = Type.FAIL;
                }
                else TYPE = def.getDeclTYPE();
            }
        }
        return TYPE;
    }

    @Override
    public String toString() {
        return "Ref: " + (dereference? "ptr ":"")  + id + (array? arrayNode: "");
    }
}
