package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.Users;

import java.util.List;

// Interface for UserService for demonstrating loose coupling.
public interface UserService {
    public List<Users> getAllUsers();
    public UserDTO getUserById(Long id);
    public UserDTO saveUser(UserDTO userDTO);
    public void deleteUser(Long userId);
}
