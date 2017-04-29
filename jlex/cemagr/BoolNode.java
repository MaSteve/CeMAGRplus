package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class BoolNode extends ParserNode {
    private boolean value;

    public BoolNode(Yytoken token) {
        super(token);
        value = token.m_text.equals("YEAH");
    }

    @Override
    public String toString() {
        return "BoolNode: " + value;
    }
}
