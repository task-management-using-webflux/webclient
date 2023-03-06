package com.lokesh.webclientconsumer.runner;

import com.lokesh.webclientconsumer.constants.UserConstants;
import com.lokesh.webclientconsumer.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static com.lokesh.webclientconsumer.constants.UserConstants.GET_ALL_USERS;

@Component
public class GetAllUserRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        WebClient client = WebClient.create(UserConstants.BASE_URL);
        Flux<User> userFlux = client
                .get()
                .uri(GET_ALL_USERS)
                .retrieve()
                .bodyToFlux(User.class);
        userFlux.doOnNext(System.out::println).blockLast();
    }
}
