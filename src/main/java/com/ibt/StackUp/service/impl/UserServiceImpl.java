package com.ibt.StackUp.service.impl;

import com.ibt.StackUp.entity.User;
import com.ibt.StackUp.model.UserDto;
import com.ibt.StackUp.repository.UserRepository;
import com.ibt.StackUp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<UserDto> getUserList() {
        List<UserDto> userList = null;
        try{
            userList = userRepository.findAll().stream().map(user -> new UserDto(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getRole()
            )).collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data.");
        }

        return userList;
    }
}
