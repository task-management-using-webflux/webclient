package com.lokesh.webclientconsumer.controller;

import com.lokesh.webclientconsumer.model.Task;
import com.lokesh.webclientconsumer.model.User;
import com.lokesh.webclientconsumer.service.TaskService;
import com.lokesh.webclientconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public Mono<Tuple2<User, Object>> findUserAndTaskByUserId(@PathVariable("id") String userId) {
        // get user object with respective user task
        Mono<Tuple2<User, Object>> monoUser = this.getUserById(userId)
                .zipWhen(user -> {
                    Mono<Task> userTask = this.getTaskByEmailId(user.getEmailId());
                    return userTask;
                });
        return monoUser;
    }

    private Mono<Task> getTaskByEmailId(String emailId) {
        return taskService.findTaskByEmailId(emailId);
    }

    private Mono<User> getUserById(String userId) {
        return userService.getUserById(userId);
    }
}
