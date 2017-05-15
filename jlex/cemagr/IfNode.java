package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class IfNode extends ParserNode {
    private ParserNode cond;
    private ParserNode block1;
    private ParserNode block2;
    private boolean elseBranch;
    private int declSize = -1, instSize = -1;

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

    public void solveReferences(HashMap<String, Declaration> previous) {
        cond.solveReferences(previous);
        block1.solveReferences(previous);
        if (elseBranch) block2.solveReferences(previous);
    }

    public Type getTYPE() {
        Type condType = cond.getTYPE();
        Type block2Type = Type.OK;
        if (elseBranch) block2Type = block2.getTYPE();
        if (condType == Type.BOOL && block1.getTYPE() == block2Type && block2Type == Type.OK) TYPE = Type.OK;
        else TYPE = Type.FAIL;
        return TYPE;
    }

    public int getDeclSize() {
        if (declSize == -1) {
            declSize = block1.getDeclSize() + (elseBranch? block2.getDeclSize(): 0);
        }
        return declSize;
    }

    public int getInstSize() {
        if (instSize == -1) {
            instSize = cond.getInstSize() + block1.getInstSize() + 1;
            if (elseBranch) instSize += block2.getInstSize() + 1;
        }
        return instSize;
    }

    @Override
    public String toString() {
        return "If: " + cond + " ; " + " { " + block1 + " } " + (elseBranch? "Else { " + block2 + " } ": "");
    }
}
