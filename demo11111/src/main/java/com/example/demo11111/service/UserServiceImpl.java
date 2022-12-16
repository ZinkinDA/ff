package com.example.demo11111.service;

import com.example.demo11111.model.ENUM.MALE;
import com.example.demo11111.model.User;
import com.example.demo11111.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private Integer ID = 0;
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUser() {

        List<User> usersCopy = users;

        return usersCopy;
    }

    @Override
    public UserDto findUserById(Integer id) {

        Optional<User> user = users.stream().filter(x->x.getId() == id).findFirst();

        if(user.isPresent()){
            UserDto userDto = UserDto.builder()
                    .name(user.get().getName())
                    .username(user.get().getUsername())
                    .male(user.get().getMale())
                    .build();
            return userDto;
        }
        return null;
    }

    @Override
    public UserDto findUserByUsername(String username) {
        Optional<User> user = users.stream().filter(x->x.getUsername() == username).findFirst();

        if(user.isPresent()){
            UserDto userDto = UserDto.builder()
                    .name(user.get().getName())
                    .username(user.get().getUsername())
                    .male(user.get().getMale())
                    .build();
            return userDto;
        }
        return null;
    }

    /** Надо созщдать узкоспециализированый интерфейс для админа **/

    @Override
    public void addUser(String name, String username, MALE male) {
        User user = User.builder()
                .id(++ID)
                .male(male)
                .name(name)
                .username(username)
                .friends(new ArrayList<>())
                .build();
        users.add(user);
    }
    @Override
    public void addUser(User user) {
        user.setId(++ID);
        user.setFriends(new ArrayList<>());
        users.add(user);
    }
}
