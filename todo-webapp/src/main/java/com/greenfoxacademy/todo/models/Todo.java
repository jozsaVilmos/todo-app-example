package com.greenfoxacademy.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean isDone;
    @JsonIgnore
    @ManyToOne
    private TodoUser owner;

    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
        this.isDone = false;
    }

    public Todo initialze() {
        if (this.isDone == null) {
            this.isDone = false;
        }
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isDone() {
        return isDone;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setIsDone(boolean done) {
        isDone = done;
    }

    public TodoUser getOwner() {
        return owner;
    }

    public void setOwner(TodoUser owner) {
        this.owner = owner;
    }
}
