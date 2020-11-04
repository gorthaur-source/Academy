package chatserver.Commands;

import chatserver.ChatServer;

import java.io.PrintWriter;

public class Whisper implements Command {


    private ChatServer myServer;
    private String input;
    private String name;

    public Whisper() {

    }

    public Whisper(ChatServer myServer, String input, String name) {
        this.myServer = myServer;
        this.input = input;
        this.name = name;
    }


    @Override
    public void commandAction() {

        PrintWriter myOut = myServer.getUserWriterMap().get(this.name);

        String[] inputArray = input.trim().split(" ");
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

                StringBuilder message = new StringBuilder();
                message.append(name).append("(whisper) ").append(":").append(" ");

                for (int i = 2; i < inputArray.length; i++) {
                    message.append(inputArray[i]).append(" ");
                }
                toSend.println(message);
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
