package com.lokesh.webclientconsumer.runner;

import com.lokesh.webclientconsumer.model.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static com.lokesh.webclientconsumer.constants.TaskConstants.BASE_URL;

@Component
public class GetAllTaskRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        WebClient client = WebClient.create(BASE_URL);
        Flux<Task> taskFlux = client
                .get()
                .uri("/tasks")
                .retrieve()
                .bodyToFlux(Task.class);
        taskFlux.doOnNext(System.out::println).blockLast();
    }
}
