package com.greenfoxacademy.todo.service;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.models.TodoUser;
import com.greenfoxacademy.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private UserService userService;
    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(UserService userService, TodoRepository todoRepository) {
        this.userService = userService;
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoUser addTodo(Long userId, Todo newTodo) {
        TodoUser user = userService.findUser(userId);
        user.addTodo(newTodo.initialze());
        userService.update(user);
        return user;
    }

    @Override
    public TodoUser deleteTodo(Long userId, Long todoId) {
        todoRepository.deleteById(todoId);
        return userService.findUser(userId);
    }

    @Override
    public TodoUser editTodo(Long userId, Todo newTodo) {
        TodoUser user = userService.findUser(userId);
        Todo todo = todoRepository.findById(newTodo.getId()).get();

        todo.setOwner(user);
        if (newTodo.getTitle() != null && !newTodo.getTitle().isEmpty()) {
            todo.setTitle(newTodo.getTitle());
        }
        if (newTodo.isDone() != null) {
            todo.setDone(newTodo.isDone());
        }
        todoRepository.save(todo);
        return user;
    }

    @Override
    public Todo switchTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).get();
        todo.setDone(!todo.isDone());
        return todoRepository.save(todo);
    }

    @Override
    public Todo findTodo(Long id) {
        return todoRepository.findById(id).get();
    }

}
