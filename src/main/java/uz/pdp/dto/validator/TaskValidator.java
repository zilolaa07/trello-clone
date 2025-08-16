package uz.pdp.dto.validator;


import uz.pdp.dto.TaskDto;

public class TaskValidator {
    public void validate(TaskDto taskDTO) {
        if (taskDTO.getName() == null || taskDTO.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be empty");
        }
        //if (taskDTO.getBoardId() == null) {
            throw new IllegalArgumentException("Board ID cannot be null");
        }
        // Boshqa validatsiya qoidalari
    }

