package net.zhiwenw.cbc.ast;

import net.zhiwenw.cbc.type.*;

import java.util.*;
import java.io.*;

public class Dumper {
    protected int nIndent;
    protected PrintStream stream;

    public Dumper(PrintStream s) {
        this.stream = s;
        this.nIndent = 0;
    }

}
