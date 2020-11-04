package chatserver.Commands;

import chatserver.ChatServer;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

public class Quit implements Command{


        private ChatServer myServer;
        private String name;


    public Quit(ChatServer myServer, String name) {
            this.myServer = myServer;
            this.name = name;
        }

        public Quit() {

        }

        public void commandAction() {

        PrintWriter out = myServer.getUserWriterMap().get(name);

            if (name != null && out != null) {
                out.println("Farewell " + name + "! We hope you come back.");
                myServer.getUserWriterMap().remove(name, out);
                for (PrintWriter writer : myServer.getUserWriterMap().values()) {
                    writer.println(name + " has left the server. We hope he comes back.");
                }
            }

        }

        public void commandDescription(PrintWriter out) {

            out.println("/quit - disconnect from the server.");

        }

    }
