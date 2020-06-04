package net.zhiwenw.cbc.ast;

public class PrefixOpNode extends UnaryArithmeticOpNode {
    public PrefixOpNode(String op, ExprNode n) {
        super(op, n);
    }
}
