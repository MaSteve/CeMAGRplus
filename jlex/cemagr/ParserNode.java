package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public abstract class ParserNode {
    protected Yytoken token;
    protected boolean decl;
    //protected boolean hasBlock; //TODO: Refactor
    private int NODE_TYPE;

    public static int BLOCK = 0;
    public static int DECL = 1;
    public static int FUNC = 2;
    public static int IF = 3;

    public void solveReferences(HashMap<String, DeclarationNode> previous) {

    }


    public ParserNode() {
        token = null;
        decl = false;
    }

    public ParserNode(Yytoken token) {
        this.token = token;
        decl = false;
    }

    public boolean isDecl() {
        return decl;
    }

    @Override
    public abstract String toString();
}
