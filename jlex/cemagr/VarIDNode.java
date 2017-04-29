package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class VarIDNode extends ParserNode {
    private String value;

    public VarIDNode(Yytoken token) {
        super(token);
        value = token.m_text;
    }

    @Override
    public String toString() {
        return value;
    }
}
