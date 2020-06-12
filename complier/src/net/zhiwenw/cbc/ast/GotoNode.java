package net.zhiwenw.cbc.ast;

public class GotoNode extends StmtNode {

    public GotoNode(Location loc, String label) {
        super(loc);

    }
    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
