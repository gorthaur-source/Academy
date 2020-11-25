package org.academiadecodigo.tailormoon.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Control {

    private ServerSocket serverSocket;
    private final ExecutorService cachedPool;



    public Control(int port) throws IOException {
        new WebServer(new Socket());
        serverSocket = new ServerSocket(port);
        cachedPool = Executors.newFixedThreadPool(500);
        System.out.println("Binding to port " + port + " . Please wait.");
        System.out.println("Server started: " + serverSocket);
        System.out.println("Waiting for client...");
    }

    public void start() {

        while (!serverSocket.isClosed()) {
            try {
             //   Socket client = serverSocket.accept();
                cachedPool.submit(new WebServer(serverSocket.accept()));
               // Thread thread = new Thread(new WebServer(client));
               // thread.start();
             //   System.out.println(thread.toString());
            } catch (IOException e) {
                System.err.println("Error handling client request: " + e.getMessage());
            }
        }
        cachedPool.shutdown();
    }
}
