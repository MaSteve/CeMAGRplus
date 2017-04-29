package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class FuncCallNode extends ParserNode {
    private String id;
    private VarListNode list;
    private boolean arg;

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

    @Override
    public String toString() {
        return "call: " + id + " ( " + (arg? list: "") + " ) ";
    }
}
