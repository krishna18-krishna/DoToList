package com.fssa.todolist.validator;

import com.fssa.todolist.exception.ValidationException;
import com.fssa.todolist.model.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskValidatorTest {
    @Test
    void ValidateNull(){
        Exception e = assertThrows(ValidationException.class, ()->{
            TaskValidator.validation(null);
        });
        assertEquals("Task cannot be null" , e.getMessage());
    }

    @Test
    void validate(){
        Task task = new Task(1, "JUnit Project " , LocalDate.now().plusDays(2) , Task.Status.COMPLETED , "My Project Completed");
        assertDoesNotThrow( () -> {
            TaskValidator.validation(task);
        });
    }

    @Test
    void validateId(){
        Task task = new Task(-1, "JUnit Project" , LocalDate.now().plusDays(2) , Task.Status.COMPLETED , "My Project Completed");
        Exception e = assertThrows(ValidationException.class , ()->{
            TaskValidator.validation(task);
        });
        assertEquals("Id must be positive" , e.getMessage());
    }

    @Test
    void validateName(){
        Task task = new Task(1, "" , LocalDate.now().plusDays(2) , Task.Status.COMPLETED , "My Project Completed");
        Exception e = assertThrows(ValidationException.class, () ->{
            TaskValidator.validation(task);
        });
        assertEquals("Task name cannot be null or empty" , e.getMessage());
    }

    @Test
    void validateDate(){
        Task task = new Task(1, "JUnit Project" , LocalDate.now().minusDays(2) , Task.Status.COMPLETED , "My Project Completed");
        Exception e = assertThrows(ValidationException.class , ()->{
            TaskValidator.validation(task);
        });
        assertEquals("Deadline cannot be null or past" , e.getMessage());
    }

    @Test
    void validateStatus(){
        Task task = new Task(1 , "JUnit Project" , LocalDate.now().plusDays(2) ,null, "My Project Completed");
        Exception e = assertThrows(ValidationException.class , ()->{
            TaskValidator.validation(task);
        });
        assertEquals("Status cannot be null" , e.getMessage());
    }

    @Test
    void validateDescription(){
        Task task = new Task(1 , "JUnit Project" , LocalDate.now().plusDays(2) , Task.Status.COMPLETED, "");
        Exception e = assertThrows(ValidationException.class , ()->{
            TaskValidator.validation(task);
        });
        assertEquals("Description cannot be null or empty" , e.getMessage());
    }
}