package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public abstract class ParserNode {
    protected Yytoken token;
    protected boolean decl; //TODO: Refactor
    protected Type TYPE;


    public void solveReferences(HashMap<String, Declaration> previous) {

    }

    public ParserNode() {
        token = null;
        decl = false;
        TYPE = Type.UNKNOWN;
    }

    public ParserNode(Yytoken token) {
        this.token = token;
        decl = false;
        TYPE = Type.UNKNOWN;
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

    protected void setTYPE(Type type) {
        this.TYPE = type;
    }

    public Type getTYPE() {
        return TYPE;
    }

    @Override
    public abstract String toString();

    public boolean isRefenceNode() {
        return false;
    }
}
