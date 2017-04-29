package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class FoopNode extends ParserNode{
    private ParserNode preamble;
    private ParserNode cond;
    private ParserNode postamble;
    private ParserNode block;

    public FoopNode(ParserNode preamble, ParserNode cond, ParserNode postamble, ParserNode block) {
        this.preamble = preamble;
        this.cond = cond;
        this.postamble = postamble;
        this.block = block;
    }

    @Override
    public String toString() {
        return "For: " + preamble + " ; " + cond + " ; " + postamble + " { " + block + " } ";
    }
}
