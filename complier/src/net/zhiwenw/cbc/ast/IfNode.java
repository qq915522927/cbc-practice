package net.zhiwenw.cbc.ast;

public class IfNode extends StmtNode {
    public IfNode(Location loc, ExprNode cond,
                  StmtNode thenBody, StmtNode elseBody) {
        super(loc);

    }
}
