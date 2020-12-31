package com.prac.recordsmanagerweb.services.impl;

import com.prac.recordsmanagerweb.config.BcryptGenerator;
import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.dto.UserDto;
import com.prac.recordsmanagerweb.entities.User;
import com.prac.recordsmanagerweb.exceptions.NotFoundException;
import com.prac.recordsmanagerweb.repositories.UserRepository;
import com.prac.recordsmanagerweb.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BcryptGenerator bcryptGenerator;

    @Override
    public ResponseEntity<Message>  createUser(UserDto userDto) {

        User user = new User();
        //user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(bcryptGenerator.generate(userDto.getPassword()));
        user.setUsertype(userDto.getUsertype());

        User savedUser = userRepository.save(user);
        String SuccessMsg = "User Created Successfully";
        String FailMsg = "An error occured while creating user";
        Message message = new Message();

        if (savedUser !=null){
            message.setMessage(SuccessMsg);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }
        else {
            message.setMessage(FailMsg);
            return  new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
        }
    }

    public User findUser(String username){
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null){
            throw new NotFoundException("User with username "+username+" does not exist");
        }
        return user;
    }

    public  User deleteUser(String username){
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null){
            throw new NotFoundException("User with username "+username+" does not exist");
        }else {
            userRepository.delete(user);
            return user;
        }
    }
}
