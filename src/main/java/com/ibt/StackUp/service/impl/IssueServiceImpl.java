package com.ibt.StackUp.service.impl;

import com.ibt.StackUp.entity.*;
import com.ibt.StackUp.repository.*;
import com.ibt.StackUp.service.IssueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final EpicRepository epicRepository;
    private final SprintRepository sprintRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    @Override
    public Issue createIssue(Issue issue) {
        Issue newIssue;
        Sprint sprint = null;
        Epic epic = null;
        Issue parentIssue = null;
        Board progressMap = null;
        User assignedTo = null;
        User assignedBy = null;
        try {

            if(issue.getSprint() != null &&  sprintRepository.findById(issue.getSprint().getId()).isPresent()) {
                sprint = sprintRepository.findById(issue.getSprint().getId()).get();
            }
            if(issue.getEpic() != null &&  epicRepository.findById(issue.getEpic().getId()).isPresent()) {
                epic = epicRepository.findById(issue.getEpic().getId()).get();
            }
            if(issue.getParentIssue() != null &&  issueRepository.findById(issue.getParentIssue().getId()).isPresent()) {
                parentIssue = issueRepository.findById(issue.getParentIssue().getId()).get();
            }
            if(issue.getProgressMap() != null &&  boardRepository.findById(issue.getProgressMap().getId()).isPresent()) {
                progressMap = boardRepository.findById(issue.getProgressMap().getId()).get();
            }
            if(issue.getAssignedTo() != null &&  userRepository.findById(issue.getAssignedTo().getId()).isPresent()) {
                assignedTo = userRepository.findById(issue.getAssignedTo().getId()).get();
            }
            if(issue.getAssignedBy() != null &&  userRepository.findById(issue.getAssignedBy().getId()).isPresent()) {
                assignedBy = userRepository.findById(issue.getAssignedBy().getId()).get();
            }

            issue.setEpic(epic);
            issue.setParentIssue(parentIssue);
            issue.setSprint(sprint);
            issue.setProgressMap(progressMap);
            issue.setAssignedTo(assignedTo);
            issue.setAssignedBy(assignedBy);
            newIssue = issueRepository.save(issue);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to create new issue.");
        }
        return newIssue;
    }

    @Override
    public List<Issue> getAllIssues() {
        List<Issue> issueList = null;
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
        Issue issue = null;
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
        Sprint sprint = null;
        Epic epic = null;
        Issue parentIssue = null;
        Board progressMap = null;
        User assignedTo = null;
        User assignedBy = null;
        try {

            if(issue.getSprint() != null &&  sprintRepository.findById(issue.getSprint().getId()).isPresent()) {
                sprint = sprintRepository.findById(issue.getSprint().getId()).get();
            }
            if(issue.getEpic() != null &&  epicRepository.findById(issue.getEpic().getId()).isPresent()) {
                epic = epicRepository.findById(issue.getEpic().getId()).get();
            }
            if(issue.getParentIssue() != null &&  issueRepository.findById(issue.getParentIssue().getId()).isPresent()) {
                parentIssue = issueRepository.findById(issue.getParentIssue().getId()).get();
            }
            if(issue.getProgressMap() != null &&  boardRepository.findById(issue.getProgressMap().getId()).isPresent()) {
                progressMap = boardRepository.findById(issue.getProgressMap().getId()).get();
            }
            if(issue.getAssignedTo() != null &&  userRepository.findById(issue.getAssignedTo().getId()).isPresent()) {
                assignedTo = userRepository.findById(issue.getAssignedTo().getId()).get();
            }
            if(issue.getAssignedBy() != null &&  userRepository.findById(issue.getAssignedBy().getId()).isPresent()) {
                assignedBy = userRepository.findById(issue.getAssignedBy().getId()).get();
            }

            issue.setEpic(epic);
            issue.setParentIssue(parentIssue);
            issue.setSprint(sprint);
            issue.setProgressMap(progressMap);
            issue.setAssignedTo(assignedTo);
            issue.setAssignedBy(assignedBy);
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
    public List<Issue> getIssuesBySprint(Long id) {
        List<Issue> issueList;
        try {
            Sprint sprint = sprintRepository.findById(id).orElse(null);
            if(sprint == null){
                log.info("Sprint Not Found");
                return Collections.emptyList();
            }
            issueList = issueRepository.findAllBySprint(sprint);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data");
        }
        if (issueList == null || issueList.isEmpty()) {
            log.info("Empty Sprint");
            return Collections.emptyList();
        }
        return issueList;
    }

    @Override
    public List<Issue> getIssuesByUser(Long id) {
        List<Issue> issueList;
        try {
            User user = userRepository.findById(id).orElse(null);
            if(user == null){
                log.info("User Not Found");
                return Collections.emptyList();
            }
            issueList = issueRepository.findAllByAssignedTo(user);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve data");
        }
        if (issueList == null || issueList.isEmpty()) {
            log.info("No Issue Found For The User");
            return Collections.emptyList();
        }
        return issueList;
    }
}
