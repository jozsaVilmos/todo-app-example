package com.greenfoxacademy.todo.service;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.models.TodoUser;

public interface TodoService {

    TodoUser addTodo(Long userId, Todo newTodo);
    TodoUser deleteTodo(Long userId, Long todoId);
    TodoUser editTodo(Long userId, Todo newTodo);
    Todo switchTodo(Long todoId);
    Todo findTodo(Long id);
}
