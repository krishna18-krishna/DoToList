package com.fssa.todolist.validator;

import com.fssa.todolist.exception.ValidationException;
import com.fssa.todolist.model.Task;

import java.time.LocalDate;

public class TaskValidator {
    public static void validation(Task task) throws ValidationException {
        if(task == null){
            throw new ValidationException("Task cannot be null");
        }
        if(task.getId() <= 0 ){
            throw new ValidationException("Id must be positive");
        }
        if(task.getName() == null || task.getName().trim().isEmpty()){
            throw  new ValidationException("Task name cannot be null or empty");
        }
        if(task.getDeadline() == null || task.getDeadline().isBefore(LocalDate.now())){
            throw new ValidationException("Deadline cannot be null or past");
        }
        if(task.getStatus() == null){
            throw new ValidationException("Status cannot be null");
        }
        if(task.getDescription() == null || task.getDescription().trim().isEmpty()){
            throw new ValidationException("Description cannot be null or empty");
        }
    }
}
