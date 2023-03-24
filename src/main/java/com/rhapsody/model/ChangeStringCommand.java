package com.rhapsody.model;

public class ChangeStringCommand {
    private final String id;
    private final String newValue;

    public ChangeStringCommand(String id, String newValue) {
        this.id = id;
        this.newValue = newValue;
    }

    public String getId() {
        return id;
    }

    public String getNewValue() {
        return newValue;
    }
}
