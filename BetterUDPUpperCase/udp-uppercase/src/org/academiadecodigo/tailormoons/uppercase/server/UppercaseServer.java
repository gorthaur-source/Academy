package org.academiadecodigo.tailormoons.uppercase.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UppercaseServer {

    private static final int BUFFER_SIZE = 1024;

    private DatagramSocket socket;

    public UppercaseServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() {
        System.out.println("Listening on port: " + socket.getLocalPort());

        while (!socket.isClosed()) {

            try {
                DatagramPacket packet = receive();
                String message = parse(packet);
                send(packet.getAddress(), packet.getPort(), message);

            } catch (IOException e) {
                System.err.println("Error handling client message: " + e.getMessage());
                socket.close();
            }
        }
    }

    private DatagramPacket receive() throws IOException {
        DatagramPacket packet = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
        socket.receive(packet);
        return packet;
    }

    private String parse(DatagramPacket packet) {
        return new String(packet.getData(), packet.getOffset(), packet.getLength()).toUpperCase();
    }

    private void send(InetAddress address, int port, String message) throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
        socket.send(packet);
    }
}
