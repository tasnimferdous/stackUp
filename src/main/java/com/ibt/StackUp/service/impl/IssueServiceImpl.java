package com.ibt.StackUp.service.impl;

import com.ibt.StackUp.entity.Issue;
import com.ibt.StackUp.entity.Sprint;
import com.ibt.StackUp.repository.IssueRepository;
import com.ibt.StackUp.service.IssueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    @Override
    public Issue createIssue(Issue issue) {
        Issue newIssue;
        try {
            newIssue = issueRepository.save(issue);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to create new issue.");
        }
        return newIssue;
    }

    @Override
    public List<Issue> getAllIssues() {
        List<Issue> issueList;
        try{
            issueList = issueRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data.");
        }

        return issueList;
    }

    @Override
    public Issue getIssue(Long id) {
        Issue issue;
        try{
            issue = issueRepository.findById(id).orElse(null);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data.");
        }

        return issue;
    }

    @Override
    public Issue deleteIssue(Long id) {
        try{
            issueRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to delete issue.");
        }
        return null;
    }

    @Override
    public Issue updateIssue(Issue issue) {
        Issue newIssue;
        try {
            newIssue = issueRepository.save(issue);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to update the issue.");
        }
        return newIssue;
    }

    @Override
    public List<Issue> getChildsOf(Issue id) {
        List<Issue> issueList;
        try {
            issueList = issueRepository.findAllByParentIssue(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data");
        }
        return issueList;
    }

    @Override
    public List<Issue> getIssuesBySprint(Sprint id) {
        List<Issue> issueList;
        try {
            issueList = issueRepository.findAllBySprint(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data");
        }
        return issueList;
    }
}
