package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.entity.DefinedVariable;

import java.util.List;

public class BlockNode extends StmtNode{

    public BlockNode(Location loc,
                     List<DefinedVariable> vars,
                     List<StmtNode> stmts) {
        super(loc);

    }
}
