package chatserver.Commands;

import chatserver.ChatServer;

public enum Commands {


    HELP("/help"),
    LIST("/list"),
    NAME("/name"),
    QUIT("/quit"),
    WHISPER("/whisper");

     private final String identifier;

     Commands(String identifier) {
         this.identifier = identifier;
    }

     public String getIdentifier() {
         return identifier;
     }

 }
