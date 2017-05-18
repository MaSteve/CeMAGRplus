package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class CaseNode extends ParserNode {
    private ParserNode cond;
    private ParserNode block;
    private CaseNode next;
    private int declSize = -1;

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
        controlStructure = true;
    }

    public void setNext(CaseNode node) {
        next = node;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        cond.solveReferences(previous);
        block.solveReferences(previous);
        if (next != null) next.solveReferences(previous);
    }

    public Type getTYPE() { //TODO: Refactor
        Type casesType = Type.OK;
        if (next != null) {
            next.setTYPE(TYPE);
            casesType = next.getTYPE();
        }
        Type expType = cond.getTYPE();
        if (casesType == Type.OK) casesType = expType;
        Type blockType = block.getTYPE();
        if (expType != TYPE && TYPE != Type.FAIL) {
            Application.notifyError(Application.TYPE_MSG + ": " + Application.TYPE_EXP_MSG + TYPE
                    + " (" + getLine() + ", " + getColumn() + ")");
        }
        if (blockType == Type.OK && expType == casesType && expType != Type.FAIL) TYPE = casesType;
        else TYPE = Type.FAIL;
        return TYPE;
    }

    public int sizeAndSolve(AddressSolver solver) {
        declSize = 0;
        if (next != null) next.sizeAndSolve(solver);
        AddressSolver solver1 = new AddressSolver(solver);
        block.sizeAndSolve(solver1);
        solver.max(solver1);
        declSize = solver.getSize();
        return declSize;
    }

    @Override
    public String toString() {
        return (next == null? "": next + "") + cond + " => " + block + "\n";
    }
}
