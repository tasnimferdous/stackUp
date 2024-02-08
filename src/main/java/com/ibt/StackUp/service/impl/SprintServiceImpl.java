package com.ibt.StackUp.service.impl;

import com.ibt.StackUp.entity.Sprint;
import com.ibt.StackUp.repository.SprintRepository;
import com.ibt.StackUp.response.MyResponse;
import com.ibt.StackUp.service.SprintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SprintServiceImpl implements SprintService {

    private final SprintRepository sprintRepository;

    @Override
    public MyResponse create(Sprint sprint) {
        Sprint newSprint = null;
        String message = "Success";
        boolean err = false;

        try {
            newSprint = sprintRepository.save(sprint);
        }catch (Exception e){
            e.printStackTrace();
            err = true;
            message = "Failed to create new sprint";
        }

        return MyResponse.builder()
                .hasError(err)
                .message(message)
                .content(newSprint.toString())
                .build();
    }

    @Override
    public MyResponse update(Sprint sprint) {
        Sprint newSprint = null;
        String message = "Success";
        boolean err = false;

        try {
            newSprint = sprintRepository.save(sprint);
        }catch (Exception e){
            e.printStackTrace();
            err = true;
            message = "Failed to update the sprint";
        }

        return MyResponse.builder()
                .hasError(err)
                .message(message)
                .content(newSprint.toString())
                .build();
    }

    @Override
    public MyResponse getOne(Long id) {
        Sprint newSprint = null;
        String message = "Success";
        boolean err = false;

        try {
            newSprint = sprintRepository.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
            err = true;
            message = "Failed to retrieve data";
        }

        return MyResponse.builder()
                .hasError(err)
                .message(message)
                .content(newSprint.toString())
                .build();
    }

    @Override
    public List<Sprint> getAll() {
        return sprintRepository.findAll();
    }

    @Override
    public MyResponse delete(Long id) {
        String message = "Success";
        boolean err = false;

        try {
            sprintRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            err = true;
            message = "Failed to delete the sprint";
        }

        return MyResponse.builder()
                .hasError(err)
                .message(message)
                .build();
    }
}
