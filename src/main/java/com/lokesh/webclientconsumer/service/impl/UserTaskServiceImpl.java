package com.lokesh.webclientconsumer.service.impl;

import com.lokesh.webclientconsumer.model.Task;
import com.lokesh.webclientconsumer.model.User;
import com.lokesh.webclientconsumer.model.UserTask;
import com.lokesh.webclientconsumer.service.TaskService;
import com.lokesh.webclientconsumer.service.UserService;
import com.lokesh.webclientconsumer.service.UserTaskService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UserTaskServiceImpl implements UserTaskService {
    private UserService userService;
    private TaskService taskService;


    public UserTaskServiceImpl(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    public Flux<UserTask> getUserTasks() {
        Flux<User> users = userService.getAllUsers();
        System.out.println(users);
        Flux<Task> tasks = taskService.getTasks();

        return Flux.zip(users, tasks)
                .map(tuple -> new UserTask(tuple.getT1(), tuple.getT2()));
    }
}
