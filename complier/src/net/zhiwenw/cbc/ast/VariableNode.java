package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.entity.DefinedVariable;
import net.zhiwenw.cbc.entity.Entity;

public class VariableNode extends LHSNode {

    private Location location;
    private String name;
    private Entity entity;

    public VariableNode(Location loc, String name) {
        this.location = loc;
        this.name = name;
    }

    public VariableNode(DefinedVariable var) {
        this.entity = var;
        this.name = var.name();
    }

    public void setEntity(Entity ent) {
        this.entity = ent;
        System.out.println("Resolve: " + ent.name());
    }

    public String name() {
        return name;
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
