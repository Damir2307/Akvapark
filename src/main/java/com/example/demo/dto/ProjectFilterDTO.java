package com.example.demo.dto;

import com.example.demo.entity.ProjectStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectFilterDTO {
    private String name;

    private LocalDateTime startDate;

    //project completion date
    private LocalDateTime complDate;

    private ProjectStatus status;

    private int priority;

    private String sort;
}
