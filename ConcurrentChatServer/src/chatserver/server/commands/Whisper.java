package chatserver.server.commands;

import chatserver.server.ChatServer;

import java.io.PrintWriter;

public class Whisper implements Command {


    private ChatServer myServer;
    private String[] inputArray;
    private String name;

    public Whisper() {

    }

    public Whisper(ChatServer myServer, String[] input, String name) {
        this.myServer = myServer;
        this.inputArray = input;
        this.name = name;
    }


    @Override
    public void commandAction() {

        PrintWriter myOut = myServer.getUserWriterMap().get(this.name);

        if (inputArray.length < 3) {
            myOut.println("You've used the command wrong. /whisper <user> <message>");
            return;
        }


        if (inputArray[1].toLowerCase().equals(name.toLowerCase())) {
            myOut.println("You can't whisper yourself.");
            return;
        }

        for (String key : myServer.getUserWriterMap().keySet()) {
            if (key.toLowerCase().equals(inputArray[1].toLowerCase())) {
                inputArray[1] = key;
                PrintWriter toSend = myServer.getUserWriterMap().get(inputArray[1]);

                StringBuilder messageTo = new StringBuilder();
                StringBuilder message = new StringBuilder();
                messageTo.append(name).append("(whisper): ");
                message.append(inputArray[1]).append("to ").append(name).append("whisper: ");
                for (int i = 2; i < inputArray.length; i++) {
                    messageTo.append(inputArray[i]).append(" ");
                    message.append(inputArray[i]).append(" ");
                }
                myOut.println(message);
                toSend.println(messageTo);
                return;
            }
        }
        myOut.println("The user you've provided is not connected. Please use /list to display users currently connected.");

    }

    @Override
    public void commandDescription(PrintWriter out) {
        out.println("/whisper <user> <message> - send a private message to another user");
    }
}
