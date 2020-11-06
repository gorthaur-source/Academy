package chatserver.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LaunchClient {

    private static final int DEFAULT_PORT = 8081;
    private static final String DEFAULT_ADDRESS = "localhost";

    public static void main(String[] args) {


        try {

            if (args.length > 2) {
                System.out.println("Invalid request. 2 max number of arguments. <ipAddress> <port number>");
                return;
            }

            String address = args.length == 0 ? DEFAULT_ADDRESS : args[0];
            int port = args.length != 2 ? DEFAULT_PORT : Integer.parseInt(args[1]);
            InetAddress serverAddress = InetAddress.getByName(address);
            ChatClient client = new ChatClient(serverAddress, port);
            client.broadcastToServer();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}