package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public Iterable<Todo> getTodos() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteById(id);
    }
}
