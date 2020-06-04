package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.Location;
import net.zhiwenw.cbc.ast.TypeNode;

public class Entity {
    protected String name;
    protected boolean isPrivate;
    protected TypeNode typeNode;
    protected long nRefered;

    public Entity(boolean priv, TypeNode type, String name) {
        this.name = name;
        this.isPrivate = priv;
        this.typeNode = type;
        this.nRefered = 0;
    }
    public Location location() {
        return typeNode.location();
    }

}
