package org.academiadecodigo.tailormoons.webserver.request;

import java.io.File;

public class Request {

    private String verb;
    private File resource;

    public Request(String verb, File resource) {
        this.verb = verb;
        this.resource = resource;
    }

    public String getVerb() {
        return verb;
    }

    public File getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return verb + " request for " + resource.getPath();
    }
}
