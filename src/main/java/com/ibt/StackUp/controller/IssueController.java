package com.ibt.StackUp.controller;

import com.ibt.StackUp.entity.Issue;
import com.ibt.StackUp.entity.Sprint;
import com.ibt.StackUp.service.IssueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/stackUp/issue")
public class IssueController {
    private final IssueService issueService;
    @PostMapping(path = "/create")
    public Issue createNewIssue(@RequestBody Issue issue){
        return issueService.createIssue(issue);
    }

    @GetMapping(path = "/getAll")
    public List<Issue> getAllIssues(){
        return issueService.getAllIssues();
    }

    @GetMapping(path = "/get")
    public Issue getIssue(@RequestParam Long id){
        log.info("I'm Here");
        return issueService.getIssue(id);
    }

    @PutMapping(path = "/update")
    public Issue updateIssue(@RequestBody Issue issue){
        return issueService.updateIssue(issue);
    }

    @DeleteMapping(path = "/delete")
    public Issue deleteIssue(@RequestParam Long id){
        return issueService.deleteIssue(id);
    }

    @GetMapping(path = "/getChilds")
    public List<Issue> getChildsOf(@RequestParam Issue id){
        return issueService.getChildsOf(id);
    }

    @GetMapping(path = "/getBySprint")
    public List<Issue> getIssuesBySprint(@RequestParam Long id){
        return issueService.getIssuesBySprint(id);
    }
}
