package com.rendysaptra.task.service;

import com.rendysaptra.task.domain.CreateTaskRequest;
import com.rendysaptra.task.domain.entitty.Task;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

}
