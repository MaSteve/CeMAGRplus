package cemagr.Nodes;

import cemagr.Utils.Type;
import cemagr.parser.Yytoken;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class TypeNode extends ParserNode {
    private String value;

    public TypeNode(Yytoken token) {
        super(token);
        value = token.m_text;
    }

    @Override
    public String toString() {
        return value;
    }

    public Type getTYPE() {
        switch (value) {
            case "int": return Type.INT;
            case "bool": return Type.BOOL;
            default: return Type.FAIL;
        }
    }

    public String getDefaultValue() {
        switch (value) {
            case "int": return "0";
            case "bool": return "false";
            default: return "";
        }
    }
}
