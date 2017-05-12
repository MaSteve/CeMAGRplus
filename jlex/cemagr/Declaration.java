package cemagr;

/**
 * Created by marcoantonio on 12/5/17.
 */
public abstract class Declaration extends ParserNode {
    private int type;
    public static final int FUNC = 0;
    public static final int VAR = 1;
    public static final int ARG = 2;

    protected Declaration(int type) {
        super();
        this.type = type;
        decl = true;
    }
    protected Declaration(int type, Yytoken yytoken) {
        super(yytoken);
        this.type = type;
    }
    public abstract String getID();

    public int getType() {
        return type;
    }
}
