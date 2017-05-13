package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class AssNode extends ParserNode {
    private VarReferenceNode var;
    private ParserNode exp;

    public AssNode(VarReferenceNode var, ParserNode exp) {
        this.var = var;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "ASS: " + var + " = " + exp;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        var.solveReferences(previous);
        exp.solveReferences(previous);
    }

    public Type getTYPE() {
        Type varType = var.getTYPE();
        if (varType == exp.getTYPE() && varType != Type.FAIL) TYPE = Type.OK;
        else {
            Application.notifyError(Application.TYPE_MSG + ": "
                    + " (" + getLine() + ", " + getColumn() + ")");
            TYPE = Type.FAIL;
        }
        return TYPE;
    }
}
