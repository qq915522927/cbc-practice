package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

public class StringLiteralNode extends LiteralNode {
    public StringLiteralNode(Location loc, TypeRef ref, String value) {
        super(loc, ref);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
