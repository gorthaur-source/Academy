package org.academiadecodigo.tailormoons.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final String CLOSE_MESSAGE = "/quit";
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private final int port;

    public Server(int port){
        this.port = port;
        System.out.println("Binding to port " + port + ", please wait  ...");



    }


    public void init() throws IOException {

        serverSocket = new ServerSocket(port);
        System.out.println("Server started: " + serverSocket);
        System.out.println("Waiting for client...");
        clientSocket = serverSocket.accept();
        System.out.println("Client accepted: " + clientSocket);

        openStreams();
        System.out.println("Listening on port: " + serverSocket.getLocalPort());
        start();
    }

    public void start() throws IOException {


        while (true) {

            String line = in.readLine();

            if(line == null) {
                System.out.println("Client disconnected.");
                close();
                init();
                return;
            }

            if (line.equals(CLOSE_MESSAGE)) {
                System.out.println("Quit command issued. Shutting down.");
                close();
                serverSocket.close();
                break;
            }

            System.out.println("Message read: " + line);

            out.println(line.toUpperCase());
        }

    }


    public void openStreams() {

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error opening streams: " + e.getMessage());
        }
    }

    public void close() {

        try {
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
            if (in != null) in.close();
            if (out != null) out.close();
            System.out.println("Resources closed.");

        } catch (IOException e) {
            System.out.println("Error closing socket and streams. " + e.getMessage());
        }
    }
}



