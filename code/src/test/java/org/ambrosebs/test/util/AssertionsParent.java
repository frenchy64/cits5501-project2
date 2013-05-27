/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test.util;

import clojure.lang.Symbol;
import clojure.lang.Var;
import mikera.cljutils.Clojure;
import clojure.lang.Util;

/**
 *
 * @author ambrose
 */
public class AssertionsParent {
    
    final static String utilcljNstr = "org.ambrosebs.clj-util";
    
    // START CLOJURE BOILERPLATE
    static {
        Clojure.require("clojure.core");
        Clojure.require(utilcljNstr);
    }
    
    public AssertionsParent() {
        
    }
    
    public Var varFrom(String name) {
        Var v = Var.find(Symbol.intern(name));
        if (v == null)
            throw Util.sneakyThrow(new Exception("Var "+name+" is nil"));
        return v;
    }
    
    public Var utilVar(String name) {
        return varFrom(utilcljNstr+"/"+name);
    }
    
    public Var coreVar(String name) {
        return varFrom("clojure.core/"+name);
    }
    
    final Var ASSERT_ALL_ERRORS_APPEAR = utilVar("assert-all-errors-appear");
    final Var ASSERT_FORBIDDEN_ERRORS = utilVar("assert-forbidden-errors");
    
}
