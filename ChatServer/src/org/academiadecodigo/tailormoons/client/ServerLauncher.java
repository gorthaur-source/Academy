package org.academiadecodigo.tailormoons.client;

import java.io.IOException;

public class ServerLauncher {

    private static final String USAGE_MESSAGE = "Usage: java ServerLauncher <port>";


    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println(USAGE_MESSAGE);
            return;
        }

        int portNumber = Integer.parseInt(args[0]);

        try {
            Server chatServer = new Server(portNumber);
            chatServer.init();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
