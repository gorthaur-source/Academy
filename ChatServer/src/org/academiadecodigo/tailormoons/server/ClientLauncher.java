package org.academiadecodigo.tailormoons.server;

public class ClientLauncher {

    private static final String USAGE_MESSAGE = "Usage: java ClientLauncher <host> <port>";
    private static final String CLOSE_MESSAGE = "/quit";


    public static void main(String[] args) {


            if (args.length < 2) {
                System.out.println(USAGE_MESSAGE);
                return;
            }

            String hostName = args[0];
            int portNumber = Integer.parseInt(args[1]);

            Client client = new Client(hostName, portNumber);
            client.start();






    }
}
