package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.Location;
import net.zhiwenw.cbc.ast.TypeNode;

abstract public class Entity {
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

    public String name() {
        return name;
    }
    public Location location() {
        return typeNode.location();
    }

    abstract boolean isDefined();
    public boolean isPrivate() {
        return isPrivate;
    }
    boolean isConstant() {return false;}

    public void refered() {
        nRefered++;
    }
    public boolean isRefered() {
        return (nRefered > 0);
    }

    abstract public <T> T accept(EntityVisitor<T> visitor);
}
