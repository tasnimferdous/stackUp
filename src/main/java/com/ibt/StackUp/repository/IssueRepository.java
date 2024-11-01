package com.ibt.StackUp.repository;

import com.ibt.StackUp.entity.Issue;
import com.ibt.StackUp.entity.Sprint;
import com.ibt.StackUp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue,Long> {
    List<Issue> findAllByParentIssue(Issue id);
    List<Issue> findAllBySprint(Sprint id);
    List<Issue> findAllByAssignedTo(User user);
}
