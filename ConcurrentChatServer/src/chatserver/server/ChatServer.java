package chatserver.server;

import chatserver.server.commands.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.currentTimeMillis;

public class ChatServer implements Runnable {

    private final Map<String, ClientThread> userThreadMap;
    private final Map<String, Long> userSpamMap;
    private final ServerSocket serverSocket;
    private final int MAX_USER_NUMBER;

    public ChatServer(ServerSocket serverSocket, int maxUser) {
        this.serverSocket = serverSocket;
        this.MAX_USER_NUMBER = maxUser;
        System.out.println("The chat server is running on port " + serverSocket.getLocalPort() + ".");
        userThreadMap = new HashMap<>();
        userSpamMap = new HashMap<>();
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
        pool.shutdown();
    }

    @Override
    public void run() {
        serverAcceptLoop();
    }


    public void addToUserMap(String name, ClientThread thread) {
        synchronized (userThreadMap) {
            if (!userThreadMap.containsKey(name)) {
                userThreadMap.put(name, thread);
            }
        }
    }

    public void removeFromUserMap(String name) {

        synchronized (userThreadMap) {
            userThreadMap.remove(name);
        }
    }

    public void addToSpamMap(String name, long ms) {
        synchronized (userSpamMap) {
            userSpamMap.put(name, ms);
        }
    }

    public void removeFromSpamMap(String name) {

        synchronized (userSpamMap) {
            userSpamMap.remove(name);
        }
    }

    public boolean spamMapContainsKey(String name) {
        return userSpamMap.containsKey(name);
    }

    public long getSpamValueFromKey(String name) {
        return userSpamMap.get(name);
    }

    public Object getKeyFromValue(ClientThread thread) {
        for (Object o : userThreadMap.keySet()) {
            if (userThreadMap.get(o).equals(thread)) {
                return o;
            }
        }
        return null;
    }

    public boolean validateUsername(String name) {
        synchronized (userThreadMap) {

            for (String key : userThreadMap.keySet()) {
                System.out.println("check");
                if (key.toLowerCase().equals(name.toLowerCase())) {
                    userThreadMap.get(name).send("Invalid name. This key belongs to another user. Please choose another one");
                    return false;
                }
            }
            return true;
        }
    }


    public void broadcast(String message) {

        synchronized (userThreadMap) {
            for (ClientThread thread : userThreadMap.values()) {
                //    if (userThreadMap.get(name) == thread) continue;
                thread.send(message);
            }
        }

    }


    public void joinedUser(String name) {

        Date date = new Date();
        userSpamMap.put(name, currentTimeMillis());
        userThreadMap.get(name).send((date + ": Hello " + name + ". Welcome to Academia de Codigo's server! Type /help to get a list of available commands"));

        synchronized (userThreadMap) {
            for (ClientThread thread : userThreadMap.values()) {
                if (userThreadMap.get(name) == thread) continue;
                thread.send(name + " has joined the server. Hello!");
            }
        }
    }

    public ClientThread getFromName(String name) {
        return userThreadMap.get(name);
    }

    public void whisper(String name, StringBuilder messageTo, StringBuilder message, String nameToSend) {
        synchronized (userThreadMap) {
            for (String key : userThreadMap.keySet()) {
                if (key.toLowerCase().equals(nameToSend.toLowerCase())) {
                    nameToSend = key;
                    userThreadMap.get(name).send(message.toString());
                    userThreadMap.get(nameToSend).send(messageTo.toString());
                    return;
                }
            }
        }
        userThreadMap.get(name).send("The user you've provided is not connected. Please use /list to display users currently connected.");
    }

    public void listUsers(String name) {

        synchronized (userThreadMap) {
            for (String names : userThreadMap.keySet()) {
                userThreadMap.get(name).send(names);
            }
        }

    }

    public boolean nameExistsCaseInsensitive(String name) {
        for (String key : userThreadMap.keySet()) {
            if (key.toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;
    }


}
