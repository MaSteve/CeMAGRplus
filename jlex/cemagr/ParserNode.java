package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public abstract class ParserNode {
    protected Yytoken token;

    public ParserNode() {
        token = null;
    }

    public ParserNode(Yytoken token) {
        this.token = token;
    }

    @Override
    public abstract String toString();
}
