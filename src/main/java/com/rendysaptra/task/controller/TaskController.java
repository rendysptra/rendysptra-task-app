package com.rendysaptra.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rendysaptra.task.domain.CreateTaskRequest;
import com.rendysaptra.task.domain.dto.CreateTaskRequestDto;
import com.rendysaptra.task.domain.dto.TaskDto;
import com.rendysaptra.task.domain.entitty.Task;
import com.rendysaptra.task.mapper.TaskMapper;
import com.rendysaptra.task.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    public ResponseEntity<TaskDto> createTask(
        @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ) {
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto createdTaskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

}
