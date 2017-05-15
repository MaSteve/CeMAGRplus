package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class FuncCallNode extends ParserNode {
    private String id;
    private VarListNode list;
    private boolean arg;

    private Declaration def;

    public FuncCallNode(Yytoken token, VarListNode list) {
        super(token);
        this.id = token.m_text;
        this.list = list;
        this.arg = true;
    }

    public FuncCallNode(Yytoken token) {
        super(token);
        this.id = token.m_text;
        this.arg = false;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        if (!previous.containsKey(id)) {
            Application.notifyError(Application.UNKNOWN_MSG
                    + " " + id
                    + " (" + getLine() + ", " + getColumn() + ")");
        } else {
            def = previous.get(id);
        }
        if (arg) list.solveReferences(previous);
    }

    public boolean argChecker(VarListNode list, ArgumentListNode arg) {
        if (list == null && arg == null) return true;
        else if (list != null && arg != null) {
            boolean ok = argChecker(list.getNext(), arg.getNext());
            if (list.getExp().isRefenceNode() && ((VarReferenceNode) list.getExp()).isArray() && arg.getArgument().isArray()) {
                return StaticArrayNode.check(((DeclarationNode)((VarReferenceNode)list.getExp()).getDef()).getArrayNode(),
                        arg.getArgument().getArrayNode()) && ok;
            } else if (!arg.getArgument().isArray()) {
                if (list.getExp().isRefenceNode() && ((VarReferenceNode) list.getExp()).isArray()) return false;
                Type varType = list.getExp().getTYPE();
                Type argType = arg.getArgument().getDeclTYPE();
                if (arg.getArgument().isPointer()) {
                    argType = arg.getArgument().getDeclTYPE();
                    if (argType == Type.INT) argType = Type.PTR_INT;
                    if (argType == Type.BOOL) argType = Type.PTR_BOOL;
                }
                if (varType == argType && argType != Type.FAIL && ok) return true;
            }
        }
        return false;
    }

    public Type getTYPE() {
        if (def == null || def.getClassType() != Declaration.FUNC) {
            TYPE = Type.FAIL;
        } else {
            if (arg && ((FuncDeclarationNode) def).hasArguments()) {
                if (argChecker(list, ((FuncDeclarationNode) def).getArguments())) {
                    TYPE = def.getDeclTYPE();
                } else TYPE = Type.FAIL;
            } else if (!arg && !((FuncDeclarationNode) def).hasArguments()) {
                TYPE = def.getDeclTYPE();
            } else {
                TYPE = Type.FAIL;
            }

            if (TYPE == Type.FAIL) {
                Application.notifyError(Application.TYPE_MSG + ": "
                        + Application.ARG_MSG + id
                        + " (" + getLine() + ", " + getColumn() + ")");
            }
        }

        /*if (array) {
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
        }*/
        return TYPE;
    }

    @Override
    public String toString() {
        return "call: " + id + " ( " + (arg? list: "") + " ) ";
    }
}
