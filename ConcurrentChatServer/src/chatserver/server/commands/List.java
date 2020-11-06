package chatserver.server.commands;

import chatserver.server.ChatServer;
import chatserver.server.ClientThread;

import java.io.PrintWriter;

public class List implements Command {


    public void commandAction(ChatServer myServer, String name) {

        myServer.getFromName(name).send("List of connected users:");
        myServer.listUsers(name);
    }

    @Override
    public void commandAction(ChatServer myServer, String[] input, String name) {

    }



}
