package com.fssa.todolist.model;

import java.time.LocalDate;

public class Task {

    private int id;
    private String name;
    private LocalDate deadline;
    private Status status;
    private String description;

    public enum Status{
        COMPLETED, INPROGRESS,CREATED, HALTED
    }

    public Task(int id , String name , LocalDate deadline ,Status status ,String description){
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
