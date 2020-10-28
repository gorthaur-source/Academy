import java.io.IOException;
import java.net.*;

public class Client {

    String inputString;
    int portNumber;

    public Client(String sendMessage, int portNumber) {

        this.inputString = sendMessage;
        this.portNumber = portNumber;


    }

    public void sendPacket() {


        try {

            byte[] sendBuffer = inputString.getBytes();

            DatagramSocket socket = new DatagramSocket();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName("localhost"), portNumber);
            socket.send(sendPacket);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}