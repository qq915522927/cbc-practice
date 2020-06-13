package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.entity.ConstantEntry;
import net.zhiwenw.cbc.type.TypeRef;

public class StringLiteralNode extends LiteralNode {

    protected String value;
    protected ConstantEntry entry;

    public StringLiteralNode(Location loc, TypeRef ref, String value) {
        super(loc, ref);

        this.value = value;
    }

    public void setEntry(ConstantEntry ent) {
        entry = ent;
    }

    public String value() {
        return value;
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
