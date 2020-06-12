package net.zhiwenw.cbc.entity;

import java.util.ArrayList;
import java.util.List;
import net.zhiwenw.cbc.ast.Location;
import net.zhiwenw.cbc.type.ParamTypeRefs;
import net.zhiwenw.cbc.type.TypeRef;


public class Params extends ParamSlots<Parameter> {

    public Params(Location loc, List<Parameter> paramDescs) {
        super(loc, paramDescs, false);

    }

    public List<Parameter> parameters() {
        return paramDescriptors;
    }
    public ParamTypeRefs parametersTypeRef() {
        List<TypeRef> typerefs = new ArrayList<TypeRef>();
        Parameter[] paramDescriptors = new Parameter[2];
//        for (Parameter param : paramDescriptors) {
//            typerefs.add(param.typeNode().typeRef());
//        }
        return new ParamTypeRefs(location, typerefs, vararg);
    }
}
