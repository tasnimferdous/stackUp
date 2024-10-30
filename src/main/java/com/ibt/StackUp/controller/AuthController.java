package com.ibt.StackUp.controller;

import com.ibt.StackUp.model.LoginRequest;
import com.ibt.StackUp.model.ResisterRequest;
import com.ibt.StackUp.response.MyResponse;
import com.ibt.StackUp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stackUp/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public MyResponse register(@RequestBody ResisterRequest request){
        return authService.register(request);
    }

    @PostMapping("/login")
    public MyResponse register(@RequestBody LoginRequest request){
        return authService.authenticate(request);
    }
}
