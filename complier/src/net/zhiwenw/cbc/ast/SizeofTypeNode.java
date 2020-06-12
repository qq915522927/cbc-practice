package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

public class SizeofTypeNode extends ExprNode {

    public SizeofTypeNode(TypeNode operand, TypeRef type) {

    }
    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
