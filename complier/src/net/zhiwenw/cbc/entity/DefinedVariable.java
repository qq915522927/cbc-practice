package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.ExprNode;
import net.zhiwenw.cbc.ast.TypeNode;

public class DefinedVariable extends Variable {

    protected ExprNode initializer;

    public DefinedVariable(boolean priv, TypeNode type,
                           String name, ExprNode init) {
        super(priv, type, name);
        initializer = init;
    }

    public boolean isDefined() {
        return true;
    }

    public boolean hasInitializer() {
        return (initializer != null);
    }

    public boolean isInitialized() {
        return hasInitializer();
    }

    public ExprNode initializer() {
       return initializer;
    }

    public void setInitializer(ExprNode expr) {
        this.initializer = expr;
    }

    public <T> T accept(EntityVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
