package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.TypeNode;

abstract public class Function extends Entity {
    public Function(boolean priv, TypeNode type, String name) {
        super(priv, type, name);
    }
}
