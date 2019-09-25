package com.greenfoxacademy.todo.models.exceptions;

public class NameIsRequired extends Exception {

    private String message;

    public NameIsRequired(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
