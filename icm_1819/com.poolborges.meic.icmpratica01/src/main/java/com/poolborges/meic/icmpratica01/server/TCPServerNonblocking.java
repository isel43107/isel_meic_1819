/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.meic.icmpratica01.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pauloborges
 */
public class TCPServerNonblocking implements ServerAPI{
    
    private final static Logger LOG = Logger.getLogger(TCPServerNonblocking.class.getName());

    private Selector selector;
    private ServerSocketChannel serverSocket;
    final private String host;
    final private int port;
    
    public static void main(String[] args) throws IOException {
        /*  */
        ServerAPI serverAPI1 = new TCPServerNonblocking("localhost", 9005);
        serverAPI1.init();
        serverAPI1.start();
       
       
    }

    private static void log(String str) {
        System.out.println(str);
    }
    
    public TCPServerNonblocking(String host, int port){
        this.host = host;
        this.port = port;
    }

    @Override
    public void init() {
        try {
            // Selector: multiplexor of SelectableChannel objects
            this.selector = Selector.open();
            
            // ServerSocketChannel: selectable channel for stream-oriented listening sockets
            serverSocket = ServerSocketChannel.open();
            InetSocketAddress serverAddr = new InetSocketAddress(this.host, this.port);
            
            serverSocket.bind(serverAddr);
            
            // Adjusts this channel's blocking mode.
            serverSocket.configureBlocking(false);
            
            int ops = serverSocket.validOps();
            SelectionKey selectKy = serverSocket.register(selector, ops, null);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Error ao iniciar o servidor", ex);
        }

    }

    @Override
    public void start() {
        // Infinite loop Keep server running
        while (true) {

            try {
                log("Waiting for new connection and buffer select...");
                // Selects a set of keys whose corresponding channels are ready for I/O operations
                selector.select();
                
                // token representing the registration of a SelectableChannel with a Selector
                Set<SelectionKey> crunchifyKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = crunchifyKeys.iterator();
                
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey myKey = selectionKeyIterator.next();
                    
                    // Tests whether this key's channel is ready to accept a new socket connection
                    if (myKey.isAcceptable()) {
                        SocketChannel clientSocketChannel = serverSocket.accept();
                        
                        // Adjusts this channel's blocking mode to false
                        clientSocketChannel.configureBlocking(false);
                        
                        // Operation-set bit for read operations
                        clientSocketChannel.register(selector, SelectionKey.OP_READ);
                        log("Connection Accepted: " + clientSocketChannel.getLocalAddress() + "\n");
                        
                        // Tests whether this key's channel is ready for reading
                    } else if (myKey.isReadable()) {
                        
                        SocketChannel clientSocketChannel = (SocketChannel) myKey.channel();
                        ByteBuffer dataBuffer = ByteBuffer.allocate(256);
                        clientSocketChannel.read(dataBuffer);
                        String result = new String(dataBuffer.array()).trim();
                        
                        log("Message received: " + result);
                        
                        if (result.equals("END")) {
                            clientSocketChannel.close();
                            log("\n Close client connection 'END'");
                            log("\nServer will keep running. Try running client again to establish new connection");
                        }
                    } else if (myKey.isWritable()) {
                        SocketChannel clientSocketChannel = (SocketChannel) myKey.channel();
                        String result = new String("OLA MUNDO");
                        ByteBuffer dataBuffer = ByteBuffer.wrap(result.getBytes());
                        clientSocketChannel.write(dataBuffer);
                        
                        log("Message sended: " + result);
                        
                    }
                    selectionKeyIterator.remove();
                }
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, "Erro na execuçao do servidor", ex);
            }
        }
    }

    @Override
    public void stop() {
       log("\n NAO IMPLEMENTADO AINDA'");
    }
}
