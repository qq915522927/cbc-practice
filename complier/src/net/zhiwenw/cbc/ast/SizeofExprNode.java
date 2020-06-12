package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

public class SizeofExprNode extends ExprNode{

    protected ExprNode expr;
    protected TypeNode type;

    public SizeofExprNode(ExprNode expr, TypeRef type){
        this.expr = expr;
        this.type = new TypeNode(type);
    }

    public ExprNode expr() {
        return this.expr;
    }

    public TypeNode typeNode() {
        return this.type;
    }

    public Location location() {
        return expr.location();
    }

    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
