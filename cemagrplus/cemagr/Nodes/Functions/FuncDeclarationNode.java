package cemagr.Nodes.Functions;

import cemagr.Application;
import cemagr.Nodes.BlockNode;
import cemagr.Nodes.Declaration;
import cemagr.Nodes.ParserNode;
import cemagr.Nodes.TypeNode;
import cemagr.Utils.AddressSolver;
import cemagr.Utils.Type;
import cemagr.parser.Yytoken;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class FuncDeclarationNode extends Declaration {
    private String id;
    private ArgumentListNode arg;
    private boolean arguments;
    private BlockNode block;
    private ParserNode returnExp;

    public FuncDeclarationNode(Yytoken token, TypeNode type, ArgumentListNode arg, BlockNode block) {
        super(Declaration.FUNC, token);
        id = token.m_text;
        this.type = type;
        this.arg = arg;
        arguments = true;
        this.block = block;
    }

    public FuncDeclarationNode(Yytoken token, TypeNode type, BlockNode block) {
        super(Declaration.FUNC, token);
        id = token.m_text;
        this.type = type;
        arguments = false;
        this.block = block;
    }

    public boolean hasArguments() {
        return arguments;
    }

    public ArgumentListNode getArguments() {
        return arg;
    }

    public void solveReferences(HashMap<String, Declaration> previous) {
        HashMap<String, Declaration> variables = new HashMap<>();
        for (Map.Entry<String, Declaration> entry: previous.entrySet()) {
            variables.put(entry.getKey(), entry.getValue());
        }
        if (arguments) {
            arg.solveReferences(variables);
            variables = arg.getVariables();
        }
        block.solveReferences(variables);
        variables = block.getVariables();
        //returnExp.solveReferences(variables);
    }

    public Type getTYPE() {
        if (block.getTYPE() == TYPE.OK) {
            Type ret = type.getTYPE();//returnExp.getTYPE();
            if (ret == type.getTYPE() && ret != Type.FAIL) TYPE = Type.OK;
            else{
                Application.notifyError(Application.RETURN_TYPE_MSG);
                TYPE = Type.FAIL;
            }
        } else  TYPE = Type.FAIL;
        return TYPE;
    }

    public void translate() {
        // Stack (Local variables)
        Application.newComment(" FUNC " + id + " ");
        //Application.newInst("ssp " + (5 + getDeclSize()));
        block.translate();
        returnExp.translate();
        Application.newInst("str 0 0");
        Application.newComment(" RETURN ");
        Application.newInst("retf");
        Application.newComment(" END FUNC ");
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
