package net.zhiwenw.cbc.ast;

public class CastNode extends ExprNode {

    protected TypeNode typeNode;
    protected ExprNode expr;

    public CastNode(TypeNode t, ExprNode expr) {

        this.typeNode = t;
        this.expr = expr;
    }

    public TypeNode typeNode() {
        return typeNode;
    }

    public ExprNode expr() {
        return expr;
    }

    public Location location() {
        return typeNode.location();
    }

    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
