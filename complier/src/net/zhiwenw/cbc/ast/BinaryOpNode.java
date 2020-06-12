package net.zhiwenw.cbc.ast;

public class BinaryOpNode extends ExprNode {

    protected String operator;
    protected ExprNode left, right;

    public BinaryOpNode(ExprNode l, String op, ExprNode r) {
        super();
        this.operator = op;
        this.left = l;
        this.right = r;
    }

    public ExprNode left() {
        return left;
    }

    public ExprNode right() {
        return right;
    }
    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
