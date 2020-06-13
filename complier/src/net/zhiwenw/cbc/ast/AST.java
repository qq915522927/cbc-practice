package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.entity.*;

import java.util.ArrayList;
import java.util.List;

public class AST extends Node {

    protected Location source;
    protected Declarations declarations;

    protected ToplevelScope scope;
    protected ConstantTable constantTable;

    public AST(Location source, Declarations declarations) {
        super();
        this.source = source;
        this.declarations = declarations;
    }

    public List<TypeDefinition> types() {
        List<TypeDefinition> result = new ArrayList<>();
        result.addAll(declarations.defstructs());
        result.addAll(declarations.defunions());
        result.addAll(declarations.typedefs());
        return result;
    }

    public List<Entity> entities() {
        List<Entity> result = new ArrayList<>();
        result.addAll(declarations.funcdecls);
        result.addAll(declarations.vardecls);
        result.addAll(declarations.defvars);
        result.addAll(declarations.defuns);
        result.addAll(declarations.constants);

        return result;
    }

    public List<Entity> declarations() {
        List<Entity> result = new ArrayList<Entity>();
        result.addAll(declarations.funcdecls);
        result.addAll(declarations.vardecls);
        return result;
    }

    public List<Entity> definitions() {
        List<Entity> result = new ArrayList<>();
        result.addAll(declarations.defvars);
        result.addAll(declarations.defuns);
        result.addAll(declarations.constants);
        return result;
    }

    public List<Constant> constants() {
        return declarations.constants();
    }

    public List<DefinedVariable> definedVariables() {
        return declarations.defvars();
    }

    public List<DefinedFunction> definedFunctions() {
        return declarations.defuns();
    }

    public void add(Declarations decls) {

    }

    public void setScope(ToplevelScope scope) {
        this.scope = scope;
    }

    public void setConstantTable(ConstantTable constantTable) {
        this.constantTable = constantTable;
    }

    @Override
    public Location location() {
        return source;
    }

}
