public class Main {


    public static void main(String[] args){

        if(args != null) {

            int portNumberReceive = Integer.parseInt(args[0]);
            int portNumberSend = Integer.parseInt(args[1]);

            StringBuilder message = new StringBuilder();

            for (int i = 2; i < args.length; i++) {

                message.append(args[i]).append(" ");
            }
            Server server = new Server(portNumberReceive, portNumberSend);

            Client client = new Client(message.toString(), portNumberSend, portNumberReceive);

            client.sendUnprocessedPacket();
            server.receiveUnprocessedPacket();
            server.sendProcessedPacket();
            client.receiveProcessedPacket();
            System.out.println(client.decodeProcessedPacket());

        }
    }
}
