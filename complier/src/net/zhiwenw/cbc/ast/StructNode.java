package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

import java.util.List;

public class StructNode extends CompositeTypeDefinition {
    public StructNode(Location loc, TypeRef ref, String name, List<Slot> membs) {
        super(loc, ref, name, membs);
    }

    public boolean isStruct() {
        return true;
    }

//    public Type definingType() {
//        return new StructType(name(), members(), location());
//    }
}
