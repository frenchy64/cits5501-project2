/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ambrosebs.test.util;

import clojure.lang.Symbol;
import clojure.lang.Var;
import mikera.cljutils.Clojure;

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
    
    public Var varFrom(String name) {
        return Var.find(Symbol.intern(name));
    }
    
    public Var utilVar(String name) {
        return varFrom(utilcljNstr+"/"+name);
    }
    
    final Var MAP = Clojure.var("map");
    final Var SET = Clojure.var("set");
    final Var PRINTLN = Clojure.var("println");
    final Var PRN = Clojure.var("prn");
    final Var MAPCAT = Clojure.var("mapcat");
    final Var SPLIT_LINES = varFrom("clojure.string/split-lines");
    final Var SET_DIFFERENCE = varFrom("clojure.set/difference");
    
    final Var ASSERT_ALL_ERRORS_APPEAR = utilVar("assert-all-errors-appear");
    
}
