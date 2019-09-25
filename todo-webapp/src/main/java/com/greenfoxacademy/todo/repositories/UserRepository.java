package com.greenfoxacademy.todo.repositories;

import com.greenfoxacademy.todo.models.TodoUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<TodoUser, Long> {

    Optional<TodoUser> findByName(String name);

}
