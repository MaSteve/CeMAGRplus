package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class StringNode extends ParserNode {
    private String value;

    public StringNode(Yytoken token) {
        super(token);
        value = token.m_text;
    }

    @Override
    public String toString() {
        return "StringNode: " + value;
    }
}
