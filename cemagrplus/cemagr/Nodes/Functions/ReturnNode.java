package cemagr.Nodes.Functions;

import cemagr.Nodes.ParserNode;

public class ReturnNode extends ParserNode{
    private ParserNode exp;

    public ReturnNode(ParserNode exp) {
        this.exp = exp;
    }
    @Override
    public String toString() {
        return "RETURN:\n" + exp;
    }
}
