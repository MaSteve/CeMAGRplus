package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class SwitchNode extends ParserNode {
    private ParserNode exp;
    private CaseNode cases;
    private ParserNode defaultBlock;
    private int declSize = -1;

    public SwitchNode(ParserNode cond, CaseNode cases, ParserNode defaultBlock) {
        this.exp = cond;
        this.cases = cases;
        this.defaultBlock = defaultBlock;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        exp.solveReferences(previous);
        cases.solveReferences(previous);
        defaultBlock.solveReferences(previous);
    }

    public Type getTYPE() {
        Type expType = exp.getTYPE();
        cases.setTYPE(expType);
        Type casesType = cases.getTYPE();
        if (defaultBlock.getTYPE() == Type.OK && expType == casesType && expType != Type.FAIL) TYPE = Type.OK;
        else TYPE = Type.FAIL;
        return TYPE;
    }

    public int getDeclSize() {
        if (declSize == -1) {
            declSize = cases.getDeclSize() + defaultBlock.getDeclSize();
        }
        return declSize;
    }

    @Override
    public String toString() {
        return "Switch: " + exp + " { " + cases + " => " + defaultBlock + " } ";
    }
}
