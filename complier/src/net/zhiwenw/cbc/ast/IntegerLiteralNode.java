package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

public class IntegerLiteralNode extends LiteralNode {
    public IntegerLiteralNode(Location loc, TypeRef ref, long value) {
        super(loc, ref);
    }
}
