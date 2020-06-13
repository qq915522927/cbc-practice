package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.entity.DefinedVariable;
import net.zhiwenw.cbc.entity.LocalScope;

import java.util.List;

public class BlockNode extends StmtNode{

    protected List<DefinedVariable> variables;
    protected List<StmtNode> stmts;

    protected LocalScope scope;

    public BlockNode(Location loc,
                     List<DefinedVariable> vars,
                     List<StmtNode> stmts) {
        super(loc);
        this.variables = vars;
        this.stmts = stmts;
    }

    public List<DefinedVariable> variables() {
        return variables;
    }

    public void setScope(LocalScope scope) {
        this.scope = scope;
    }

    public List<StmtNode> stmts() {
        return stmts;
    }

    public <S,E> S accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
