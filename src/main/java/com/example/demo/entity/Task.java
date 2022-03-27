package com.example.demo.entity;

import com.example.demo.entity.id.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Task")
@Getter
@Setter
public class Task implements IdEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "task_id")
    @SequenceGenerator(name="task_id",allocationSize = 1,sequenceName = "task_id")
    @JsonIgnore
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="priority")
    private int priority;

    @Column(name="status")
    private TaskStatus status;

    @JsonIgnore
    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id",updatable = false,insertable = false)
    private Project project;

    @Column(name = "project_id")
    private Long projectId;
}
