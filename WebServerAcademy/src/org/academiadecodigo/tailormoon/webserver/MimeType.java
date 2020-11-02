package org.academiadecodigo.tailormoon.webserver;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class MimeType {

    private static final String DEFAULT_TYPE = "application/octet-stream";

    private static final List<String> IMAGE_EXTENSIONS = Arrays.asList("png", "jpg", "jpeg");
    private static final List<String> TEXT_EXTENSIONS = Arrays.asList("html", "css");
    private static final List<String> APPLICATION_EXTENSIONS = Arrays.asList("js", "xhtml+xml");

    public static String getMime(File file) {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

        if (IMAGE_EXTENSIONS.contains(extension)) {
            return "image/" + extension;
        }

        if (TEXT_EXTENSIONS.contains(extension)) {
            return "text/" + extension + "; charset=UTF-8";
        }
        if (APPLICATION_EXTENSIONS.contains(extension)) {
            return "application/" + extension;
        }

        return DEFAULT_TYPE;
    }

}
