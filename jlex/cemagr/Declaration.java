package cemagr;

/**
 * Created by marcoantonio on 12/5/17.
 */
public abstract class Declaration extends ParserNode {
    private int typeClass;
    public static final int FUNC = 0;
    public static final int VAR = 1;
    public static final int ARG = 2;

    protected Declaration(int type) {
        super();
        this.typeClass = type;
        decl = true;
        TYPE = Type.OK;
    }
    protected Declaration(int type, Yytoken yytoken) {
        super(yytoken);
        this.typeClass = type;
        decl = true;
        TYPE = Type.OK;
    }
    public abstract String getID();

    public int getClassType() {
        return typeClass;
    }
}
