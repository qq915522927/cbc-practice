package net.zhiwenw.cbc.ast;

public class ForNode extends StmtNode {

    public ForNode(Location loc, ExprNode init, ExprNode cond,
                   ExprNode incr, StmtNode body) {
        super(loc);

    }
}
