package com.example.userservice.repository;

import com.example.userservice.entity.Users;

import java.util.List;

public interface UserDAO {

    // Save User
    Users create(Users user);

    // Update USer
    Users update(Users user, int userId);

    // Delete User
    void delete(int userId);

    // Get All Users
    List<Users> getAll();

    // Get Single User
    Users get(int userId);

    // Search User
    List<Users> search(String keyword);
}
