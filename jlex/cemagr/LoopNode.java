package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class LoopNode extends ParserNode{
    private ParserNode cond;
    private ParserNode block;

    public LoopNode(ParserNode cond, ParserNode block) {
        this.cond = cond;
        this.block = block;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        cond.solveReferences(previous);
        block.solveReferences(previous);
    }

    public Type getTYPE() {
        if (cond.getTYPE() == Type.BOOL && block.getTYPE() == Type.OK) TYPE = Type.OK;
        else TYPE = Type.FAIL;
        return TYPE;
    }

    @Override
    public String toString() {
        return "While: " + cond + " { " + block + " } ";
    }
}
