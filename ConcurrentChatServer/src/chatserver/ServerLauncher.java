package chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerLauncher {

    private final int MAX_USER_NUMBER;
    private final ExecutorService pool;

    public ServerLauncher(int maxServer, int maxUser) {
        this.MAX_USER_NUMBER = maxUser;
        pool = Executors.newFixedThreadPool(maxServer);

    }

    public void launchServer(int port) {

        try {
           pool.submit(new ChatServer(new ServerSocket(port), MAX_USER_NUMBER));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}