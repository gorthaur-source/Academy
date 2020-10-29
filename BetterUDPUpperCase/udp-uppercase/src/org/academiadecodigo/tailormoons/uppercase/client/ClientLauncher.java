package org.academiadecodigo.tailormoons.uppercase.client;

import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientLauncher {

    private static final String USAGE_MESSAGE = "Usage: java ClientLauncher <host> <port>";

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println(USAGE_MESSAGE);
            return;
        }

        try {
            String host = args[0];
            int port = Integer.parseInt(args[1]);

            UppercaseClient client = new UppercaseClient(host, port);
            client.start();

        } catch (NumberFormatException e) {
            System.out.println("Invalid port number: " + args[0]);
            System.out.println(USAGE_MESSAGE);

        } catch (SocketException e) {
            System.err.println("Error opening socket: " + e.getMessage());

        } catch (UnknownHostException e) {
            System.err.println("Invalid host name: " + args[0]);
        }
    }
}
