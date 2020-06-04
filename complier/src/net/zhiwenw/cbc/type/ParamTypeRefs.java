package net.zhiwenw.cbc.type;


import net.zhiwenw.cbc.ast.Location;
import net.zhiwenw.cbc.entity.ParamSlots;

import java.util.List;

public class ParamTypeRefs extends ParamSlots<TypeRef> {
    public ParamTypeRefs(List<TypeRef> paramDescs) {
        super(paramDescs);
    }
    public ParamTypeRefs(Location loc, List<TypeRef> paramDescs, boolean vararg) {
        super(loc, paramDescs, vararg);
    }
}
