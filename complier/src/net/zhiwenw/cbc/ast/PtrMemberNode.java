package net.zhiwenw.cbc.ast;

public class PtrMemberNode extends LHSNode {

    public ExprNode expr;
    public String member;

    public PtrMemberNode(ExprNode primary, String memb) {
        this.expr = primary;
        this.member = memb;

    }

    public ExprNode expr() {
        return expr;
    }

    public String member() {
        return member;
    }

    public Location location() {
        return expr.location();
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
