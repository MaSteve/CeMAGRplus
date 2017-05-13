package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class FoopNode extends ParserNode{
    private ParserNode preamble;
    private ParserNode cond;
    private ParserNode postamble;
    private ParserNode block;

    public FoopNode(ParserNode preamble, ParserNode cond, ParserNode postamble, ParserNode block) {
        this.preamble = preamble;
        this.cond = cond;
        this.postamble = postamble;
        this.block = block;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        preamble.solveReferences(previous);
        HashMap<String, Declaration> vars = ((BlockNode) preamble).getVariables();
        cond.solveReferences(vars);
        postamble.solveReferences(vars);
        block.solveReferences(vars);
    }

    public Type getTYPE() {
        Type preambleType = preamble.getTYPE();
        Type condType = cond.getTYPE();
        Type postambleType = postamble.getTYPE();
        Type blockType = block.getTYPE();
        if (condType == Type.BOOL && preambleType == postambleType
                && postambleType == blockType && blockType == Type.OK) TYPE = Type.OK;
        else TYPE = Type.FAIL;
        return TYPE;
    }

    @Override
    public String toString() {
        return "For: " + preamble + " ; " + cond + " ; " + postamble + " { " + block + " } ";
    }
}
