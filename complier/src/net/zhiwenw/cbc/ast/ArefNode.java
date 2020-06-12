package net.zhiwenw.cbc.ast;

public class ArefNode extends LHSNode {

    private ExprNode expr, index;

    public ArefNode(ExprNode primary, ExprNode idx) {
        this.expr = expr;
        this.index = index;
    }

    public ExprNode expr() { return expr; }
    public ExprNode index() { return index; }

    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
