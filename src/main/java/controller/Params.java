package controller;

import view.response.RequestedTypes;

public class Params {
    private String name;
    private RequestedTypes requestedTypes;

    public Params(String name, RequestedTypes requestedTypes) {
        this.name = name;
        this.requestedTypes = requestedTypes;
    }

    public String getName() {
        return name;
    }

    public RequestedTypes getRequestedTypes() {
        return requestedTypes;
    }

}
