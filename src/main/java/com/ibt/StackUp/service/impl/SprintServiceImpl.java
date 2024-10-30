package com.ibt.StackUp.service.impl;

import com.ibt.StackUp.entity.Sprint;
import com.ibt.StackUp.repository.SprintRepository;
import com.ibt.StackUp.response.MyResponse;
import com.ibt.StackUp.service.SprintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        if(sprint.getName() ==null || sprint.getName().isEmpty()){
            throw new NullPointerException("Name can't be null or empty");
        }
        if(sprint.getStartDate() ==null || sprint.getStartDate().toString().isEmpty()){
            throw new NullPointerException("Start Date can't be null or empty");
        }
        if(sprint.getEndDate() ==null || sprint.getEndDate().toString().isEmpty()){
            throw new NullPointerException("End Date can't be null or empty");
        }

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
        if(sprint.getName() ==null || sprint.getName().isEmpty()){
            throw new NullPointerException("Name can't be null or empty");
        }
        if(sprint.getStartDate() ==null || sprint.getStartDate().toString().isEmpty()){
            throw new NullPointerException("Start Date can't be null or empty");
        }
        if(sprint.getEndDate() ==null || sprint.getEndDate().toString().isEmpty()){
            throw new NullPointerException("End Date can't be null or empty");
        }

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
    public Sprint getOne(Long id) {
        Sprint newSprint;

        try {
            newSprint = sprintRepository.findById(id).orElse(null);
            log.info(String.valueOf(newSprint));
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data.");
        }
        return newSprint;
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
