package cemagr;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class FuncDeclarationNode extends  ParserNode{
    private TypeNode type;
    private String id;
    private ArgumentListNode arg;
    private boolean arguments;
    private ParserNode block;
    private ParserNode returnExp;

    public FuncDeclarationNode(Yytoken token, TypeNode type, ArgumentListNode arg, ParserNode block, ParserNode returnExp) {
        super(token);
        id = token.m_text;
        this.type = type;
        this.arg = arg;
        arguments = true;
        this.block = block;
        this.returnExp = returnExp;
    }

    public FuncDeclarationNode(Yytoken token, TypeNode type, ParserNode block, ParserNode returnExp) {
        super(token);
        id = token.m_text;
        this.type = type;
        arguments = false;
        this.block = block;
        this.returnExp = returnExp;
    }

    @Override
    public String toString() {
        return "Func: " + type + " " + id + " " +  (arguments? arg: "") + " { " + block + " } " + "Return: " + returnExp;
    }
}
