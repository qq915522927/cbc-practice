package net.zhiwenw.cbc.ast;

public class DereferenceNode extends LHSNode {

    private ExprNode expr;

    public DereferenceNode(ExprNode term) {
        this.expr = term;
    }

    public ExprNode expr() {
        return expr;
    }

    public Location location() {
        return expr.location();
    }

    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
