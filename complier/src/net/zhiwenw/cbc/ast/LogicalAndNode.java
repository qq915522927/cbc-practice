package net.zhiwenw.cbc.ast;

public class LogicalAndNode extends BinaryOpNode {

    public LogicalAndNode(ExprNode l, ExprNode r) {
        super(l, "&&", r);

    }

    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
