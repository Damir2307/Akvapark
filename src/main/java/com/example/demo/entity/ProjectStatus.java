package com.example.demo.entity;
public enum ProjectStatus{
        NOT_STARTED("NotStarted"),
        ACTIVE("Active"),
        COMPLETED("Completed");
        String description;
        ProjectStatus(String description){
            this.description=description;
        }

}
