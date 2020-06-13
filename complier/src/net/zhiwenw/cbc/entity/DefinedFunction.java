package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.BlockNode;
import net.zhiwenw.cbc.ast.TypeNode;

import java.util.List;

public class DefinedFunction extends Function {

    protected Params params;
    protected BlockNode body;

    protected LocalScope scope;

    public DefinedFunction(boolean priv, TypeNode type,
                           String name, Params params, BlockNode body) {
        super(priv, type, name);

        this.params = params;
        this.body = body;
    }

    public boolean isDefined() {
        return true;
    }

    public void setScope(LocalScope scope) {
        this.scope = scope;
    }

    public List<Parameter> parameters() {
        return this.params.parameters();
    }

    public BlockNode body() {
        return body;
    }

    public <T> T accept(EntityVisitor<T> visitor) {
        return visitor.visit(this);
    }

//    public List<DefinedVariable> localVariables() {
//
//    }
}
