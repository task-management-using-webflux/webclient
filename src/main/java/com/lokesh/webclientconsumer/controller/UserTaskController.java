package com.lokesh.webclientconsumer.controller;

import com.lokesh.webclientconsumer.model.UserTask;
import com.lokesh.webclientconsumer.service.UserService;
import com.lokesh.webclientconsumer.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "usertask")
public class UserTaskController {


    //@GetMapping(value = "/{id}")
//    Mono<UserTask> findUserTaskByUserId(@PathVariable("id") String id) {
//        return userService.getUserAndTaskByUserId(id);
//    }
//    private WebClient userTaskWebClient = WebClient.create("http://localhost:8090");
//
//    Flux<UserTask> userTaskFlux = userTaskWebClient.get()
//            .uri("/user-task")
//            .retrieve()
//            .bodyToFlux(UserTask.class);

    private UserTaskService userTaskService;

    @GetMapping()
    Flux<UserTask> findAll() {
        return userTaskService.getUserTasks();
    }
}
