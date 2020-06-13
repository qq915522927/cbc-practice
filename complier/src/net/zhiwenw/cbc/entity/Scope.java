package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.exception.SemanticException;

import java.util.ArrayList;
import java.util.List;

abstract public class Scope {

    protected List<LocalScope> childern;

    public Scope() {
        childern = new ArrayList<LocalScope>();
    }

    abstract public boolean isToplevel();
    abstract public ToplevelScope toplevel();
    abstract public Scope parent();

    protected void addChild(LocalScope s) {
        childern.add(s);
    }
    abstract public Entity get(String name) throws SemanticException;
}
