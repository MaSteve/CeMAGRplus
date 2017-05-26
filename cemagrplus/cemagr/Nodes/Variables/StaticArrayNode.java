package cemagr.Nodes.Variables;

import cemagr.Application;
import cemagr.Nodes.Expressions.NumNode;
import cemagr.Nodes.ParserNode;
import cemagr.Utils.Type;

/**
 * Created by marcoantonio on 29/4/17.
 */
public class StaticArrayNode extends ParserNode {
    private NumNode exp;
    private StaticArrayNode next;
    private int len = -1;
    private int declSize = -1;

    public StaticArrayNode(NumNode exp) {
        init(exp, null);
    }
    public StaticArrayNode(NumNode exp, StaticArrayNode node) {
        init(exp, node);
    }

    private void init(NumNode exp, StaticArrayNode node) {
        this.exp = exp;
        next = node;
    }

    public int getDim() {
        if (len == -1) {
            if (next == null) len = 1;
            else len = next.getDim() + 1;
        }
        return len;
    }

    public StaticArrayNode getStaticArrayNode(){
        return next;
    }

    public int getSize(){
        return exp.getValue();
    }

    public int getDeclSize() {
        if (declSize == -1) {
            if (next == null) declSize = exp.getValue();
            else declSize = next.getDeclSize()*exp.getValue();
        }
        return declSize;
    }

    public static boolean check(StaticArrayNode node1, StaticArrayNode node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 != null && node2 != null) {
            return check(node1.next, node2.next) && node1.exp.getValue() == node2.exp.getValue();
        }
        return false;
    }

    public Type getTYPE() {
        Type nextType = Type.OK;
        if (next != null) nextType = next.getTYPE();
        if (nextType == Type.OK) {
            if (exp.getValue() > 0) TYPE = Type.OK;
            else {
                Application.notifyError(Application.ZERO_MSG
                                + " (" + exp.getLine() + ", " + exp.getColumn() + ")");
                        TYPE = Type.FAIL;
            }
        } else TYPE = Type.FAIL;
        return TYPE;
    }

    @Override
    public String toString() {
        return (next == null? "": next) + "[" + exp + "]";
    }
}
