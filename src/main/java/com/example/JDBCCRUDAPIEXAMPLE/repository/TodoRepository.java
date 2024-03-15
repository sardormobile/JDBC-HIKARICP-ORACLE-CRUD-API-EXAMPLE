package com.example.JDBCCRUDAPIEXAMPLE.repository;

import com.example.JDBCCRUDAPIEXAMPLE.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TodoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Todo> findAll() {
        String sql = "SELECT * FROM todos";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Todo.class));
    }

    public Todo findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM todos WHERE userId = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Todo.class));
    }

    public int save(Todo todo) {
        String sql = "INSERT INTO todos(title, description, done) VALUES (?, ?, ?)";
        // Insert
        return jdbcTemplate.update(sql, todo.getTitle(), todo.getDescription(), todo.isDone() ? 1 : 0);
//        if (todo.getId() == null) {
//            String sql = "INSERT INTO todos(title, description, done) VALUES (?, ?, ?)";
//            // Insert
//            jdbcTemplate.update(sql,
//                    todo.getTitle(), todo.getDescription(), todo.isDone() ? 1 : 0);
//        } else {
//            String sql = "UPDATE todos SET title = ?, description = ?, done = ? WHERE id = ?";
//            // Update
//            jdbcTemplate.update(sql,
//                    todo.getTitle(), todo.getDescription(), todo.isDone() ? 1 : 0, todo.getId());
//        }
//        return todo;
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM todos WHERE userId = ?";
        jdbcTemplate.update(sql, id);
    }
}
