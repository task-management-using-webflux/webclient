package com.lokesh.webclientconsumer.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.lokesh.webclientconsumer.constants.TaskConstants;
import com.lokesh.webclientconsumer.model.Task;
import com.lokesh.webclientconsumer.model.User;
import com.lokesh.webclientconsumer.model.UserTask;
import com.lokesh.webclientconsumer.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.lokesh.webclientconsumer.constants.UserConstants.BASE_URL;
import static com.lokesh.webclientconsumer.constants.UserConstants.GET_ALL_USERS;

@Service
public class UserServiceImpl implements UserService {
    private WebClient userClient = WebClient.create(BASE_URL);

    private WebClient taskClient = WebClient.create(TaskConstants.BASE_URL);
    public Flux<User> getAllUsers() {
        return userClient.get()
                .uri(GET_ALL_USERS)
                .retrieve()
                .bodyToFlux(User.class);
    }

    @Override
    public Mono<User> getUserById(String id) {

        return userClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }

//    @Override
//    public Mono<User> getUserAndTaskByUserId(String id) {
//        Mono<User> userMono = userClient.get().uri("/{id}").retrieve().bodyToMono(User.class);
//
////        Mono<Task> taskMono = taskClient.get().uri("/{emailId}").retrieve().bodyToMono(Task.class);
//        Mono<Task> taskMono = taskClient.getTas
//        UserTask userTask = new UserTask();
//        BeanUtils.copyProperties();
//    }
}
