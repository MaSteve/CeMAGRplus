package cemagr.Nodes.Functions;

import cemagr.Application;
import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;
import cemagr.Nodes.Variables.DeclarationNode;
import cemagr.Nodes.Variables.StaticArrayNode;
import cemagr.Nodes.Variables.VarReferenceNode;
import cemagr.Utils.Type;
import cemagr.parser.Yytoken;

import java.util.HashMap;
import java.util.List;

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

    private boolean argChecker(VarListNode list, ArgumentListNode arg) {
        List<ParserNode> variables = list.getVariables();
        List<ArgumentNode> arguments = arg.getArguments();
        if (arguments.size() == variables.size()) {
            boolean ok = true;
            for (int i = 0; i < arguments.size(); i++) {
                if (variables.get(i).isReferenceNode() && ((VarReferenceNode) variables.get(i)).isArray() && arguments.get(i).isArray()) {
                    ok = StaticArrayNode.check(((DeclarationNode) ((VarReferenceNode) variables.get(i)).getDef()).getArrayNode(),
                            arguments.get(i).getArrayNode()) && ok;
                } else if (!arguments.get(i).isArray()) {
                    if (variables.get(i).isReferenceNode() && ((VarReferenceNode) variables.get(i)).isArray()) ok = false;
                    Type varType = variables.get(i).getTYPE();
                    Type argType = arguments.get(i).getDeclTYPE();
                    if (arguments.get(i).isPtr()) {
                        argType = arguments.get(i).getDeclTYPE();
                        if (argType == Type.INT) argType = Type.PTR_INT;
                        if (argType == Type.BOOL) argType = Type.PTR_BOOL;
                    }
                    ok &= varType == argType && argType != Type.FAIL;
                }
            }

            return ok;
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
        return TYPE;
    }

    public void translate() {
        Application.newComment(" call: " + id + " ");
        Application.newInst("mst " + 1);
        list.translate();
        //Application.newInst("cup " + (arg? list.getSize(): 0) + " " + def.getAddress());
    }

    @Override
    public String toString() {
        return "call: " + id + " ( " + (arg? list: "") + " ) ";
    }
}
