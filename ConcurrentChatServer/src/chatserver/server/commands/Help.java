package chatserver.server.commands;

import chatserver.server.ChatServer;

import java.io.PrintWriter;
import java.util.List;

public class Help implements Command {

    private String name;
    private ChatServer myServer;

   public Help() {

    }

    public Help(ChatServer myServer, String name) {
        this.name = name;
        this.myServer = myServer;
    }

    @Override
    public void commandAction() {

        List<Command> commands = myServer.getCommands();

        myServer.getUserWriterMap().get(name).println("List of available commands: ");
        for (Command command : commands) {
            command.commandDescription(myServer.getUserWriterMap().get(name));
        }
    }

    @Override
    public void commandDescription(PrintWriter out) {

        out.println("/help - returns a list of all active commands in the server.");

    }
}
