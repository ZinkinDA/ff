package com.example.demo11111.model;

import com.example.demo11111.model.ENUM.MALE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {

    private List<User> friends;

    private Integer id;

    private String name;

    private String username;

    private MALE male;

}
