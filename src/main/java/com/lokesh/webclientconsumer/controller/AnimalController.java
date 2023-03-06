package com.lokesh.webclientconsumer.controller;

import com.lokesh.webclientconsumer.model.Animal;
import com.lokesh.webclientconsumer.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Animal> getAnimal() {
        return animalService.getAnimals();
    }

    @GetMapping(value = "/{id}")
    public Mono<Animal> findById(@PathVariable("id") String id) {
        try{
            return animalService.findById(id);
        } catch (Exception e) {
            log.error("Exception find in findById() method.");
            throw e;
        }
    }
    @PostMapping(MediaType.APPLICATION_JSON_VALUE)
    public Mono<Animal> postAnimal(@RequestBody Animal animal) {
        return this.animalService.save(animal);
    }
}
