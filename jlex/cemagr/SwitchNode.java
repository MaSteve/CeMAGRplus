package cemagr;

import java.util.HashMap;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class SwitchNode extends ParserNode {
    private ParserNode exp;
    private CaseNode cases;
    private ParserNode defaultBlock;

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

    @Override
    public String toString() {
        return "Switch: " + exp + " { " + cases + " => " + defaultBlock + " } ";
    }
}
