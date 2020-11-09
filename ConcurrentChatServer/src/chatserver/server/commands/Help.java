package chatserver.server.commands;

import chatserver.server.ChatServer;
import chatserver.server.ClientThread;

import java.io.PrintWriter;
import java.util.List;

public class Help implements Command {


   public Help() {

    }

    @Override
    public void commandAction(ChatServer myServer, String name) {

        myServer.getFromName(name).send("List of available commands: ");
        for (Commands command : Commands.values()) {

            myServer.getFromName(name).send(command.getInstruction());
        }
    }

    @Override
    public void commandAction(ChatServer myServer, String[] input, String name) {

    }

}
