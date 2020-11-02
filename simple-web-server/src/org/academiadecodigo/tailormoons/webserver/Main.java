package org.academiadecodigo.tailormoons.webserver;

import java.io.IOException;

public class Main {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {
        try {
            int port = args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]);

            WebServer webServer = new WebServer(port);
            webServer.start();

        } catch (IOException e) {
            System.err.println("Error creating server socket: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Invalid port number: " + args[0]);
        }
    }

}
