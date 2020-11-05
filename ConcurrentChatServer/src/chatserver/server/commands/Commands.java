package chatserver.server.commands;

public enum Commands {


    HELP("/help"),
    LIST("/list"),
    NAME("/name"),
    QUIT("/quit"),
    WHISPER("/whisper");

     private final String identifier;
     private Command command;


     Commands(String identifier) {
         this.identifier = identifier;
    }

     public String getIdentifier() {
         return identifier;
     }

 }
