package net.zhiwenw.cbc.compiler;

import net.zhiwenw.cbc.ast.*;
import net.zhiwenw.cbc.entity.DefinedVariable;

import java.util.List;

abstract public class Visitor implements ASTVisitor<Void, Void> {
    public Visitor() {
    }

    protected void visitStmt(StmtNode stmt) {
        stmt.accept(this);
    }
    protected void visitStmts(List<? extends StmtNode> stmts) {
        for (StmtNode s: stmts) {
            visitStmt(s);
        }
    }
    protected void visitExpr(ExprNode expr) {
        expr.accept(this);
    }
    protected void visitExprs(List<? extends ExprNode> exprs) {
        for(ExprNode e: exprs) {
            visitExpr(e);
        }
    }

    // statement

    public Void visit(BlockNode node) {
        System.out.println("visit: " + node.getClass().getName());
        for(DefinedVariable var: node.variables()) {
            if(var.hasInitializer()) {
                visitExpr(var.initializer());
            }
        }
        visitStmts(node.stmts());
        return null;
    }

    public Void visit(ExprStmtNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }

    public Void visit(IfNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitExpr(n.cond());
        visitStmt(n.thenBody());
        if(n.elseBody() != null) {
            visitStmt(n.elseBody());
        }
        return null;
    }

    public Void visit(SwitchNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitExpr(n.cond());
        visitStmts(n.cases());
        return null;
    }

    public Void visit(CaseNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitExprs(n.values());
        visitStmt(n.body());
        return null;
    }

    public Void visit(WhileNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitExpr(n.cond());
        visitStmt(n.body());
        return null;

    }

    public Void visit(DoWhileNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitStmt(n.body());
        visitExpr(n.cond());
        return null;
    }

    public Void visit(ForNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitStmt(n.init());
        visitExpr(n.cond());
        visitStmt(n.incr());
        visitStmt(n.body());
        return null;
    }

    public Void visit(BreakNode n) {
        return null;
    }

    public Void visit(ContinueNode n) {
        return null;
    }

    public Void visit(GotoNode n) {
        return null;
    }

    public Void visit(LabelNode n) {
        visitStmt(n.stmt());
        return null;
    }

    public Void visit(ReturnNode n) {
        System.out.println("visit: " + n.getClass().getName());
        if (n.expr() != null) {
            visitExpr(n.expr());
        }
        return null;
    }

    // Expressions

    public Void visit(CondExprNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitExpr(n.cond());
        visitExpr(n.thenExpr());
        if (n.elseExpr() != null) {
            visitExpr(n.elseExpr());
        }
        return null;
    }

    public Void visit(LogicalOrNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.left());
        visitExpr(node.right());
        return null;
    }

    public Void visit(LogicalAndNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.left());
        visitExpr(node.right());
        return null;
    }

    public Void visit(AssignNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitExpr(n.lhs());
        visitExpr(n.rhs());
        return null;
    }

    public Void visit(OpAssignNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitExpr(n.lhs());
        visitExpr(n.rhs());
        return null;
    }
    public Void visit(BinaryOpNode n) {
        System.out.println("visit: " + n.getClass().getName());
        visitExpr(n.left());
        visitExpr(n.right());
        return null;
    }

    public Void visit(UnaryOpNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }

    public Void visit(PrefixOpNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }
    public Void visit(SuffixOpNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }
    public Void visit(FuncallNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        visitExprs(node.args());
        return null;
    }

    public Void visit(ArefNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        visitExpr(node.index());
        return null;
    }

    public Void visit(MemberNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }

    public Void visit(PtrMemberNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }

    public Void visit(DereferenceNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }

    public Void visit(AddressNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }

    public Void visit(CastNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }

    public Void visit(SizeofExprNode node) {
        System.out.println("visit: " + node.getClass().getName());
        visitExpr(node.expr());
        return null;
    }

    public Void visit(SizeofTypeNode node) {
        System.out.println("visit: " + node.getClass().getName());
        return null;
    }

    public Void visit(VariableNode node) {
        System.out.println("visit: " + node.getClass().getName());
        return null;
    }

    public Void visit(IntegerLiteralNode node) {
        System.out.println("visit: " + node.getClass().getName());
        return null;
    }

    public Void visit(StringLiteralNode node) {
        System.out.println("visit: " + node.getClass().getName());
        return null;
    }

}
