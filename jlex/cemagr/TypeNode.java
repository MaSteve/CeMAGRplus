package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class TypeNode extends ParserNode {
    private String value;

    public TypeNode(Yytoken token) {
        super(token);
        value = token.m_text;
    }

    @Override
    public String toString() {
        return value;
    }
}
