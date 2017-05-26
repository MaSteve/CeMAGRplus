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
        controlStructure = true;
    }

    public IfNode(ParserNode cond, ParserNode block1) {
        this.cond = cond;
        this.block1 = block1;
        elseBranch = false;
        controlStructure = true;
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

    public int sizeAndSolve(AddressSolver solver) {
        AddressSolver solver1 = new AddressSolver(solver);
        block1.sizeAndSolve(solver);
        if (elseBranch) block2.sizeAndSolve(solver1);
        solver.max(solver1);
        declSize = solver.getSize();
        return declSize;
    }

    public int getInstSize() {
        if (instSize == -1) {
            instSize = cond.getInstSize() + block1.getInstSize() + 1;
            if (elseBranch) instSize += block2.getInstSize() + 1;
        }
        return instSize;
    }

    public void translate() {
        Application.newComment(" IF ");
        cond.translate();
        Application.newInst("fjp " + Application.jump(block1.getInstSize() + (elseBranch? 1: 0)));
        Application.newComment(" THEN ");
        block1.translate();
        if (elseBranch) {
            Application.newInst("ujp " + Application.jump(block2.getInstSize()));
            Application.newComment(" ELSE ");
            block2.translate();
        }
        Application.newComment(" END IF ");
    }

    @Override
    public String toString() {
        return "If: " + cond + " ; " + " { " + block1 + " } " + (elseBranch? "Else { " + block2 + " } ": "");
    }
}
