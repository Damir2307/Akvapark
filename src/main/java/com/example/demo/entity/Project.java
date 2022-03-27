package com.example.demo.entity;

import com.example.demo.entity.id.IdEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="Project")
@Getter
@Setter
public class Project implements IdEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "project_id")
    @SequenceGenerator(name="project_id",allocationSize = 1,sequenceName = "project_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="start_date")
    private LocalDateTime start_date;

    //project completion date
    @Column(name="compl_date")
    private LocalDateTime compl_date;

    @Column(name="status")
    private ProjectStatus status;

    @Column(name="priority")
    private int priority;


}
