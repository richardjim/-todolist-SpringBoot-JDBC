package com.example.todolist.service;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        todoRepository.save(todo);
        return todo;
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id);
    }
}
