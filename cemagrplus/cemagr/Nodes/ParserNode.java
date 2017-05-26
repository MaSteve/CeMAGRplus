package cemagr.Nodes;

import cemagr.Utils.AddressSolver;
import cemagr.Utils.Type;
import cemagr.parser.Yytoken;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public abstract class ParserNode {
    public Yytoken token;
    protected boolean decl = false; //TODO: Refactor
    protected boolean controlStructure = false;
    protected Type TYPE = Type.UNKNOWN;


    public void solveReferences(HashMap<String, Declaration> previous) {

    }

    public ParserNode() {
        token = null;
    }

    public ParserNode(Yytoken token) {
        this.token = token;
    }

    public int getLine() {
        return token == null? -1: token.m_line;
    }

    public int getColumn() {
        return token == null? -1: token.m_col;
    }

    public boolean isDecl() {
        return decl;
    }

    public boolean isControlStructure() {
        return controlStructure;
    }

    public void setTYPE(Type type) {
        this.TYPE = type;
    }

    public Type getTYPE() {
        return TYPE;
    }

    @Override
    public abstract String toString();

    public boolean isReferenceNode() {
        return false;
    }

    public int sizeAndSolve(AddressSolver solver) {
        return 0;
    }

    public void translate() {

    }

    public int getInstSize() {
        return 0;
    }
}
