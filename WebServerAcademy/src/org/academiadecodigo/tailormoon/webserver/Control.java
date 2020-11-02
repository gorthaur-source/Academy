package org.academiadecodigo.tailormoon.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Control {

    private ServerSocket serverSocket;



    public Control(int port) throws IOException {

        new WebServer(new Socket());
        serverSocket = new ServerSocket(port);
        System.out.println("Binding to port " + port + " . Please wait.");
        System.out.println("Server started: " + serverSocket);
        System.out.println("Waiting for client...");
    }

    public void start() {

        while (!serverSocket.isClosed()) {
            try {
                Socket client = serverSocket.accept();
                Thread thread = new Thread(new WebServer(client));
                thread.start();
            } catch (IOException e) {
                System.err.println("Error handling client request: " + e.getMessage());
            }
        }
    }
}
