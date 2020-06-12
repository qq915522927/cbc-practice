package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.compiler.Visitor;

abstract public class ExprNode extends Node {
    @Override
    public Location location() {
        return null;
    }
    public void accept(Visitor visitor) {

    }

    abstract public <S,E> E accept(ASTVisitor<S,E> visitor);
}
