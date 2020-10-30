import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ContentHandlerFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLSourceViewer {


    private final String hostURL;

    public URLSourceViewer(String hostURL) {
        this.hostURL = hostURL;
    }

    public URL convertToURL() {

        URL host = null;

        try {
            host = new URL(hostURL);
        } catch (MalformedURLException e) {
            System.out.println("Invalid url: " +  hostURL);
        }
        return host;
    }

    public URLConnection establishConnection(URL url) throws IOException {

        return url.openConnection();

    }


    public void readContent(URLConnection connection) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String s;

        while ((s = in.readLine()) != null) {
            System.out.println(s);
        }
        in.close();

    }

    public static void main(String[] args) {


        if (args.length != 1) {
            System.out.println("No URL inserted.");
        }


        String hostURL = args[0];

        try {
            URLSourceViewer sourceViewer = new URLSourceViewer(hostURL);

            URLConnection connection = sourceViewer.establishConnection(sourceViewer.convertToURL());

            sourceViewer.readContent(connection);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
