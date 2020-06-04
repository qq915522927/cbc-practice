package net.zhiwenw.cbc.ast;

public class StmtNode {
    protected Location location;

    public StmtNode(Location loc) {
        this.location = loc;
    }

    public Location location() {
        return location;
    }
}
