package net.zhiwenw.cbc.compiler;

import net.zhiwenw.cbc.ast.*;
import net.zhiwenw.cbc.entity.*;
import net.zhiwenw.cbc.exception.SemanticException;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LocalResolver extends Visitor {

    private final LinkedList<Scope> scopeStack;
    private final ConstantTable constantTable;

    public LocalResolver() {
        this.scopeStack = new LinkedList<Scope>();
        this.constantTable = new ConstantTable();
    }

    public void resolve(AST ast) throws SemanticException {
        ToplevelScope toplevel = new ToplevelScope();
        scopeStack.add(toplevel);

        for (Entity decl: ast.declarations()) {
            toplevel.declareEntity(decl);
        }

        for (Entity def: ast.definitions()) {
            toplevel.defineEntity(def);
        }

        resolveGvarInitializers(ast.definedVariables());
        resolveConstantValues(ast.constants());
        resolveFunctions(ast.definedFunctions());

        toplevel.checkReferences();

        ast.setScope(toplevel);
        ast.setConstantTable(constantTable);
    }

    private void resolve(StmtNode n) {
        n.accept(this);
    }

    public void resolve(ExprNode expr) {
        expr.accept(this);
    }

    // #@@range/resolveGvarInitializers{
    private void resolveGvarInitializers(List<DefinedVariable> gvars) {
        for (DefinedVariable gvar : gvars) {
            if (gvar.hasInitializer()) {
                resolve(gvar.initializer());
            }
        }
    }

    private void resolveConstantValues(List<Constant> consts) {
        for (Constant c : consts) {
            resolve(c.value());
        }
    }

    private void resolveFunctions(List<DefinedFunction> funcs) {
        for (DefinedFunction func : funcs) {
            pushScope(func.parameters());
            resolve(func.body());
            func.setScope(popScope());
        }
    }

    private void pushScope(List<? extends DefinedVariable> vars) {
        LocalScope scope = new LocalScope(currentScope());
        for (DefinedVariable var: vars) {
            if (scope.isDefinedLocally(var.name())) {
//                TODO
                System.out.println("Error: duplicate defined");

            } else {
                scope.defineVariable(var);
            }
        }
        scopeStack.addLast(scope);
    }

    private Scope currentScope() {
        return scopeStack.getLast();
    }

    private LocalScope popScope() {
        return (LocalScope) scopeStack.removeLast();
    }

    public Void visit(BlockNode node) {
        pushScope(node.variables());
        super.visit(node);

        node.setScope(popScope());

        return null;

    }

    public Void visit(VariableNode node) {
        try {
            Entity ent = currentScope().get(node.name());
            ent.refered();
            node.setEntity(ent);
        }
        catch (SemanticException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }


    // looks the Constanttable is only for string

    public Void visit(StringLiteralNode node) {
        System.out.println("visit string node: " + node.value());
        node.setEntry(constantTable.intern(node.value()));
        return null;
    }

}
