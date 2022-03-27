package com.example.demo.entity;

import com.example.demo.entity.id.IdEntity;
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
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="priority")
    private int priority;

    @Column(name="status")
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "project_id",referencedColumnName = "id",updatable = false)
    private Project project;
}
