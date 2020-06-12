package net.zhiwenw.cbc.ast;

import java.awt.*;
import java.util.List;

public class CaseNode extends StmtNode {

    protected Label label;
    protected List<ExprNode> values;
    protected BlockNode body;

    public CaseNode(Location loc, List<ExprNode> values,
                    BlockNode body) {
        super(loc);
        this.values = values;
        this.body = body;
        this.label = new Label();
    }

    public List<ExprNode> values() {
        return values;
    }

    public BlockNode body() {
        return body;
    }

    public Label label() {
        return label;
    }

    public <S,E> S accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
