package org.academiadecodigo.tailormoons.server;

import java.io.IOException;
import java.net.SocketException;

public class ClientLauncher {

    private static final String USAGE_MESSAGE = "Usage: java ClientLauncher <host> <port>";


    public static void main(String[] args) {


            if (args.length < 2) {
                System.out.println(USAGE_MESSAGE);
                return;
            }

            try {

                String hostName = args[0];
                int portNumber = Integer.parseInt(args[1]);

                Client client = new Client(hostName, portNumber);
                client.start();

            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
