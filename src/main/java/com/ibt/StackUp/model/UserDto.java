package com.ibt.StackUp.model;

import com.ibt.StackUp.Enum.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
