package com.ibt.StackUp.controller;

import com.ibt.StackUp.entity.Epic;
import com.ibt.StackUp.entity.Sprint;
import com.ibt.StackUp.response.MyResponse;
import com.ibt.StackUp.service.EpicService;
import com.ibt.StackUp.service.SprintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "stackUp/epic")
@Slf4j
@RequiredArgsConstructor
public class EpicController {
    private final EpicService epicService;

    @PostMapping(path = "/create")
    public MyResponse create(@RequestBody Epic epic){
        MyResponse response = epicService.createEpic(epic);
        return response;
    }
    @PutMapping(path = "/update")
    public MyResponse update(@RequestBody Epic epic){
        MyResponse response = epicService.updateEpic(epic);
        return response;
    }
    @GetMapping(path = "/get")
    public MyResponse getEpic(@RequestParam Long id){
        MyResponse response = epicService.getEpic(id);
        return response;
    }
    @GetMapping(path = "/getAll")
    public List<Epic> getAll(){
        return epicService.getAllEpic();
    }
    @DeleteMapping(path = "/delete")
    public MyResponse deleteEpic(@RequestParam Long id){
        MyResponse response = epicService.deleteEpic(id);
        return response;
    }
}
