package chatserver.client;

import chatserver.server.commands.Commands;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientListener implements Runnable {

    private Socket serverSocket;

    public ClientListener(Socket socket) {
        serverSocket = socket;
    }

    public void listenToServer() {

        try {
            Scanner in = new Scanner(serverSocket.getInputStream());

            while (!serverSocket.isClosed()) {

                String fromServer = in.nextLine();
                if (fromServer.equals(Commands.QUIT.getIdentifier())) break;
                System.out.println(fromServer);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("Server has closed down.");
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        listenToServer();
    }
}
