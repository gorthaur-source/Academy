package org.academiadecodigo.tailormoons.uppercase.server;

import java.io.IOException;
import java.net.SocketException;

public class ServerLauncher {

    private static final String USAGE_MESSAGE = "Usage: java ServerLauncher <port>";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(USAGE_MESSAGE);
            return;
        }

        try {
            int port = Integer.parseInt(args[0]);

            UppercaseServer server = new UppercaseServer(port);
            server.start();

        } catch (NumberFormatException e) {
            System.out.println("Invalid port number: " + args[0]);
            System.out.println(USAGE_MESSAGE);

        } catch (SocketException e) {
            System.err.println("Error opening server socket: " + e.getMessage());
        }
    }
}
