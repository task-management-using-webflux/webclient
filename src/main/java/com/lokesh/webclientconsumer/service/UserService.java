package com.lokesh.webclientconsumer.service;

import com.lokesh.webclientconsumer.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> getAllUsers();

//    Mono<User> getUserAndTaskByUserId(String id);
    Mono<User> getUserById(String id);
}
