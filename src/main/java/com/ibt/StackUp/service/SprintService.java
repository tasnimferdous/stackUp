package com.ibt.StackUp.service;

import com.ibt.StackUp.entity.Sprint;
import com.ibt.StackUp.response.MyResponse;

import java.util.List;

public interface SprintService {
    MyResponse create(Sprint sprint);
    MyResponse update(Sprint sprint);
    MyResponse getOne(Long id);
    List<Sprint> getAll();
    MyResponse delete(Long id);
}
