package net.zhiwenw.cbc.ast;

public class VariableNode extends LHSNode {
    public VariableNode(Location loc, String name) {}

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
