import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client {

    String inputString;
    int portNumberReceive;
    int portNumberSend;
    DatagramSocket receivingSocket;
    byte[] receivedBuff = new byte[1024];

    public Client(String sendMessage, int portNumberReceive, int portNumberSend) {

        this.inputString = sendMessage;
        this.portNumberReceive = portNumberReceive;
        this.portNumberSend = portNumberSend;

        try {
            receivingSocket = new DatagramSocket(portNumberReceive);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    public void sendUnprocessedPacket() {

        try (DatagramSocket socket = new DatagramSocket()) {

            byte[] sendBuffer = inputString.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName("localhost"), portNumberSend);
            socket.send(sendPacket);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void receiveProcessedPacket() {

        byte[] receiveBuff = new byte[2024];


        try {

            DatagramPacket receive = new DatagramPacket(receiveBuff, receiveBuff.length);

            receivingSocket.receive(receive);

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.receivedBuff = receiveBuff;
    }

    public String decodeProcessedPacket() {

        return new String(receivedBuff, StandardCharsets.UTF_8);

    }


    public static void main(String[] args) {

        int portNumberReceive = Integer.parseInt(args[0]);
        int portNumberSend = Integer.parseInt(args[1]);

        StringBuilder message = new StringBuilder();

        for (int i = 2; i < args.length; i++) {

            message.append(args[i]).append(" ");
        }

        Client client = new Client(message.toString(), portNumberSend, portNumberReceive);

        client.sendUnprocessedPacket();
        client.receiveProcessedPacket();
        System.out.println(client.decodeProcessedPacket());


    }
}