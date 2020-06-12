package net.zhiwenw.cbc.main;

import net.zhiwenw.cbc.ast.AST;
import net.zhiwenw.cbc.compiler.LocalResolver;
import net.zhiwenw.cbc.entity.DefinedVariable;
import net.zhiwenw.cbc.entity.Entity;
import net.zhiwenw.cbc.parser.ParseException;
import net.zhiwenw.cbc.parser.Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main {
    /** net.zhiwenw.cbc.main.Main entry point. */
    public static void main(String args[]) throws ParseException {
        String filename = args[0];
        File file = new File(args[0]);
        AST ast;
        try {
            FileInputStream stream = new FileInputStream(file);
            Parser parser = new Parser(filename, stream);
            ast = parser.compliation_unit();
            LocalResolver resolver = new LocalResolver();
            resolver.resolve(ast);
        } catch (FileNotFoundException e) {
            System.out.println("Error:");
            e.printStackTrace();;
        }


    }
}
