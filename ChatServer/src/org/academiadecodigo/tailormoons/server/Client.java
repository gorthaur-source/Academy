package org.academiadecodigo.tailormoons.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private Scanner scanner;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader reader;

    public Client(String serverHostName, int serverPort) {
        System.out.println("Establishing connection. Please wait ...");

        try {
            socket = new Socket(serverHostName, serverPort);
            System.out.println("Connected: " + socket);
            scanner = new Scanner(System.in);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {

        while (true) {

            try {

                String line = getUserInput();

                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(line);


                if(line.equals("/quit")) {
                    System.out.println("Quit command issued. Shutting down.");
                    close();
                    break;
                }

                String receivedLine = reader.readLine();
                System.out.println("Server sent back: " + receivedLine);

            } catch (IOException e) {
                System.err.println("Error communicating with server: " + e.getMessage());
                close();
            }
        }

    }


    public void close() {

        try {
            if (scanner != null) scanner.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
            System.out.println("Resources closed.");

        } catch (IOException e) {
            System.out.println("Error closing socket: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String getUserInput() {
        System.out.print("Input your message: ");
        return scanner.nextLine();
    }
}
