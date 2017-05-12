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

    public void solveReferences(HashMap<String, DeclarationNode> previous) {
        cond.solveReferences(previous);
        block.solveReferences(previous);
    }

    @Override
    public String toString() {
        return "While: " + cond + " { " + block + " } ";
    }
}
