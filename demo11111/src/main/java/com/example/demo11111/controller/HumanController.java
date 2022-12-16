package com.example.demo11111.controller;

import com.example.demo11111.model.User;
import com.example.demo11111.model.dto.UserDto;
import com.example.demo11111.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HumanController {

    private final UserService userService;

    @Autowired
    public HumanController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{message}")
    public ResponseEntity<?> getMessage(@PathVariable String message){
        if(message.equals("HUI")){
            return ResponseEntity.badRequest().body("BAD MESSAGE");
        }
        return ResponseEntity.ok().body(message);
    }


    @GetMapping("user/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id){
        UserDto user = userService.findUserById(id);
        if(user == null){
            return ResponseEntity.badRequest().body("Такого id не существует");
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("users")
    public ResponseEntity<?> getUser(){
        List<User> users = userService.getAllUser();
        if(users.isEmpty()){
            return ResponseEntity.badRequest().body("Пользователей пока нет");
        }
        return ResponseEntity.ok().body(users);
    }

}
