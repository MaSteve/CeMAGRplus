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
public class LoopNode extends ParserNode {
    private ParserNode cond;
    private ParserNode block;
    private int declSize = -1, instSize = -1;

    public LoopNode(ParserNode cond, ParserNode block) {
        this.cond = cond;
        this.block = block;
        controlStructure = true;
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

    public int sizeAndSolve(AddressSolver solver) {
        declSize = block.sizeAndSolve(solver);
        return declSize;
    }

    public int getInstSize() {
        if (instSize == -1) {
            instSize = cond.getInstSize() + block.getInstSize() + 2;
        }
        return instSize;
    }

    public void translate() {
        Application.newComment(" WHILE ");
        cond.translate();
        Application.newInst("fjp " + Application.jump(block.getInstSize() + 1));
        Application.newComment(" DO ");
        block.translate();
        Application.newInst("ujp " + Application.jump(-(block.getInstSize()+cond.getInstSize()+2)));
        Application.newComment(" END WHILE ");
    }

    @Override
    public String toString() {
        return "While: " + cond + " { " + block + " } ";
    }
}
