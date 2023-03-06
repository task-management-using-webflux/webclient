package com.lokesh.webclientconsumer.runner;

import com.lokesh.webclientconsumer.constants.UserConstants;
import com.lokesh.webclientconsumer.model.Task;
import com.lokesh.webclientconsumer.model.User;
import com.lokesh.webclientconsumer.model.UserTask;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static com.lokesh.webclientconsumer.constants.TaskConstants.BASE_URL;
import static com.lokesh.webclientconsumer.constants.UserConstants.GET_ALL_USERS;

@Component
public class GetAllUserTaskRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        WebClient userClient = WebClient.create(UserConstants.BASE_URL);
        WebClient taskClient = WebClient.create(BASE_URL);

        Flux<User> userFlux = userClient
                .get()
                .uri(GET_ALL_USERS)
                .retrieve()
                .bodyToFlux(User.class);

        Flux<Task> taskFlux = taskClient
                .get()
                .uri("/tasks")
                .retrieve()
                .bodyToFlux(Task.class);


        System.out.println(userFlux.zipWith(taskFlux));;
    }
}
