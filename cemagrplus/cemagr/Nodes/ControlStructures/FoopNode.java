package cemagr.Nodes.ControlStructures;

import cemagr.Application;
import cemagr.Nodes.BlockNode;
import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;
import cemagr.Utils.AddressSolver;
import cemagr.Utils.Type;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class FoopNode extends ParserNode {
    private ParserNode preamble;
    private ParserNode cond;
    private ParserNode postamble;
    private ParserNode block;
    private int declSize = -1, instSize = -1;

    public FoopNode(ParserNode preamble, ParserNode cond, ParserNode postamble, ParserNode block) {
        this.preamble = preamble;
        this.cond = cond;
        this.postamble = postamble;
        this.block = block;
        controlStructure = true;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        preamble.solveReferences(previous);
        HashMap<String, Declaration> vars = ((BlockNode) preamble).getVariables();
        cond.solveReferences(vars);
        postamble.solveReferences(vars);
        block.solveReferences(vars);
    }

    public Type getTYPE() {
        Type preambleType = preamble.getTYPE();
        Type condType = cond.getTYPE();
        Type postambleType = postamble.getTYPE();
        Type blockType = block.getTYPE();
        if (condType == Type.BOOL && preambleType == postambleType
                && postambleType == blockType && blockType == Type.OK) TYPE = Type.OK;
        else TYPE = Type.FAIL;
        return TYPE;
    }

    public void translate() {
        Application.newComment(" FOR ");
        preamble.translate();
        cond.translate();
        //Application.newInst("fjp " + Application.jump(block.getInstSize() + postamble.getInstSize() + 1));
        Application.newComment(" DO ");
        block.translate();
        postamble.translate();
        //Application.newInst("ujp " + Application.jump(-(block.getInstSize()+postamble.getInstSize()+cond.getInstSize()+2)));
        Application.newComment(" END FOR ");
    }

    @Override
    public String toString() {
        return "For: " + preamble + " ; " + cond + " ; " + postamble + " { " + block + " } ";
    }
}
