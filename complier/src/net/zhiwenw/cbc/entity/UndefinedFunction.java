package net.zhiwenw.cbc.entity;

import net.zhiwenw.cbc.ast.TypeNode;

public class UndefinedFunction extends Function {
    public UndefinedFunction(TypeNode t, String name, Params params) {
        super(false, t, name);
    }
}
