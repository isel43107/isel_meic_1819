/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmdemos.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pauloborges
 */
public class ServerTCP {

    public static void main(String[] args) {
        int port = 5025;
        PrintWriter os = null;
        BufferedReader is = null;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            for (;;) {
                System.out.println("Servidor aguarda ligacao no porto "
                        + port + "...");
                Socket newSock = serverSocket.accept();
// circuito virtual estabalecido: socket cliente <==> newSock
                is = new BufferedReader(new InputStreamReader(newSock.getInputStream()));
                os = new PrintWriter(newSock.getOutputStream(), true);
                String inputLine = is.readLine();
                System.out.println("Recebi -> " + inputLine);
                os.println("Olá para ti também!!");
                os.flush();
                is.close();
                os.close();
                newSock.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro na execução do servidor principal:" + e.getMessage());
        }
    }
}
