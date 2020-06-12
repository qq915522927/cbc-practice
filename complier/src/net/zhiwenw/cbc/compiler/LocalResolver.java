package net.zhiwenw.cbc.compiler;

import net.zhiwenw.cbc.ast.AST;
import net.zhiwenw.cbc.ast.ExprNode;
import net.zhiwenw.cbc.ast.StmtNode;
import net.zhiwenw.cbc.entity.*;

import java.util.LinkedList;
import java.util.List;

public class LocalResolver extends Visitor {

    private final LinkedList<Scope> scopeStack;
    private final ConstantTable constantTable;

    public LocalResolver() {
        this.scopeStack = new LinkedList<Scope>();
        this.constantTable = new ConstantTable();
    }

    public void resolve(AST ast) {
//        ToplevelScope toplevel = new ToplevelScope();
//        scopeStack.add(toplevel);
        resolveGvarInitializers(ast.definedVariables());
        resolveConstantValues(ast.constants());
        resolveFunctions(ast.definedFunctions());
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
            resolve(func.body());
        }
    }

}
