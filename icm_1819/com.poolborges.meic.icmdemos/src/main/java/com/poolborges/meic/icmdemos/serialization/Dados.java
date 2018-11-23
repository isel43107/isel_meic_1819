/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmdemos.serialization;

/**
 *
 * @author pauloborges
 */
public class Dados implements java.io.Serializable {
// serialVersionUIDiniquelyidentifiesthisclass

    private static final long serialVersionUID = 2085820693538484112L;
    public String s1;
    private String s2;
    private int i;
    transient private double X; // NOTE: X is not serialized!!

    public Dados(int i, String s1, String s2) {
        this.i = i;
        this.s1 = s1;
        this.s2 = s2;
        X = Math.random(); // transientvalueexample
    }

    public String toString() {
        return "[" + i + "," + s1 + "," + s2 + ", X=" + X + "]";
    }
//... Othermethods
} //serialver‐show
