package net.zhiwenw.cbc.ast;

public class SuffixOpNode extends UnaryArithmeticOpNode {

    public SuffixOpNode(String op, ExprNode primary) {
        super(op, primary);
    }
}
