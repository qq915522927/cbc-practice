package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

public class TypeDefinition extends Node {
    public Location location;
    public TypeDefinition(Location loc, TypeRef ref, String name) {
        this.location = loc;

    }
    public Location location() {
        return this.location;

    }
}
