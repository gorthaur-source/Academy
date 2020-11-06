package chatserver.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import chatserver.server.commands.*;

import static java.lang.System.currentTimeMillis;

public class ClientThread implements Runnable {

    private String name;
    private final Socket socket;
    private final ChatServer myServer;
    private boolean hasQuit = false;
    private Scanner in;
    private PrintWriter out;

    public ClientThread(Socket socket, ChatServer myServer) {
        this.socket = socket;
        this.myServer = myServer;
    }

    public void requestUsername() {

        while (true) {
            out.println("Submit your nickname");
            name = in.nextLine();

            if (name.length() > 15 || name.length() < 4) {
                out.println("Please choose a nickname between 4 and 15 characters");
                continue;
            }
            if (myServer.validateUsername(name)) {
                myServer.addToUserMap(name, this);
                break;
            }
        }
    }


    public void acceptAndBroadcastMsg() {

        while (true) {

            String input = in.nextLine();
            String[] inputArray = input.split(" ");

            if (input.isBlank()) {
                out.println("You're trying to send a blank message. Please type something.");
                continue;
            }
            if (!input.startsWith("/")) {
                if (myServer.spamMapContainsKey(name)) {
                    System.out.println("checking");
                    long currentTime = currentTimeMillis();
                    if (currentTime - myServer.getSpamValueFromKey(name) < 500) {
                        System.out.println(currentTime - myServer.getSpamValueFromKey(name));
                        out.println("You're sending messages too fast. Please wait.");
                        continue;
                    }
                    myServer.removeFromSpamMap(name);
                    myServer.addToSpamMap(name, currentTimeMillis());
                }
                myServer.broadcast(name + ": " + input);
                continue;
            }
            boolean validCommand = commandConfig(inputArray);
            if (!validCommand) out.println("Wrong use of command. Please refer to /help for proper usage.");
            else if (hasQuit) break;
        }
    }


    public void run() {

        try {

            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            requestUsername();
            myServer.joinedUser(name);
            acceptAndBroadcastMsg();

        } catch (Exception e) {
            System.out.println("Client disconnected");
        } finally {
            try {
                socket.close();
                myServer.removeFromUserMap(name);
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }


    public boolean commandConfig(String[] input) {
        boolean validCommand = false;
        for (Commands c : Commands.values()) {
            if (input[0].toLowerCase().equals(c.getIdentifier())) {
                validCommand = true;
                switch (c) {
                    case QUIT:
                        Commands.QUIT.getCommand().commandAction(myServer, name);
                        hasQuit = true;
                        break;
                    case LIST:
                        Commands.LIST.getCommand().commandAction(myServer, name);
                        break;
                    case NAME:
                        Commands.NAME.getCommand().commandAction(myServer, input, name);
                        name = (String) myServer.getKeyFromValue(this);
                        break;
                    case HELP:
                        Commands.HELP.getCommand().commandAction(myServer, name);
                        break;
                    case WHISPER:
                        Commands.WHISPER.getCommand().commandAction(myServer, input, name);
                        break;
                }
            }
        }
        return validCommand;
    }


    public void send(String message) {
        out.println(message);
    }
}


