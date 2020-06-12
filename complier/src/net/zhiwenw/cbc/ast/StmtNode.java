package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.compiler.Visitor;

abstract public class StmtNode {
    protected Location location;

    public StmtNode(Location loc) {
        this.location = loc;
    }

    public Location location() {
        return location;
    }

    abstract public <S,E> S accept(ASTVisitor<S,E> visitor);

}
