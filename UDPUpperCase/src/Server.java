import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Server {


    DatagramSocket socket;
    DatagramPacket receive;
    int portNumber;

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }


    public byte[] receivePacket() {

        try {

            byte[] receiveBuff = new byte[1024];

            socket = new DatagramSocket(portNumber);
            receive = new DatagramPacket(receiveBuff, receiveBuff.length);

            socket.receive(receive);



        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return receiveBuff;
    }


}