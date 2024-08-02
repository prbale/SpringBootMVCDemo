package com.example.userservice.repository;

import com.example.userservice.entity.Users;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Users create(Users user) {
        String query="insert into users(id, name, email) values(?,?,?)";
        int update = jdbcTemplate.update(query, user.getId(), user.getName(), user.getEmail());
        System.out.println(update + " rows affected");
        return user;
    }

    @Override
    public Users update(Users user, int userId) {
        return null;
    }

    @Override
    public void delete(int userId) {

    }

    @Override
    public List<Users> getAll() {
        return List.of();
    }

    @Override
    public Users get(int userId) {
        return null;
    }

    @Override
    public List<Users> search(String keyword) {
        return List.of();
    }
}
