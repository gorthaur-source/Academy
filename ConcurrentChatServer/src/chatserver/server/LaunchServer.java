package chatserver.server;

import chatserver.server.ServerLauncher;
import chatserver.server.commands.Command;

import java.util.LinkedList;
import java.util.List;

public class LaunchServer {

    private static final int DEFAULT_PORT = 8081;

    public static void main(String[] args) {


        try {
            int port = args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]);
            ServerLauncher createServer = new ServerLauncher(20, 500);
            createServer.launchServer(port);
        } catch (NumberFormatException e) {
            System.out.println("Invalid port number: " + args[0]);
        }
    }
}
