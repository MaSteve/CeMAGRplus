package cemagr;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class FuncDeclarationNode extends Declaration{
    private TypeNode type;
    private String id;
    private ArgumentListNode arg;
    private boolean arguments;
    private BlockNode block;
    private ParserNode returnExp;

    public FuncDeclarationNode(Yytoken token, TypeNode type, ArgumentListNode arg, BlockNode block, ParserNode returnExp) {
        super(Declaration.FUNC, token);
        id = token.m_text;
        this.type = type;
        this.arg = arg;
        arguments = true;
        this.block = block;
        this.returnExp = returnExp;
    }

    public FuncDeclarationNode(Yytoken token, TypeNode type, BlockNode block, ParserNode returnExp) {
        super(Declaration.FUNC, token);
        id = token.m_text;
        this.type = type;
        arguments = false;
        this.block = block;
        this.returnExp = returnExp;
    }

    public void solveReferences(HashMap<String, DeclarationNode> previous) {
        HashMap<String, DeclarationNode> variables = new HashMap<>();
        for (Map.Entry<String, DeclarationNode> entry: previous.entrySet()) {
            variables.put(entry.getKey(), entry.getValue());
        }
        //TODO
        block.solveReferences(variables);
    }

    @Override
    public String toString() {
        return "Func: " + type + " " + id + " " +  (arguments? arg: "") + " { " + block + " } " + "Return: " + returnExp;
    }

    @Override
    public String getID() {
        return id;
    }
}
