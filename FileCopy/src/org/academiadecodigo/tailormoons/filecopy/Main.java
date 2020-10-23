package org.academiadecodigo.tailormoons.filecopy;

import java.io.*;

public class Main {

    public static void main(String[] args) {


        try (
                FileInputStream inputStream = new FileInputStream("Untitled.rtf");
                FileOutputStream outputStream = new FileOutputStream("untitledCopy.rtf", true)
            )
        {

            byte[] buffer = new byte[1024];
            int snake;

            while ((snake = inputStream.read(buffer)) > 0) {
                System.out.println("I have read this many bytes: " + snake);
                outputStream.write(buffer, 0, snake);
            }
        } catch (IOException e) {
            System.out.println("IO Exception launched. File not found");
        }
    }

}


