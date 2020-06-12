package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.ExprNode;
import net.zhiwenw.cbc.ast.TypeNode;

public class Constant extends Entity {

    private ExprNode value;

    public Constant(TypeNode type, String name, ExprNode value) {
        super(true, type, name);
        this.value = value;
    }

    public boolean isAssignable() { return false;}
    public boolean isDefined() {return true;}
    public boolean isInitialized() {return true;}
    public boolean isConstant() { return true; }

    public ExprNode value() {
        return value;
    }

    public <T> T accept(EntityVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
