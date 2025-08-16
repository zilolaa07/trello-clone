package uz.pdp.dto.service;

import  jakarta.enterprise.context.ApplicationScoped;
import  jakarta.inject.Inject;
import uz.pdp.dto.mapper.TaskMapper;
import uz.pdp.dto.model.entity.Task;
import uz.pdp.dto.TaskCreateDto;
import uz.pdp.dto.TaskDto;
import uz.pdp.dto.TaskUpdateDto;
import uz.pdp.dto.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class TaskService {

    @Inject
    TaskRepository taskRepository;

    @Inject
    TaskMapper taskMapper;

    // CREATE
    public void create(TaskCreateDto dto) {
        Task task = taskMapper.fromCreateDto(dto);
        taskRepository.save(task);
    }

    // READ ALL
    public List<TaskDto> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    // READ BY ID
    public Optional<TaskDto> getById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDto);
    }

    // UPDATE
    public boolean update(TaskUpdateDto dto) {
        Optional<Task> optionalTask = taskRepository.findById(Long.valueOf(dto.getId()));
        if (optionalTask.isEmpty()) return false;

        Task task = taskMapper.fromUpdateDto(dto);
        taskRepository.update(task);
        return true;
    }

    // DELETE
    public boolean delete(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) return false;

        taskRepository.delete(id);
        return true;
    }
}

