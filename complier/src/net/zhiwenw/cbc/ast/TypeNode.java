package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

public class TypeNode {
    TypeRef typeRef;

    public TypeNode(TypeRef ref) {
        super();
        this.typeRef = ref;
    }

    public TypeRef typeRef() {
        return new TypeRef();
    }
    public Location location() {
        return new Location();
    }
}
