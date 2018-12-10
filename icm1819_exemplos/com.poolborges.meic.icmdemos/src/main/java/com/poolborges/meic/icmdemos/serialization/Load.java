/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmdemos.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;

/**
 *
 * @author pauloborges
 */
public class Load {

    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("hash.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
// If in case of downcastingerror an exception is thrown
            @SuppressWarnings("unchecked")
            Hashtable<String, Object> hash = (Hashtable<String, Object>) in.readObject();
            in.close(); //Closethestream
            System.out.println(hash.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
