package com.devslover.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devslover.todolist.model.TodoItem;

public interface TodoRepo extends JpaRepository<TodoItem, Long> {

	
}
