package org.academiadecodigo.tailormoon.webserver;

import org.academiadecodigo.tailormoon.webserver.Control;

import java.io.IOException;

public class Main {

    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) {

        try {
            int port = args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]);
            Control createServer = new Control(port);
            createServer.start();
        } catch (IOException e) {
            System.err.println("Error creating server socket: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Invalid port number: " + args[0]);
        }

    }
}
