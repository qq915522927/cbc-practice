package net.zhiwenw.cbc.ast;

public class ReturnNode extends StmtNode {

    protected ExprNode expr;

    public ReturnNode(Location loc, ExprNode expr) {
        super(loc);
        this.expr = expr;
    }

    public ExprNode expr() {
        return expr;
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
