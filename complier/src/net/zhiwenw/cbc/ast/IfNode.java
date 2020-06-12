package net.zhiwenw.cbc.ast;

public class IfNode extends StmtNode {

    ExprNode cond;
    StmtNode thenBody;
    StmtNode elseBody;

    public IfNode(Location loc, ExprNode cond,
                  StmtNode thenBody, StmtNode elseBody) {
        super(loc);
        this.cond = cond;
        this.thenBody = thenBody;
        this.elseBody = elseBody;
    }

    public ExprNode cond() {
        return cond;
    }
    public StmtNode thenBody() {
        return thenBody;
    }

    public StmtNode elseBody() {
        return elseBody;
    }

    public <S,E> S accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
