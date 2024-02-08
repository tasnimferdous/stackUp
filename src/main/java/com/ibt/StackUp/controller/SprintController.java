package com.ibt.StackUp.controller;

import com.ibt.StackUp.entity.Sprint;
import com.ibt.StackUp.response.MyResponse;
import com.ibt.StackUp.service.SprintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/stackUp/sprint")
public class SprintController {

    private final SprintService sprintService;

    @PostMapping(path = "/create")
    public MyResponse create(@RequestBody Sprint sprint){
        MyResponse response = sprintService.create(sprint);
        return response;
    }
    @PutMapping(path = "/update")
    public MyResponse update(@RequestBody Sprint sprint){
        MyResponse response = sprintService.update(sprint);
        return response;
    }
    @GetMapping(path = "/get")
    public MyResponse getOne(@RequestParam Long id){
        MyResponse response = sprintService.getOne(id);
        return response;
    }
    @GetMapping(path = "/getAll")
    public List<Sprint> getAll(){
        return sprintService.getAll();
    }
    @DeleteMapping(path = "/delete")
    public MyResponse delete(@RequestParam Long id){
        return sprintService.delete(id);
    }
}
