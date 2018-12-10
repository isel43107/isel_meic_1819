/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmdemos.introspect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *
 * @author pauloborges
 */
public class ExIntrospeccao {

    public static void main(String[] args) {
        try {
            Class<?> cl = Class.forName("java.awt.Rectangle");
            Class<?>[] paramTypes = new Class<?>[]{Integer.TYPE, Integer.TYPE};
            Constructor<?> ct = cl.getConstructor(paramTypes);
            Object[] constArgs = new Object[]{new Integer(12), new Integer(21)};
            Object rectang = ct.newInstance(constArgs);
            Method m = cl.getMethod("getWidth", (Class<?>[]) null);
            Object width = m.invoke(rectang, (Object[]) null);
            System.out.println("O objecto é: " + rectang);
            System.out.println("A largura é: " + width);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
