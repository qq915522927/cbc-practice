package net.zhiwenw.cbc.ast;


public class DoWhileNode extends StmtNode {

    StmtNode body;
    ExprNode cond;

    public DoWhileNode(Location loc, StmtNode body, ExprNode cond) {
        super(loc);
        this.body = body;
        this.cond = cond;

    }

    public StmtNode body() {
        return body;
    }

    public ExprNode cond() {
        return cond;
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
