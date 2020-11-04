package chatserver;

import chatserver.Commands.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class ClientThread implements Runnable {

    private String name;
    private final Socket socket;
    private Scanner in;
    private PrintWriter out;
    private final ChatServer myServer;
    private boolean hasQuit = false;


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

            synchronized (myServer.getUserWriterMap()) {
                boolean duplicateName = false;

                for (String key : myServer.getUserWriterMap().keySet()) {
                    if (key.toLowerCase().equals(name.toLowerCase())) {
                        out.println("Invalid name. This key belongs to another user. Please choose another one");
                        duplicateName = true;
                        break;
                    }
                }
                if (!duplicateName) {
                    myServer.getUserWriterMap().put(name, out);
                    break;
                }
            }
        }
    }


    public void handleJoinedUser() {

        out.println("Hello " + name + ". Welcome to Academia de Codigo's server! Type /help to get a list of available commands");

        for (PrintWriter writer : myServer.getUserWriterMap().values()) {
            if(writer == out) continue;
            writer.println(name + " has joined the server. Hello!");
        }
    }

    public void acceptAndBroadcastMsg() {

        while (true) {
            String input = in.nextLine();
            String[] inputArray = input.split(" ");

            if(input.isBlank()) {
                out.println("You're trying to send a blank message. Please type something.");
                continue;
            }
            if (!input.startsWith("/")) {
                for (PrintWriter writer : myServer.getUserWriterMap().values()) {
                    writer.println(name + ": " + input);
                }
                continue;
            }
            boolean validCommand = commandConfig(inputArray);
            if (!validCommand) out.println("Wrong use of command. Please refer to /help for proper usage.");
            else if(hasQuit) break;
        }
    }

    public void run() {

        try {

            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            requestUsername();
            handleJoinedUser();
            acceptAndBroadcastMsg();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                socket.close();
                System.out.println("Socket Closed");
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
                        new Quit(myServer, name).commandAction();
                        hasQuit = true;
                        break;
                    case LIST:
                        new List(myServer, name).commandAction();
                        break;
                    case NAME:
                        new Name(myServer, input, name).commandAction();
                        name = (String) getKeyFromValue();
                        break;
                    case HELP:
                        new Help(myServer, name).commandAction();
                        break;
                    case WHISPER:
                        new Whisper(myServer, input, name).commandAction();
                        break;

                }
            }
        }
        return validCommand;

    }
    public Object getKeyFromValue() {
        for (Object o : myServer.getUserWriterMap().keySet()) {
            if (myServer.getUserWriterMap().get(o).equals(out)) {
                return o;
            }
        }
        return null;
    }
}


