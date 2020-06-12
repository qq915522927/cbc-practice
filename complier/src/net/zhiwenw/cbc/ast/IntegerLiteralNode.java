package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

public class IntegerLiteralNode extends LiteralNode {
    public IntegerLiteralNode(Location loc, TypeRef ref, long value) {
        super(loc, ref);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
