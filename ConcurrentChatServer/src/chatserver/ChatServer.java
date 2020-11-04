package chatserver;

import chatserver.Commands.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer implements Runnable {

   // private final Set<String> users = new HashSet<>();
   // private final Set<PrintWriter> writers = new HashSet<>();
    private final Map<String, PrintWriter> userWriterMap;
    private final ServerSocket serverSocket;
    private final int MAX_USER_NUMBER;
    private final List<Command> commands = new ArrayList<>();


    public ChatServer(ServerSocket serverSocket, int maxUser) {
        this.serverSocket = serverSocket;
        this.MAX_USER_NUMBER = maxUser;
        System.out.println("The chat server is running on port " + serverSocket.getLocalPort() + ".");
        commands.add(new chatserver.Commands.List());
        commands.add(new Quit());
        commands.add(new Name());
        commands.add(new Whisper());
        commands.add(new Help());
        userWriterMap = new HashMap<>();


    }

    public void serverAcceptLoop() {

        ExecutorService pool = Executors.newFixedThreadPool(MAX_USER_NUMBER);
        try {
            while (true) {
                pool.execute(new ClientThread(serverSocket.accept(), this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        serverAcceptLoop();
    }

    public List<Command> getCommands() {
        return commands;
    }

    public Map<String, PrintWriter> getUserWriterMap() {
        return userWriterMap;

    }

}
