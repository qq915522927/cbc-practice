package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

public class TypedefNode extends TypeDefinition {

    public TypedefNode(Location loc, TypeRef ref, String name) {
        super(loc, ref, name);
    }
}
