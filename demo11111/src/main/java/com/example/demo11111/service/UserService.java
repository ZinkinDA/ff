package com.example.demo11111.service;

import com.example.demo11111.model.ENUM.MALE;
import com.example.demo11111.model.User;
import com.example.demo11111.model.dto.UserDto;

import java.util.List;

public
interface UserService {

    List<User> getAllUser();
    UserDto findUserById(Integer id);
    UserDto findUserByUsername(String username);
    void addUser(String name, String username, MALE male);
    void addUser(User user);

}

