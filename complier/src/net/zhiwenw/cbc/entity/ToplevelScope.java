package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.exception.SemanticException;

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

    public void declareEntity(Entity entity) throws SemanticException {
        Entity e = entities.get(entity.name());
        if (e != null) {
            throw new SemanticException("duplicated declaration: " +
                    entity.name() + ": " + e.location() + " and " + entity.location());
        }
        entities.put(entity.name(), entity);
    }

    public void defineEntity(Entity entity) throws SemanticException {
        Entity e = entities.get(entity.name());
        if (e != null && e.isDefined()) {
            throw new SemanticException("duplicated definition: " +
                    entity.name() + ": " +
                    e.location() + " and " + entity.location());
        }
        entities.put(entity.name(), entity);
    }

//    top scope
//            funcscope  (parameters)
//                bodyscope (func body)
//                    block scope (block stmt)
    public void checkReferences() {
        for (Entity ent: entities.values()) {
            if (ent.isDefined()
                    && ent.isPrivate()
                    && !ent.isConstant()
                    && !ent.isRefered()
            ) {
                // TODO
                System.out.println("unused variable");
            }
        }

        for (LocalScope funcScope: childern) {
            for (LocalScope s: funcScope.childern) {
                s.checkReferences();
            }
        }

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
    public Entity get(String name) throws SemanticException {
        Entity ent = entities.get(name);
        if(ent == null) {
            throw new SemanticException("nresolved reference: " + name);
        }
        return ent;
    }
}
