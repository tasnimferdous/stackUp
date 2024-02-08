package com.ibt.StackUp.service;

import com.ibt.StackUp.entity.Epic;
import com.ibt.StackUp.response.MyResponse;

import java.util.List;

public interface EpicService {
    MyResponse createEpic(Epic epic);
    MyResponse updateEpic(Epic epic);
    MyResponse deleteEpic(long id);
    MyResponse getEpic(long id);
    List<Epic> getAllEpic();
}
