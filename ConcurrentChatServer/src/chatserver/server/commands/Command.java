package chatserver.server.commands;

import chatserver.server.ChatServer;

public interface Command {


    void commandAction(ChatServer myServer, String name);

    void commandAction(ChatServer myServer, String[] input, String name);


}
