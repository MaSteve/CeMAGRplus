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

    public Type getTYPE() {
        return Type.INT;
    }

    public int getValue() {
        return value;
    }

    public int getInstSize() {
        return 1;
    }

    public void translate() {
        Application.newInst("ldc " + value);
    }

    @Override
    public String toString() {
        return "NumNode: " + value;
    }
}
