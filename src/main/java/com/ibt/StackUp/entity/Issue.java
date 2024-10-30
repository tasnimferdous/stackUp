package com.ibt.StackUp.entity;

import com.ibt.StackUp.Enum.IssueType;
import com.ibt.StackUp.Enum.ToDoType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    private String description;

    private IssueType issueType;

    private ToDoType toDoType;

    @ManyToOne
    private User assignedTo;

    @ManyToOne
    private User assignedBy;

    private int point;

    @ManyToOne
    @JoinColumn(name = "parent_issue_id")
    private Issue parentIssue;

    @ManyToOne
    private Board progressMap;

    @ManyToOne
    private Sprint sprint;

    @ManyToOne
    private Epic epic;
}
