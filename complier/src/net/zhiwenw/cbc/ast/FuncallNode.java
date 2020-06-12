package net.zhiwenw.cbc.ast;

import java.util.List;

public class FuncallNode extends ExprNode {

    protected ExprNode expr;
    protected List<ExprNode> args;

    public FuncallNode(ExprNode primary, List<ExprNode> args ) {

        this.expr = primary;
        this.args = args;
    }
    public ExprNode expr() {
        return expr;
    }

    public List<ExprNode> args() {
        return args;
    }

    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
