package chatserver.server.commands;

public enum Commands {


    HELP("/help", "/help - returns a list of all active commands in the server.", new Help()),
    LIST("/list","/list - returns a list of all connected server users.", new List()),
    NAME("/name", "/name <newName> - changes your nickname", new Name()),
    QUIT("/quit", "/quit - disconnect from the server.", new Quit()),
    WHISPER("/whisper","/whisper <user> <message> - send a private message to another user", new Whisper());

     private final String identifier;
     private final String instruction;
     private final Command command;


     Commands(String identifier, String instruction, Command command) {
         this.identifier = identifier;
         this.instruction = instruction;
         this.command = command;
    }


    public Command getCommand() {
        return command;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getIdentifier() {
         return identifier;
     }

 }
