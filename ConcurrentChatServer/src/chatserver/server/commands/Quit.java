package chatserver.server.commands;

import chatserver.server.ChatServer;
import chatserver.server.ClientThread;

public class Quit implements Command {


    public void commandAction(ChatServer myServer, String name) {


            myServer.getFromName(name).send("Farewell " + name + "! We hope you come back.");
            myServer.removeFromUserMap(name);
            myServer.broadcast(name + " has left the server. We hope he comes back.");
    }


    @Override
    public void commandAction(ChatServer myServer, String[] input, String name) {

    }

}
