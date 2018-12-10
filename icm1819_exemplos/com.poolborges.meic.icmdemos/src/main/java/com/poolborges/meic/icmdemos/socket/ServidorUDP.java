package com.poolborges.meic.icmdemos.socket;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pauloborges
 */
public class ServidorUDP {

    public static void main(String args[]) {
        DatagramSocket sockfd = null;
        DatagramPacket epacket, rpacket;
        int dim_buffer = 100;
        byte ibuffer[] = new byte[dim_buffer];
        String received = null;
        
         // Cria socket UDP
        try {
            sockfd = new DatagramSocket(5026);
        } catch (SocketException e) {
            e.printStackTrace();
            System.err.println("Erro na execução do servidor (porto):" + e.getMessage());
        }
        rpacket = new DatagramPacket(ibuffer,dim_buffer);
        for (;;) {
            try {
                System.out.println("Servidor aguarda recepção de mensagem no porto 5026");
                rpacket.setLength(dim_buffer);
                sockfd.receive(rpacket);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Erro na recepção da mensagem: " + e.getMessage());
            }
            received = new String(rpacket.getData(), 0, rpacket.getLength());


// Criar um datagrama para enviar a resposta
            epacket = new DatagramPacket( received.getBytes(), received.length(), rpacket.getAddress(), rpacket.getPort());
            
            
            System.out.println("Endereço do cliente:"
                    + epacket.getAddress() + " Porto: "
                    + epacket.getPort());
            System.out.println("Dados recebidos: "
                    + received);
            System.out.println("Número de bytes "
                    + "recebidos: " + rpacket.getLength());
            try {
                sockfd.send(epacket);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Erro no envio:"
                        + e.getMessage());
                System.exit(-1);
            }
        } // Fim do ciclo do servidor
    }
}
