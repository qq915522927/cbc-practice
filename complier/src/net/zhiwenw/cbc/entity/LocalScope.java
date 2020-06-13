package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.exception.SemanticException;

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

    public boolean isDefinedLocally(String name) {
        return variables.containsKey(name);

    }

    public void defineVariable(DefinedVariable var) {
        if (variables.containsKey(var.name())) {
            throw new Error("duplicated variable: " + var.name());
        }
        variables.put(var.name(), var);
    }

    public void checkReferences() {
        for (DefinedVariable var: variables.values()) {
            if (!var.isRefered()) {
                System.out.println("unused variable: " + var.name());
            }
        }

        for (LocalScope c: childern) {
            c.checkReferences();
        }

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
    public Entity get(String name) throws SemanticException {
        Entity ent = variables.get(name);
        if(ent == null) {
            ent = parent.get(name);
        }
        return ent;
    }
}
