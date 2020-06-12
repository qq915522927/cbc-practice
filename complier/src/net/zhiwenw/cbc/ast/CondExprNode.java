package net.zhiwenw.cbc.ast;

public class CondExprNode extends ExprNode {

    protected ExprNode cond, thenExpr, elseExpr;

    public CondExprNode(ExprNode cond, ExprNode t, ExprNode e) {
        super();
        this.cond = cond;
        this.thenExpr = t;
        this.elseExpr = e;
    }

    public ExprNode cond() {
        return cond;
    }

    public ExprNode thenExpr() {
        return thenExpr;
    }

    public ExprNode elseExpr() {
        return elseExpr;
    }
    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
