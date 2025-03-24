package com.fssa.todolist.test;

import com.fssa.todolist.exception.ValidationException;
import com.fssa.todolist.model.Task;
import com.fssa.todolist.validator.TaskValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class TestTaskValidator {
        @Test
        void ValidateNull(){
            Exception error = assertThrows(ValidationException.class, ()->{
                TaskValidator.validation(null);
            });
            assertEquals("Task cannot be null" , error.getMessage());
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
            Exception error = assertThrows(ValidationException.class , ()->{
                TaskValidator.validation(task);
            });
            assertEquals("Id must be positive" , error.getMessage());
        }

        @Test
        void validateName(){
            Task task = new Task(1, "" , LocalDate.now().plusDays(2) , Task.Status.COMPLETED , "My Project Completed");
            Exception error = assertThrows(ValidationException.class, () ->{
                TaskValidator.validation(task);
            });
            assertEquals("Task name cannot be null or empty" , error.getMessage());
        }

        @Test
        void validateDate(){
            Task task = new Task(1, "JUnit Project" , LocalDate.now().minusDays(2) , Task.Status.COMPLETED , "My Project Completed");
            Exception error = assertThrows(ValidationException.class , ()->{
                TaskValidator.validation(task);
            });
            assertEquals("Deadline cannot be null or past" , error.getMessage());
        }

        @Test
        void validateStatus(){
            Task task = new Task(1 , "JUnit Project" , LocalDate.now().plusDays(2) ,null, "My Project Completed");
            Exception error = assertThrows(ValidationException.class , ()->{
                TaskValidator.validation(task);
            });
            assertEquals("Status cannot be null" , error.getMessage());
        }

        @Test
        void validateDescription(){
            Task task = new Task(1 , "JUnit Project" , LocalDate.now().plusDays(2) , Task.Status.COMPLETED, "");
            Exception error = assertThrows(ValidationException.class , ()->{
                TaskValidator.validation(task);
            });
            assertEquals("Description cannot be null or empty" , error.getMessage());
        }
}
