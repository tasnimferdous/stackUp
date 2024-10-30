package com.ibt.StackUp.service.impl;

import com.ibt.StackUp.Enum.Role;
import com.ibt.StackUp.model.LoginRequest;
import com.ibt.StackUp.model.ResisterRequest;
import com.ibt.StackUp.entity.User;
import com.ibt.StackUp.repository.UserRepository;
import com.ibt.StackUp.response.AuthResponse;
import com.ibt.StackUp.response.MyResponse;
import com.ibt.StackUp.service.AuthService;
import com.ibt.StackUp.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public MyResponse register(ResisterRequest request) {
        if(request.getUserName().isEmpty() || request.getPassword().isEmpty()){
            return MyResponse.builder()
                    .hasError(true)
                    .message("Please, Provide Username and Password")
                    .build();
        }
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        try {
            userRepository.save(user);
            AuthResponse authResponse = new AuthResponse();
            authResponse.setToken(jwtService.generateToken(user));
            return MyResponse.builder()
                    .hasError(false)
                    .content(authResponse.toString())
                    .message("User Registration Done Successfully")
                    .build();
        }catch (Exception e){
            log.info("Failed To Create User");
            e.printStackTrace();
        }
        return MyResponse.builder()
                .hasError(true)
                .message("Please, Try Again..")
                .build();
    }

    @Override
    public MyResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(()->new RuntimeException("Wrong Credentials"));
        try {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setToken(jwtService.generateToken(user));
            return MyResponse.builder()
                    .hasError(false)
                    .content(authResponse)
                    .message("User Logged In Successfully")
                    .build();
        }catch (Exception e){
            log.info("Failed To Generate Token");
            e.printStackTrace();
        }
        return MyResponse.builder()
                .hasError(true)
                .message("Please, Try Again..")
                .build();
    }
}
