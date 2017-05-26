package cemagr.Nodes.ControlStructures;

import cemagr.Application;
import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;
import cemagr.Utils.AddressSolver;
import cemagr.Utils.Type;

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
    private HashMap <Integer, Integer> casesMap;

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
        if (defaultBlock.getTYPE() == Type.OK && expType == casesType && expType == Type.INT) TYPE = Type.OK;
        else {
            TYPE = Type.FAIL;
            if (expType != Type.INT) Application.notifyError(Application.SWITCH_TYPE_MSG);
        }
        return TYPE;
    }

    public int sizeAndSolve(AddressSolver solver) {
        declSize = cases.sizeAndSolve(solver) + defaultBlock.sizeAndSolve(solver);
        return declSize;
    }

    public int getInstSize() {
        if (instSize == -1) {
            instSize = exp.getInstSize() + 13 + cases.getInstSize()
                    + defaultBlock.getInstSize();
            min = cases.getMin();
            max = cases.getMax();
            instSize += max - min + 1;
        }
        return instSize;
    }

    public void translate() {
        // min, max, etc

        casesMap = new HashMap<>();

        Application.newComment(" SWITCH ");

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

        int defAddress = Application.jump(cases.getInstSize() + 4);
        Application.newInst("fjp " + defAddress);

        // Calculated jump

        Application.newInst("ldc " + min);
        Application.newInst("sub");
        Application.newInst("neg");
        int jumpAddress = Application.jump(cases.getInstSize() + defaultBlock.getInstSize() + max - min + 1);
        Application.newInst("ixj " + jumpAddress);

        // Cases

        jumpAddress++;
        cases.setJumpAddress(jumpAddress);
        cases.setCasesMap(casesMap);
        cases.translate();

        // Default

        Application.newComment(" DEFAULT ");

        defaultBlock.translate();
        Application.newInst("ujp " + jumpAddress);

        // Lookup Table

        for (int i = max; i >= min; i--) {
            if (casesMap.containsKey(i)) Application.newInst("ujp " + casesMap.get(i));
            else Application.newInst("ujp " + defAddress);
        }

        Application.newComment(" END SWITCH ");
    }

    @Override
    public String toString() {
        return "Switch: " + exp + " { " + cases + " => " + defaultBlock + " } ";
    }
}
