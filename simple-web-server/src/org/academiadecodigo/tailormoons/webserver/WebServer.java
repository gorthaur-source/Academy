package org.academiadecodigo.tailormoons.webserver;

import org.academiadecodigo.tailormoons.webserver.request.Request;
import org.academiadecodigo.tailormoons.webserver.request.InvalidRequestException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private static final String OK_STATUS = "200 Document Follows";
    private static final String NOT_FOUND_STATUS = "404 Not Found";
    private static final String METHOD_NOT_ALLOWED_STATUS = "405 Method Not Allowed";

    private static final String ROOT_DIRECTORY = "www";
    private static final String INDEX_FILENAME = "index.html";

    private static final File NOT_FOUND = new File(ROOT_DIRECTORY + "/not_found.html");
    private static final File NOT_SUPPORTED = new File(ROOT_DIRECTORY + "/not_allowed.html");

    private ServerSocket serverSocket;

    public WebServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        while (!serverSocket.isClosed()) {
            Socket client = null;

            try {
                System.out.println("Waiting for connection on port " + serverSocket.getLocalPort());
                client = serverSocket.accept();

                System.out.println("Connection received from " + client.getInetAddress() + ":" + client.getPort());
                Request request = parseRequest(client.getInputStream());

                System.out.println(request);
                serve(client.getOutputStream(), request);

            } catch (InvalidRequestException e) {
                System.out.println("Invalid request header");

            } catch (IOException e) {
                System.err.println("Error handling client request: " + e.getMessage());

            } finally {
                close(client);
            }
        }
    }

    private Request parseRequest(InputStream inputStream) throws InvalidRequestException {
        String header = readRequestHeader(inputStream);
        String[] headerParts = header.split(" ");

        if (headerParts.length < 2) {
            throw new InvalidRequestException();
        }

        String verb = headerParts[0];
        File resource = new File(ROOT_DIRECTORY + headerParts[1]);

        return new Request(verb, resource);
    }

    private String readRequestHeader(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder header = new StringBuilder();

        try {
            String line = reader.readLine();

            while (line != null && !line.isEmpty()) {
                header.append(line).append("\n");
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.err.println("Error reading client's request: " + e.getMessage());
        }

        return header.toString();
    }

    private void serve(OutputStream outputStream, Request request) throws IOException {
        DataOutputStream out = new DataOutputStream(outputStream);
        File file = request.getResource();
        String statusCode = OK_STATUS;

        if (file.isDirectory()) {
            file = new File(file.getPath() + "/" + INDEX_FILENAME);
        }

        if (!file.exists()) {
            statusCode = NOT_FOUND_STATUS;
            file = NOT_FOUND;
        }

        if (!request.getVerb().equals("GET")) {
            statusCode = METHOD_NOT_ALLOWED_STATUS;
            file = NOT_SUPPORTED;
        }

        sendHeader(out, statusCode, file);
        sendFile(out, file);
    }

    private void sendHeader(DataOutputStream out, String statusCode, File resource) throws IOException {
        out.writeBytes("HTTP/1.0 " + statusCode + " \r\n");
        out.writeBytes("Content-Type: " + MimeType.getFromFile(resource) + " \r\n");
        out.writeBytes("Content-Length: " + resource.length() + " \r\n");
        out.writeBytes("\r\n");
    }

    private void sendFile(DataOutputStream out, File resource) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(resource));
        int byteRead;

        try {
            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }

        } finally {
            in.close();
        }
    }

    private void close(Socket client) {
        if (client == null) {
            return;
        }

        try {
            client.close();
        } catch (IOException e) {
            System.err.println("Error closing client connection: " + e.getMessage());
        }
    }
}
