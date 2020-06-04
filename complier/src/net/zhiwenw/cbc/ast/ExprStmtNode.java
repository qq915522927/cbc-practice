package net.zhiwenw.cbc.ast;

public class ExprStmtNode extends StmtNode {
    protected ExprNode expr;

    public ExprStmtNode(Location loc, ExprNode expr) {
        super(loc);
        this.expr = expr;
    }
}
