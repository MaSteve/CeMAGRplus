package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class CaseNode extends ParserNode {
    private ParserNode cond;
    private ParserNode block;
    private CaseNode next;

    public CaseNode(ParserNode cond, ParserNode block) {
        init(cond, block, null);
    }
    public CaseNode(ParserNode cond, ParserNode block, CaseNode node) {
        init(cond, block, node);
    }

    private void init(ParserNode cond, ParserNode block, CaseNode node) {
        this.cond = cond;
        this.block = block;
        next = node;
    }

    public void setNext(CaseNode node) {
        next = node;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        cond.solveReferences(previous);
        block.solveReferences(previous);
        if (next != null) next.solveReferences(previous);
    }

    @Override
    public String toString() {
        return (next == null? "": next + "") + cond + " => " + block + "\n";
    }
}
