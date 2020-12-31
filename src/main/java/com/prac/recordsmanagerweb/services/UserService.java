package com.prac.recordsmanagerweb.services;

import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.dto.UserDto;
import com.prac.recordsmanagerweb.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Message> createUser(UserDto userDto);
    User findUser(String username);
    User deleteUser(String username);
}
