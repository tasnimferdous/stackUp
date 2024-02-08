package com.ibt.StackUp.service.impl;

import com.ibt.StackUp.entity.Epic;
import com.ibt.StackUp.repository.EpicRepository;
import com.ibt.StackUp.response.MyResponse;
import com.ibt.StackUp.service.EpicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class EpicServiceImpl implements EpicService {
    private final EpicRepository epicRepository;

    @Override
    public MyResponse createEpic(Epic epic) {
        Epic newEpic = null;
        String message = "Success";
        boolean err = false;

        try {
            newEpic = epicRepository.save(epic);
        }catch (Exception e){
            e.printStackTrace();
            err = true;
            message = "Failed to create new epic";
        }

        return MyResponse.builder()
                .hasError(err)
                .message(message)
                .content(newEpic.toString())
                .build();
    }

    @Override
    public MyResponse updateEpic(Epic epic) {
        Epic newEpic = null;
        String message = "Success";
        boolean err = false;

        try {
            newEpic = epicRepository.save(epic);
        }catch (Exception e){
            e.printStackTrace();
            err = true;
            message = "Failed to update the epic";
        }

        return MyResponse.builder()
                .hasError(err)
                .message(message)
                .content(newEpic.toString())
                .build();
    }

    @Override
    public MyResponse deleteEpic(long id) {
        String message = "Success";
        boolean err = false;

        try {
            epicRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            err = true;
            message = "Failed to delete the epic";
        }

        return MyResponse.builder()
                .hasError(err)
                .message(message)
                .build();
    }

    @Override
    public MyResponse getEpic(long id) {
        Epic newEpic = null;
        String message = "Success";
        boolean err = false;

        try {
            newEpic = epicRepository.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
            err = true;
            message = "Failed to retrieve the data";
        }

        return MyResponse.builder()
                .hasError(err)
                .message(message)
                .content(newEpic.toString())
                .build();
    }

    @Override
    public List<Epic> getAllEpic() {
        return epicRepository.findAll();
    }
}
