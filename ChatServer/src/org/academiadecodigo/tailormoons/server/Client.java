package org.academiadecodigo.tailormoons.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static final String CLOSE_MESSAGE = "/quit";
    private Scanner scanner;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader reader;

    public Client(String serverHostName, int serverPort) throws IOException {
        System.out.println("Establishing connection. Please wait ...");

            socket = new Socket(serverHostName, serverPort);
            System.out.println("Connected: " + socket);
    }


    public void start() throws IOException {

        openStreams();

        while (true) {

                String line = getUserInput();

                out = new PrintWriter(socket.getOutputStream(), true);
                out.println(line);


                if(line.equals(CLOSE_MESSAGE)) {
                    System.out.println("Quit command issued. Shutting down.");
                    close();
                    return;
                }

                if(socket.isClosed()) {
                    System.out.println("Server connection severed. Shutting down.");
                    close();
                    return;
                }

                String receivedLine = reader.readLine();
                System.out.println("Server sent back: " + receivedLine);
            }
    }


    public void openStreams() throws IOException {

            scanner = new Scanner(System.in);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

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
