package com.example.demo11111.model.dto;

import com.example.demo11111.model.ENUM.MALE;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto {

    private String name;

    private String username;

    private MALE male;

}
