package com.devslover.todolist.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devslover.todolist.model.TodoItem;
import com.devslover.todolist.repo.TodoRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value= "/todo")
public class TodoController {

	@Autowired
	private TodoRepo todoRepo;
	
	@GetMapping(value ="/all", produces = "application/json")
	public List<TodoItem> findAll() {
		return todoRepo.findAll();
	}
	
	@GetMapping(value="/find/{id}", produces = "application/json")
	public Optional<TodoItem> findById(@PathVariable Long id) {
		return todoRepo.findById(id);
	}
	
	@PostMapping(value="/add", produces = "application/json")
	public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem) {
		return todoRepo.save(todoItem);
	}
	
	@PutMapping(value="/update", produces = "application/json")
	public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem) {
		return todoRepo.save(todoItem);
	}
	
	//DeleteMapping(value = "/{id}")
	@DeleteMapping(value= "/delete/{id}", produces = "application/json")
	public void delete(@PathVariable Long id) {
		todoRepo.deleteById(id);
	}
}
