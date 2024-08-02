package com.example.userservice.mapper;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(Users user);
    Users userDTOToUser(UserDTO userDTO);
}
