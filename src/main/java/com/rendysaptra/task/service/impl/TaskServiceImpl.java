package com.rendysaptra.task.service.impl;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rendysaptra.task.domain.CreateTaskRequest;
import com.rendysaptra.task.domain.entitty.Task;
import com.rendysaptra.task.domain.entitty.TaskStatus;
import com.rendysaptra.task.repository.TaskRepository;
import com.rendysaptra.task.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now = Instant.now();

        Task task = new Task(
            null,
            request.title(),
            request.description(),
            request.dueDate(),
            TaskStatus.OPEN,
            request.priority(),
            now,
            now
        );
        return taskRepository.save(task);
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

}
