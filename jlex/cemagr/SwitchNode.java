package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class SwitchNode extends ParserNode {
    private ParserNode exp;
    private CaseNode cases;
    private ParserNode defaultBlock;
    private int declSize = -1, instSize = -1;
    private int min, max;

    public SwitchNode(ParserNode cond, CaseNode cases, ParserNode defaultBlock) {
        this.exp = cond;
        this.cases = cases;
        this.defaultBlock = defaultBlock;
        controlStructure = true;
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

    public int sizeAndSolve(AddressSolver solver) {
        declSize = cases.sizeAndSolve(solver) + defaultBlock.sizeAndSolve(solver);
        return declSize;
    }

    public int getInstSize() {
        if (instSize == -1) {
            instSize = exp.getInstSize() + 12 + cases.getInstSize()
                    + defaultBlock.getInstSize() + max - min + 1; //TODO
        }
        return 0;
    }

    public void translate() { //TODO
        // min, max, etc

        min = cases.getMin();
        max = cases.getMax();

        // Exp
        exp.translate();
        // Default check
        Application.newInst("dpl");
        Application.newInst("ldc " + min);
        Application.newInst("geq");

        Application.newInst("fjp " + Application.jump(cases.getInstSize() + 8));

        Application.newInst("dpl");
        Application.newInst("ldc " + max);
        Application.newInst("leq");

        Application.newInst("fjp " + Application.jump(cases.getInstSize() + 4));

        // Calculated jump

        Application.newInst("ldc " + min);
        Application.newInst("sub");
        Application.newInst("neg");
        Application.newInst("ixj " + Application.jump(cases.getInstSize() + defaultBlock.getInstSize() + max - min));

        // Cases

        cases.translate();

        // Default

        defaultBlock.translate();

        // Lookup Table

        for (int i = max; i >= min; i--) {
            Application.newInst("ujp " + "dir " + i);
        }
    }

    @Override
    public String toString() {
        return "Switch: " + exp + " { " + cases + " => " + defaultBlock + " } ";
    }
}
