package net.zhiwenw.cbc.ast;

import java.util.List;

public class SwitchNode extends StmtNode{

    public SwitchNode(Location loc, ExprNode cond, List<CaseNode> bodies) {
        super(loc);

    }
}
