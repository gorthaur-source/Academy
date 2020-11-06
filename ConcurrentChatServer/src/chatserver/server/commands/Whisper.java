package chatserver.server.commands;

import chatserver.server.ChatServer;
import chatserver.server.ClientThread;

import java.io.PrintWriter;

public class Whisper implements Command {

    @Override
    public void commandAction(ChatServer myServer, String name) {

    }

    @Override
    public void commandAction(ChatServer myServer, String[] input, String name) {

        System.out.println("its here");
        ClientThread myThread = myServer.getFromName(name);
        System.out.println("and here");
        if (input.length < 3) {
            myThread.send("You've used the command wrong. /whisper <user> <message>");
            return;
        }

        System.out.println("check dude");

        if (input[1].toLowerCase().equals(name.toLowerCase())) {
            myThread.send("You can't whisper yourself.");
            return;
        }
        StringBuilder messageTo = new StringBuilder();
        StringBuilder message = new StringBuilder();
        messageTo.append(name).append("(whisper): ");
        message.append(input[1]).append(" to ").append(name).append(" (whisper): ");
        for (int i = 2; i < input.length; i++) {
            messageTo.append(input[i]).append(" ");
            message.append(input[i]).append(" ");
        }
        myServer.whisper(name, messageTo, message, input[1]);

    }

}
