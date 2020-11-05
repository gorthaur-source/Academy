package chatserver.server.commands;

import chatserver.server.ChatServer;

import java.io.PrintWriter;
import java.util.Arrays;

public class Name implements Command {

    private ChatServer myServer;
    private String[] inputArray;
    private String name;


    public Name() {

    }

    public Name(ChatServer myServer, String[] input, String name) {
        this.myServer = myServer;
        this.inputArray = input;
        this.name = name;
    }

    @Override
    public void commandAction() {

        PrintWriter out = myServer.getUserWriterMap().get(this.name);
        System.out.println(Arrays.toString(inputArray));

        if (inputArray.length != 2) {
            out.println("You've used the command wrong. /name <newNickname>");
            return;
        }

        String name = inputArray[1];
        System.out.println(name);

        if (name.length() > 15 || name.length() < 4) {
            out.println("Please choose a nickname between 4 and 15 characters");
            return;
        }

        synchronized (myServer.getUserWriterMap()) {

            if (name.toLowerCase().equals(this.name.toLowerCase())) {
                out.println("Your name is already " + name);
                return;
            }

            for (String key : myServer.getUserWriterMap().keySet()) {
                if (key.toLowerCase().equals(name.toLowerCase())) {
                    out.println("Invalid name. This key belongs to another user. Please choose another one");
                    return;
                }
            }

                myServer.getUserWriterMap().put(name, out);
                myServer.getUserWriterMap().remove(this.name);

                out.println("You've successfully changed your nickname from " + this.name + " to " + name);
                for (PrintWriter writer : myServer.getUserWriterMap().values()) {
                    if (writer == out) continue;
                    writer.println(this.name + " has changed his nickname to " + name);
                }
            }
        }



    @Override
    public void commandDescription(PrintWriter out) {

        out.println("/name <newName> - changes your nickname");

    }
}
