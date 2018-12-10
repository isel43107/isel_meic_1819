/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmdemos.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

/**
 *
 * @author pauloborges
 */
public class Save {

    public static void main(String[] args) {
        Hashtable<String, Object> hash = new Hashtable<String, Object>();
        String hh = "ooo";
        hash.put("string", "Gabriel Garcia Marquez");
        hash.put("int", new Integer(26));
        hash.put("double",new Double(Math.PI));
        hash.put("mmb", "boa Noite");
        hash.put("oo1", hh);
        hash.put("oo2", hh);
        try {
            FileOutputStream fileOut = new FileOutputStream("hash.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(hash);
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
