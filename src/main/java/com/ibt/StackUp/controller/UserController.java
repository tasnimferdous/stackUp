package com.ibt.StackUp.controller;

import com.ibt.StackUp.model.UserDto;
import com.ibt.StackUp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/stackUp/user")
public class UserController {
    private final UserService userService;
    @GetMapping(path = "/getAll")
    public List<UserDto> getUserList(){
        return userService.getUserList();
    }
}
