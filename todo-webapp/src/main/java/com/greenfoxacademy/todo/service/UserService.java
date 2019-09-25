package com.greenfoxacademy.todo.service;

import com.greenfoxacademy.todo.models.ErrorMessage;
import com.greenfoxacademy.todo.models.TodoUser;

public interface UserService {

    TodoUser login(TodoUser user);
    TodoUser login(String username);
    ErrorMessage validate(TodoUser user);
    TodoUser findUser(Long id);
    TodoUser update(TodoUser user);

}
