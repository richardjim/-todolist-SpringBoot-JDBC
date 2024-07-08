package com.example.todolist.repository;

import com.example.todolist.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> findAll() {
        String sql = "SELECT * FROM todos";
        return jdbcTemplate.query(sql, new TodoRowMapper());
    }

    public Todo findById(Long id) {
        String sql = "SELECT * FROM todos WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TodoRowMapper());
    }

    public int save(Todo todo) {
        String sql = "INSERT INTO todos (title, description, completed) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, todo.getTitle(), todo.getDescription(), todo.isCompleted());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM todos WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

class TodoRowMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setId(rs.getLong("id"));
        todo.setTitle(rs.getString("title"));
        todo.setDescription(rs.getString("description"));
        todo.setCompleted(rs.getBoolean("completed"));
        return todo;
    }
}
