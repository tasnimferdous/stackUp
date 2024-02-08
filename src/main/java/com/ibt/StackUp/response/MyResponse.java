package com.ibt.StackUp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MyResponse {
    public boolean hasError;
    public String content;
    public String message;
}
