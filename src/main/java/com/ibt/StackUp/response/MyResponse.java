package com.ibt.StackUp.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MyResponse<T> {
    public boolean hasError;
    public T content;
    public String message;
}
