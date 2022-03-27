package com.example.demo.entity;

public enum TaskStatus {
    ToDo("ToDo"),
    InProgress("InProgress"),
    Done("Done");
    String description;

    TaskStatus(String description) {
        this.description = description;
    }
}