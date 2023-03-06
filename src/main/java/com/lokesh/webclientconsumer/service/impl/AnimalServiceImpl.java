package com.lokesh.webclientconsumer.service.impl;

import com.lokesh.webclientconsumer.model.Animal;
import com.lokesh.webclientconsumer.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.lokesh.webclientconsumer.constants.AnimalConstants.*;

@Slf4j
@Service
public class AnimalServiceImpl implements AnimalService {
    private WebClient client = WebClient.create(BASE_URL);

    public Flux<Animal> getAnimals() {
        return client.get()
                .uri(GET_ALL_ANIMALS)
                .retrieve()
                .bodyToFlux(Animal.class);
    }

    @Override
    public Mono<Animal> findById(String id) {
        try {
            return client.get()
                    .uri(GET_ANIMAL_BYID, id)
                    .retrieve()
                    .bodyToMono(Animal.class);
        } catch (WebClientResponseException wcre) {
            log.error("Error response code is { } and response body is { }", wcre.getRawStatusCode(), wcre.getResponseBodyAsString());
            log.error("Exception in method retrieveAllInvoices()", wcre);
            throw wcre;
        } catch (Exception ex) {
            log.error("Exception find in findById() method.");
            throw ex;
        }
    }

    @Override
    public Mono<Animal> save(Animal animal) {
        return client.post()
                .uri("/animal")
                .retrieve()
                .bodyToMono(Animal.class);
    }
}
