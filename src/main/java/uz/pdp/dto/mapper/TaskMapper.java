package uz.pdp.dto.mapper;

import uz.pdp.dto.TaskCreateDto;
import uz.pdp.dto.TaskDto;
import uz.pdp.dto.TaskUpdateDto;
import uz.pdp.dto.model.entity.Task;

public class TaskMapper {

    public Task fromCreateDto(TaskCreateDto dto) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setSortOrder(dto.getSortOrder());
        task.setWorkspaceId(dto.getWorkspaceId());
        return task;
    }

    public Task fromUpdateDto(TaskUpdateDto dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setSortOrder(dto.getSortOrder());
        task.setWorkspaceId(dto.getWorkspaceId());
        return task;
    }

    public TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId((task.getId()));
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setSortOrder(task.getSortOrder());
        dto.setWorkspaceId(task.getWorkspaceId());
        return dto;
    }
}

