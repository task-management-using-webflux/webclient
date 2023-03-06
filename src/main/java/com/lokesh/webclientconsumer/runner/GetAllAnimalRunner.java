package com.lokesh.webclientconsumer.runner;

import com.lokesh.webclientconsumer.model.Animal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class GetAllAnimalRunner implements CommandLineRunner {
    private static final String baseUrl = "http://localhost:8081/api/v1/";

    @Override
    public void run(String... args) throws Exception{
        WebClient client = WebClient.create(baseUrl);
        Flux<Animal> animalFlux = client
                .get()
                .uri("/animal")
                .retrieve()
                .bodyToFlux(Animal.class);
        animalFlux.doOnNext(System.out::println).blockLast();
    }
}

