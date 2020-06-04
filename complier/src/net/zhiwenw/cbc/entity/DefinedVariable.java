package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.ExprNode;
import net.zhiwenw.cbc.ast.TypeNode;

public class DefinedVariable extends Variable {

    public DefinedVariable(boolean priv, TypeNode type,
                           String name, ExprNode init) {
        super(priv, type, name);

    }
}
