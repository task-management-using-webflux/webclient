package com.lokesh.webclientconsumer.service.impl;

import com.lokesh.webclientconsumer.constants.TaskConstants;
import com.lokesh.webclientconsumer.constants.UserConstants;
import com.lokesh.webclientconsumer.model.Task;
import com.lokesh.webclientconsumer.model.User;
import com.lokesh.webclientconsumer.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.lokesh.webclientconsumer.constants.TaskConstants.BASE_URL;


@Service
public class TaskServiceImpl implements TaskService {

    private WebClient taskClient = WebClient.create(TaskConstants.BASE_URL);

    private WebClient userClient = WebClient.create(UserConstants.BASE_URL);
    public Flux<Task> getTasks() {
        return taskClient.get()
                .uri("/tasks")
                .retrieve()
                .bodyToFlux(Task.class);
    }
    public Mono<Task> findTaskByEmailId(String emailId) {
        return taskClient.get()
                .uri("/{emailId}", emailId)
                .retrieve()
                .bodyToMono(Task.class);
    }

//    @Override
//    public Task getTasksWithUser(String taskId) {
//
//        Task task = taskClient.get()
//                .uri("/{id}", taskId)
//                .retrieve()
//                .bodyToMono(Task.class)
//                .block();
//
//        User user = userClient.get()
//                .uri("/users/{id}", task.getUserId())
//                .retrieve()
//                .bodyToMono(User.class)
//                .block();
//
//        task.setUser(user);
//        return task;
//    }
}
