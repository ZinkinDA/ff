package com.example.demo11111.Component;

import com.example.demo11111.model.ENUM.MALE;
import com.example.demo11111.model.User;
import com.example.demo11111.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitData {
    private final UserService userService;
    @Autowired
    public InitData(UserService userService) {
        this.userService = userService;

        User user = User.builder()
                .name("Alexey")
                .username("LamaPanda1108")
                .male(MALE.Male)
                .build();

        userService.addUser(user);
    }

}
