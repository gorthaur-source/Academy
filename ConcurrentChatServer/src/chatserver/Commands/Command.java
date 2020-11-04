package chatserver.Commands;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public interface Command {


    void commandAction();

    void commandDescription(PrintWriter out);


}
