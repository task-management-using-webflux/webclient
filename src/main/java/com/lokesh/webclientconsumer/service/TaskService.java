package com.lokesh.webclientconsumer.service;

import com.lokesh.webclientconsumer.model.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {
    Flux<Task> getTasks();

    Mono<Task> findTaskByEmailId(String emailId);

//    Task getTasksWithUser(String taskId);
}
