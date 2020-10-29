package org.academiadecodigo.tailormoons.uppercase.client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UppercaseClient {

    private static final int BUFFER_SIZE = 1024;
    private static final String CLOSE_MESSAGE = "/quit";

    private DatagramSocket socket;
    private Scanner scanner;
    private InetAddress serverAddress;
    private int serverPort;

    public UppercaseClient(String serverHostname, int serverPort) throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        scanner = new Scanner(System.in);
        this.serverAddress = InetAddress.getByName(serverHostname);
        this.serverPort = serverPort;
    }

    public void start() {
        while (!socket.isClosed()) {

            try {
                String message = getUserInput();

                if (message.equals(CLOSE_MESSAGE)) {
                    socket.close();
                    continue;
                }

                send(message);
                receive();

            } catch (IOException e) {
                System.err.println("Error communicating with server: " + e.getMessage());
                socket.close();
            }
        }
    }

    private String getUserInput() {
        System.out.print("Input your message: ");
        return scanner.nextLine();
    }

    private void send(String message) throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
        socket.send(packet);
    }

    private void receive() throws IOException {
        DatagramPacket packet = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
        socket.receive(packet);
        String message = new String(packet.getData(), packet.getOffset(), packet.getLength());
        System.out.println("Message from server: " + message);
    }
}
