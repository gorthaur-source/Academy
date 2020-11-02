package org.academiadecodigo.tailormoons.webserver;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MimeType {

    private static final String DEFAULT_TYPE = "application/octet-stream";

    private static final List<String> IMAGE_EXTENSIONS = Arrays.asList("png", "jpg", "jpeg");
    private static final List<String> TEXT_EXTENSIONS = Arrays.asList("html", "css");

    public static String getFromFile(File file) {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

        if (IMAGE_EXTENSIONS.contains(extension)) {
            return "image/" + extension;
        }

        if (TEXT_EXTENSIONS.contains(extension)) {
            return "text/" + extension + "; charset=UTF-8";
        }
        if(fileName.endsWith(".js")) return "application/javascript";

        return DEFAULT_TYPE;
    }

}
