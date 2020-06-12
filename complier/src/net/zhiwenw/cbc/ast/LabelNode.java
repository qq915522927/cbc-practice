package net.zhiwenw.cbc.ast;

public class LabelNode extends StmtNode {

    StmtNode stmt;

    public LabelNode(Location loc, String label, StmtNode stmt){
        super(loc);
        this.stmt = stmt;
    }

    public StmtNode stmt() {
        return stmt;
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
