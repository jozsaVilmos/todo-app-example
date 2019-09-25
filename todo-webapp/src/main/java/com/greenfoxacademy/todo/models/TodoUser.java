package com.greenfoxacademy.todo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TodoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Todo> todos;

    public TodoUser() {
        this(null);
    }

    public TodoUser(String name) {
        this.name = name;
        this.todos = new ArrayList<>();
    }

    public TodoUser(String name, List<Todo> todos) {
        this.name = name;
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public void addTodo(Todo todo) {
        this.todos.add(todo);
        todo.setOwner(this);
    }

    public void removeTodo(Todo todo) {
        this.todos.remove(todo);
    }

}
