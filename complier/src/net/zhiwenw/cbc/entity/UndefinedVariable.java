package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.TypeNode;

public class UndefinedVariable extends Variable {
    public UndefinedVariable(TypeNode t, String n) {
        super(false, t, n);
    }

    public boolean isDefined() {return  false;}
    public boolean isPrivate() {return false;}
    public boolean isInitialized() {return false;}


    public <T> T accept(EntityVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
