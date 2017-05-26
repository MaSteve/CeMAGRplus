package cemagr.Nodes.Expressions;

import cemagr.Application;
import cemagr.Nodes.ParserNode;
import cemagr.Utils.Type;
import cemagr.parser.Yytoken;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class NumNode extends ParserNode {
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
        Application.newComment(" cte: " + value + " ");
    }

    @Override
    public String toString() {
        return "NumNode: " + value;
    }
}
