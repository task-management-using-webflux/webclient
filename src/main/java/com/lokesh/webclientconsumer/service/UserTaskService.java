package com.lokesh.webclientconsumer.service;

import com.lokesh.webclientconsumer.model.UserTask;
import reactor.core.publisher.Flux;

public interface UserTaskService {
    Flux<UserTask> getUserTasks();
}
