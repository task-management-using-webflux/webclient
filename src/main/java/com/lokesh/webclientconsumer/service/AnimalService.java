package com.lokesh.webclientconsumer.service;

import com.lokesh.webclientconsumer.model.Animal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AnimalService {
    Flux<Animal> getAnimals();

    Mono<Animal> findById(String id);

    Mono<Animal> save(Animal animal);
}
