package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class NumNode extends cemagr.ParserNode {
    private int value;

    public NumNode(Yytoken token) {
        super(token);
        value = Integer.valueOf(token.m_text);
    }

    @Override
    public String toString() {
        return "NumNode: " + value;
    }
}
