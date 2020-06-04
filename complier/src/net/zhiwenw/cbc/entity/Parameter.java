package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.ExprNode;
import net.zhiwenw.cbc.ast.Location;
import net.zhiwenw.cbc.ast.TypeNode;
import net.zhiwenw.cbc.type.TypeRef;

public class Parameter extends DefinedVariable{

    TypeNode type;
    public Parameter(TypeNode type, String name) {
        super(false, type, name, null);
        this.type = type;
    }

    public TypeNode typeNode() {
        return new TypeNode(new TypeRef());
    }

    @Override
    public Location location() {
        return type.location();
    }
}
