package chatserver.server.commands;

import chatserver.server.ChatServer;

import java.io.PrintWriter;

public class List implements Command {

    private ChatServer myServer;
    private String name;

    public List(ChatServer myServer, String name) {
        this.myServer = myServer;
        this.name = name;
    }

    public List() {

    }

    public void commandAction() {

        PrintWriter out = myServer.getUserWriterMap().get(name);

        out.println("List of connected users:");
        for (String user : myServer.getUserWriterMap().keySet()) {
           out.println(user);
        }
    }

    public void commandDescription(PrintWriter out) {

        out.println("/list - returns a list of all connected server users.");

    }


}
