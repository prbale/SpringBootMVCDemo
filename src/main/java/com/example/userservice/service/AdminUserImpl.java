package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.Users;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> getAllUsers() {
        System.out.println("----> Admin User - Calling getAllUsers() ");
        return userRepository.findAll();
    }

    @Override
    public UserDTO getUserById(Long id) {
        Users user = userRepository.findById(id).orElse(null);
        return userMapper.userToUserDTO(user);

    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        Users user = userMapper.userDTOToUser(userDTO);
        user = userRepository.save(user);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
