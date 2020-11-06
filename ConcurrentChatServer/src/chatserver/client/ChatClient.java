package chatserver.client;

import chatserver.server.commands.Commands;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    private InetAddress serverAddress;
    private int portNumber;
    private Socket socket;

    public ChatClient(InetAddress serverAddress, int portNumber) {

        this.serverAddress = serverAddress;
        this.portNumber = portNumber;

    }


    public void broadcastToServer() {

        try {
            socket = new Socket(serverAddress, portNumber);
        } catch (IOException e) {
            System.out.println("The server you've specified is not running or the connection has been refused. Please check again.");

        }

        try {

            if (socket == null) {
                return;
            }

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner input = new Scanner(System.in);

            Thread thread = new Thread(new ClientListener(socket));
            thread.start();

                while (input.hasNextLine()) {

                    String toServer = input.nextLine();
                    out.println(toServer);
                }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}