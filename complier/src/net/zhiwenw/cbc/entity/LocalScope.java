package net.zhiwenw.cbc.entity;

import java.util.*;

public class LocalScope extends Scope {

    protected Scope parent;
    protected Map<String, DefinedVariable> variables;

    public LocalScope(Scope parent) {
        super();
        this.parent = parent;
        parent.addChild(this);
        variables = new LinkedHashMap<String, DefinedVariable>();
    }

    @Override
    public boolean isToplevel() {
        return false;
    }

    @Override
    public ToplevelScope toplevel() {
        return null;
    }

    @Override
    public Scope parent() {
        return this.parent;
    }

    @Override
    public Entity get(String name) {
        return null;
    }
}
