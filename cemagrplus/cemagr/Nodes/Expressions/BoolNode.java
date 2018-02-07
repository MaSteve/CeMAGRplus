package cemagr.Nodes.Expressions;

import cemagr.Application;
import cemagr.Nodes.ParserNode;
import cemagr.Utils.Type;
import cemagr.parser.Yytoken;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class BoolNode extends ParserNode {
    private boolean value;

    public BoolNode(Yytoken token) {
        super(token);
        value = token.m_text.equals("true");
    }

    public Type getTYPE() {
        return Type.BOOL;
    }

    public int getInstSize() {
        return 1;
    }

    public void translate() {
        Application.newInst("ldc " + value);
        Application.newComment(" bool: " + value + " ");
    }

    @Override
    public String toString() {
        return "BoolNode: " + value;
    }
}
