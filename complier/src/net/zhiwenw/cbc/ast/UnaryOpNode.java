package net.zhiwenw.cbc.ast;

public class UnaryOpNode extends ExprNode {

    protected String operator;
    protected ExprNode expr;

    public UnaryOpNode(String op, ExprNode term) {
        this.operator = op;
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
