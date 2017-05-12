package cemagr;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class IfNode extends ParserNode {
    private ParserNode cond;
    private ParserNode block1;
    private ParserNode block2;
    private boolean elseBranch;

    public IfNode(ParserNode cond, ParserNode block1, ParserNode block2) {
        this.cond = cond;
        this.block1 = block1;
        this.block2 = block2;
        elseBranch = true;
    }

    public IfNode(ParserNode cond, ParserNode block1) {
        this.cond = cond;
        this.block1 = block1;
        elseBranch = false;
    }

    public void solveReferences(HashMap<String, DeclarationNode> previous) {
        cond.solveReferences(previous);
        block1.solveReferences(previous);
        if (elseBranch) block2.solveReferences(previous);
    }

    @Override
    public String toString() {
        return "If: " + cond + " ; " + " { " + block1 + " } " + (elseBranch? "Else { " + block2 + " } ": "");
    }
}
