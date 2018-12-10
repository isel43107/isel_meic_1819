/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmdemos.serialization;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author pauloborges
 */
public class ExampleSerializationToFile {

    public static void main(String[] args) throws IOException {
        
        if (args.length < 2) {
            System.out.println("Must enter filename and buffsizeas arguments.");
            System.exit(0);
        }
        
        int buffSize = Integer.parseInt(args[1]);
        FileOutputStream fos = new FileOutputStream(args[0]);
        BufferedOutputStream bos = new BufferedOutputStream(fos, buffSize);
        DataOutputStream dos = new DataOutputStream(bos);
        for (int i = 0; i < 100; ++i) {
            dos.writeInt(i);
        }
        dos.close();
    }
}
