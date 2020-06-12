package net.zhiwenw.cbc.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ToplevelScope extends Scope {

    protected Map<String, Entity> entities;
    protected List<DefinedVariable> staticLocalVariables;

    public ToplevelScope() {
        super();
        entities = new LinkedHashMap<String, Entity>();
        staticLocalVariables = null;
    }

    @Override
    public boolean isToplevel() {
        return true;
    }

    @Override
    public ToplevelScope toplevel() {
        return this;
    }

    @Override
    public Scope parent() {
        return null;
    }

    @Override
    public Entity get(String name) {
        return null;
    }
}
