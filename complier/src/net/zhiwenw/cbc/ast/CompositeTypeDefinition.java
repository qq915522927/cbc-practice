package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.TypeRef;

import java.util.List;

public class CompositeTypeDefinition extends TypeDefinition {

    protected List<Slot> members;

    public CompositeTypeDefinition(Location loc, TypeRef ref,
                                   String name, List<Slot> membs) {
        super(loc, ref, name);
        members = membs;
    }

    public List<Slot> members() {
        return members;
    }
}
