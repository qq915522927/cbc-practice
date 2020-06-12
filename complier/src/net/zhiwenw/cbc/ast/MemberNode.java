package net.zhiwenw.cbc.ast;

public class MemberNode extends LHSNode {

    private ExprNode expr;
    private String member;

    public MemberNode(ExprNode expr, String memb) {
        this.expr = expr;
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

    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }

}
