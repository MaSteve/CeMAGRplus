package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class LoopNode extends ParserNode{
    private ParserNode cond;
    private ParserNode block;

    public LoopNode(ParserNode cond, ParserNode block) {
        this.cond = cond;
        this.block = block;
    }

    @Override
    public String toString() {
        return "While: " + cond + " { " + block + " } ";
    }
}
