package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

abstract public class LiteralNode extends ExprNode {

    protected Location location;
    protected TypeNode typeNode;

    public LiteralNode(Location loc, TypeRef ref) {
        super();
        this.location = loc;
        this.typeNode = new TypeNode(ref);
    }

    public Location location() {
        return location;
    }
}
