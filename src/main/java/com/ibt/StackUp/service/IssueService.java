package com.ibt.StackUp.service;

import com.ibt.StackUp.entity.Issue;
import com.ibt.StackUp.entity.Sprint;

import java.util.List;

public interface IssueService {
    Issue createIssue(Issue issue);
    List<Issue> getAllIssues();
    Issue getIssue(Long id);
    Issue deleteIssue(Long id);
    Issue updateIssue(Issue issue);
    List<Issue> getChildsOf(Issue id);
    List<Issue> getIssuesBySprint(Long id);
}
