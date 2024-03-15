package com.example.JDBCCRUDAPIEXAMPLE.service;

import com.example.JDBCCRUDAPIEXAMPLE.models.Todo;
import com.example.JDBCCRUDAPIEXAMPLE.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    // Constructor

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public int createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public int updateTodo(Long id, Todo todo) {
        todo.setUserId(id);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
