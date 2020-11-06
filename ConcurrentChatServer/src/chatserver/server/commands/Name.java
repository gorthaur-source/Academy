package chatserver.server.commands;

import chatserver.server.ChatServer;
import chatserver.server.ClientThread;

public class Name implements Command {

    public Name() {

    }

    @Override
    public void commandAction(ChatServer myServer, String[] input, String name) {

        ClientThread myThread = myServer.getFromName(name);

        if (input.length != 2) {
            myThread.send("You've used the command wrong. /name <newNickname>");
            return;
        }

        String parsedName = input[1];
        System.out.println(parsedName);

        if (parsedName.length() > 15 || parsedName.length() < 4) {
            myThread.send("Please choose a nickname between 4 and 15 characters");
            return;
        }

        if (parsedName.toLowerCase().equals(name.toLowerCase())) {
            myThread.send("Your name is already " + name);
            return;
        }

        if (myServer.nameExistsCaseInsensitive(parsedName)) {
            myThread.send("Invalid name. This key belongs to another user. Please choose another one");
        }


        myServer.addToUserMap(parsedName, myServer.getFromName(name));
        myServer.removeFromUserMap(name);

        myServer.broadcast(name + " has changed his nickname to " + parsedName);
    }


    @Override
    public void commandAction(ChatServer myServer, String name) {

    }

}
