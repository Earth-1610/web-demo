package com.itangcent.springboot.webflux.demo.controller;

import com.itangcent.common.dto.Result;
import com.itangcent.springboot.webflux.demo.reactive.function.Person;
import com.itangcent.springboot.webflux.demo.reactive.function.PersonHandler;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * WebFlux Reactive Controller
 * Demonstrates basic usage of reactive programming
 */
@RestController
@RequestMapping("restful")
public class FluxController {

    /**
     * Person information handler
     */
    private final PersonHandler personHandler;

    /**
     * Constructor
     * 
     * @param personHandler Person information handler
     */
    public FluxController(PersonHandler personHandler) {
        this.personHandler = personHandler;
    }

    /**
     * Empty Response Example
     * Demonstrates basic usage of Mono
     * 
     * @return Empty response result
     */
    @GetMapping("/")
    public Mono<Result<String>> empty() {
        return Mono.just(Result.success(null));
    }

    /**
     * Single String Response Example
     * Demonstrates wrapping a single value with Mono
     * 
     * @return Response result containing a string
     */
    @GetMapping("/single")
    public Mono<Result<String>> single() {
        return Mono.just(Result.success("single"));
    }

    /**
     * Create Person Information
     * Demonstrates reactive handling of POST requests
     * 
     * @param person Person information
     * @return Creation result
     */
    @PostMapping("/person")
    public Mono<Result<Void>> create(@RequestBody Person person) {
        return this.personHandler.createPerson(person)
                .then(Mono.just(Result.success(null)));
    }

    /**
     * Get All Person List
     * Demonstrates basic usage of Flux
     * 
     * @return Stream of person list
     */
    @GetMapping("/person")
    public Flux<Person> list() {
        return this.personHandler.listPeople();
    }

    /**
     * Get Person Information by ID
     * Demonstrates reactive handling with path parameters
     * 
     * @param id Person ID
     * @return Person information
     */
    @GetMapping("/person/{id}")
    public Mono<Result<Person>> findById(@PathVariable int id) {
        return this.personHandler.getPerson(id)
                .map(Result::success)
                .defaultIfEmpty(Result.error(404, "Person not found"));
    }

    /**
     * Test Error Response
     * Demonstrates reactive error handling
     * 
     * @return Error response
     */
    @GetMapping("/error")
    public Mono<Result<Person>> error() {
        return Mono.error(new RuntimeException("Test error response"));
    }
}
