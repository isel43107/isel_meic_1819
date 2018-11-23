/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmdemos.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author pauloborges
 */
public class ClientTCP {

    public static void main(String[] args) throws IOException {
        Socket sockfd = null;
        PrintWriter os = null;
        BufferedReader is = null;
        String host = "localhost";
        int port = 5025; // porto para ligar ao socket servidor
        try {
            sockfd = new Socket(host, port);
// Mostrar os parametros da ligação
            System.out.println("Endereço do Servidor: " + sockfd.getInetAddress()
                    + " Porto: " + sockfd.getPort());
            System.out.println("Endereço Local: " + sockfd.getLocalAddress()
                    + " Porto: " + sockfd.getLocalPort());
            os = new PrintWriter(sockfd.getOutputStream(), true); // para escrita no socket
            is = new BufferedReader(new InputStreamReader(sockfd.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro no estabelecimento da ligação:" + e.getMessage());
            System.exit(1);
        }
        os.println("Olá mundo!!!"); // Escreve no socket
        System.out.println("Recebi -> " + is.readLine()); // Mostrar o Recebido
        os.close();
        is.close();
        sockfd.close(); // No fim de tudo, fechar o socket
    }
}
