package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.entity.*;

import java.util.*;

public class Declarations {

    Set<DefinedVariable> defvars = new LinkedHashSet<>();
    Set<UndefinedVariable> vardecls = new LinkedHashSet<>();
    Set<DefinedFunction> defuns = new LinkedHashSet<>();
    Set<UndefinedFunction> funcdecls = new LinkedHashSet<>();
    Set<Constant> constants = new LinkedHashSet<>();
    Set<StructNode> defstructs = new LinkedHashSet<>();
    Set<UnionNode> defunions = new LinkedHashSet<>();
    Set<TypedefNode> typedefs = new LinkedHashSet<>();

    public void add(Declarations decls) {
        defvars.addAll(decls.defvars);
        vardecls.addAll(decls.vardecls);
        funcdecls.addAll(decls.funcdecls);
        constants.addAll(decls.constants);
        defstructs.addAll(decls.defstructs);
        defunions.addAll(decls.defunions);
        typedefs.addAll(decls.typedefs);

    }
    public void addDefvar(DefinedVariable var) {
        defvars.add(var);

    }

    public void addDefvars(List<DefinedVariable> vars) {
        defvars.addAll(vars);
    }

    public List<DefinedVariable> defvars() {
        return new ArrayList<>(defvars);
    }

    public void addVardecl(UndefinedVariable var) {
        vardecls.add(var);
    }

    public List<UndefinedVariable> vardecls() {
       return new ArrayList<>(vardecls);
    }

    public void addConstant(Constant c) {
        constants.add(c);
    }

    public List<Constant> constants() {
        return new ArrayList<>(constants);
    }

    public void addDefun(DefinedFunction func) {
        defuns.add(func);
    }

    public List<DefinedFunction> defuns() {
        return new ArrayList<>(defuns);
    }

    public void addFuncdecl(UndefinedFunction func) {
        funcdecls.add(func);
    }

    public List<UndefinedFunction> funcdecls() {
        return new ArrayList<>(funcdecls);
    }

    public void addDefstruct(StructNode n) {
        defstructs.add(n);
    }

    public List<StructNode> defstructs() {
        return new ArrayList<>(defstructs);
    }

    public void addDefunion(UnionNode n) {
        defunions.add(n);
    }

    public List<UnionNode> defunions() {
        return new ArrayList<>(defunions);
    }

    public void addTypedef(TypedefNode n) {
        typedefs.add(n);
    }

    public List<TypedefNode> typedefs() {
        return new ArrayList<>(typedefs);
    }
}
