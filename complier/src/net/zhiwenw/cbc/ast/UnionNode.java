package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

import java.util.List;

public class UnionNode extends  CompositeTypeDefinition{

    public UnionNode(Location loc, TypeRef ref, String name, List<Slot> membs) {
        super(loc, ref, name, membs);
    }

    public boolean isUnion() { return  true; }
}
