import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Server {



    int portNumberReceive;
    int portNumberSend;
    DatagramSocket receivingSocket;
    byte[] receiveBuff = new byte[1024];

    public Server(int portNumberReceive, int portNumberSend) {
        this.portNumberReceive = portNumberReceive;
        this.portNumberSend = portNumberSend;

        try {
            receivingSocket = new DatagramSocket(portNumberReceive);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }



    public void receiveUnprocessedPacket() {

        byte[] receiveBuff = new byte[2024];


        try {

            DatagramPacket receive = new DatagramPacket(receiveBuff, receiveBuff.length);
            receivingSocket.receive(receive);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (receivingSocket != null) {
                receivingSocket.close();
            }

            this.receiveBuff = receiveBuff;
        }
    }

    public String processString() {

        byte[] toBeProcessed = receiveBuff;

        return new String(toBeProcessed, StandardCharsets.UTF_8).toUpperCase();

    }

    public byte[] encodeProcessedString() {

        byte[] sendBuff;

       return sendBuff = processString().getBytes();

    }


    public void sendProcessedPacket() {



        try (DatagramSocket socket = new DatagramSocket()) {

            DatagramPacket sendPacket = new DatagramPacket(encodeProcessedString(), encodeProcessedString().length, InetAddress.getByName("localhost"), portNumberSend);
            socket.send(sendPacket);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int portNumberReceive = Integer.parseInt(args[0]);
        int portNumberSend = Integer.parseInt(args[1]);
        Server server = new Server(portNumberReceive, portNumberSend);
        server.receiveUnprocessedPacket();
        server.sendProcessedPacket();
    }
}