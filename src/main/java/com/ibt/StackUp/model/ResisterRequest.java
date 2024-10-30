package com.ibt.StackUp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResisterRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
}
