package com.greenfoxacademy.todo.service;

import com.greenfoxacademy.todo.models.ErrorMessage;
import com.greenfoxacademy.todo.models.TodoUser;
import com.greenfoxacademy.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public TodoUser login(TodoUser user) {
        return login(user.getName());
    }

    @Override
    public TodoUser login(String username) {
        Optional<TodoUser> dbUser = userRepository.findByName(username);
        if (dbUser.isPresent()) {
            return dbUser.get();
        } else {
            return userRepository.save(new TodoUser(username));
        }
    }

    @Override
    public ErrorMessage validate(TodoUser user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            return new ErrorMessage("Missing parameter: name.");
        } else {
            return null;
        }
    }

    @Override
    public TodoUser findUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public TodoUser update(TodoUser user) {
        return userRepository.save(user);
    }

}
