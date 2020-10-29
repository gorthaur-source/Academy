package org.academiadecodigo.tailormoons.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int BUFFER_SIZE = 1024;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public Server(int port) throws IOException {

        System.out.println("Binding to port " + port + ", please wait  ...");
        serverSocket = new ServerSocket(port);
        System.out.println("Server started: " + serverSocket);
        System.out.println("Waiting for client...");
        clientSocket = serverSocket.accept();
        System.out.println("Client accepted: " + clientSocket);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

    }

    public void start() {
        boolean done = false;
        System.out.println("Listening on port: " + serverSocket.getLocalPort());



        while (true) {

            try {

                String line = in.readLine();

                if(line.equals("/quit")) {
                    System.out.println("Quit command issued. Shutting down.");
                    close();
                    break;
                }

                System.out.println("Message read: " + line);

                out.println(line.toUpperCase());


            } catch (IOException e) {
                System.err.println("Error handling client message: " + e.getMessage());
                close();
            }
        }

    }


    public void close() {

        try {
            if (clientSocket != null) clientSocket.close();
            if (in != null) in.close();
            if (out != null) out.close();
            System.out.println("Resources closed.");

        } catch (IOException e) {
            System.out.println("Error closing socket and streams. " + e.getMessage());
        }
    }
}



