package com.ibt.StackUp.service;

import com.ibt.StackUp.model.LoginRequest;
import com.ibt.StackUp.model.ResisterRequest;
import com.ibt.StackUp.response.MyResponse;

public interface AuthService {
    MyResponse register(ResisterRequest request);

    MyResponse authenticate(LoginRequest request);
}
