package chatserver.server.commands;

import java.io.PrintWriter;

public interface Command {


    void commandAction();

    void commandDescription(PrintWriter out);


}
