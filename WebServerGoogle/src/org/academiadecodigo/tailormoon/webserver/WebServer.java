package org.academiadecodigo.tailormoon.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {


    static final String DEFAULT_FILE = "www/index.htm/";
    static final String FILE_NOT_FOUND = "www/404.htm/";
    private final int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private File index;
    private BufferedOutputStream outputStream;

    public WebServer(int port) {
        this.port = port;
        System.out.println("Binding to port " + port + " . Please wait.");
    }

    public void init() {

        try {

            serverSocket = new ServerSocket(port);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for client...");
            run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run() throws IOException {

        while(true) {

            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            System.out.println(clientSocket.toString());

            openStreams();

            String request = reader.readLine();
            String[] requestArray = request.split(" ");
            String requestedFile = "www/" + requestArray[1];

            System.out.println("Header : " + requestArray[0] + "\nRequested file: " + requestArray[1]);

            if (!requestArray[0].equals("GET")) {

                index = new File(FILE_NOT_FOUND);

                sendHeaders(index);
                writeAndFlush(index);
                closeStreams();

            } else {

                index = new File(requestedFile);

                if (requestedFile.endsWith("/")) {

                    requestedFile = DEFAULT_FILE;
                    index = new File(requestedFile);
                    sendHeaders(index);
                    writeAndFlush(index);
                    closeStreams();
                }

                   else if (index.exists()) {

                    index = new File(requestedFile);
                    sendHeaders(index);
                    writeAndFlush(index);
                    closeStreams();
                } else {
                    requestedFile = FILE_NOT_FOUND;
                    index = new File(requestedFile);
                    sendHeaders(index);
                    writeAndFlush(index);
                    closeStreams();

                }

            }
        }
    }

    public void sendHeaders(File file) {

        String contentType = getContentType(file.toString());

        writer.print("HTTP/1.1 200 Document Follows\r\n)");
        writer.print("Content-Type: " + contentType + " charset=UTF-8\r\n");
        writer.print("Content-Length: " + file.length() + " \r\n");
        writer.print("\r\n");
        writer.flush();


    }

    public void writeAndFlush(File file) {

        try {
            byte[] fileData = readFileData(file, (int) file.length());
            outputStream.write(fileData, 0, (int) file.length());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private byte[] readFileData(File file, int fileLength) throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLength];

        try {
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }

        return fileData;
    }

    public String getContentType(String fileName) {

        if(fileName.endsWith("/")) return "text/html";
        if(fileName.endsWith(".jpg")) return "image/.jpg";
        if(fileName.endsWith(".png")) return "image/.png";

        return null;
    }


    public void closeStreams() {

        try {
            writer.close();
            reader.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openStreams() {

        try {
            writer = new PrintWriter(clientSocket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outputStream = new BufferedOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {

        WebServer webServer = new WebServer(9999);
        webServer.init();

    }
}

