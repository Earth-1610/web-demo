/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.itangcent.springboot.webflux.demo.reactive.function;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * Person Information Handler
 * Handles all HTTP requests related to person information
 */
public class PersonHandler {

    /**
     * Person information repository interface
     */
    private final PersonRepository repository;

    /**
     * Constructor
     * 
     * @param repository Person information repository instance
     */
    public PersonHandler(PersonRepository repository) {
        this.repository = repository;
    }

    /**
     * Get person information by ID
     * 
     * @param request HTTP request
     * @return Person information response
     */
    public Mono<ServerResponse> getPerson(ServerRequest request) {
        int personId = Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Person> personMono = this.repository.getPerson2(personId);
        return personMono
                .flatMap(person -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                .switchIfEmpty(notFound);
    }

    /**
     * Create new person information
     * 
     * @param request HTTP request
     * @return Creation result response
     */
    public Mono<ServerResponse> createPerson(ServerRequest request) {
        Mono<Person> person = request.bodyToMono(Person.class);
        return ServerResponse.ok().build(this.repository.savePerson2(person));
    }

    /**
     * Get list of all person information
     * 
     * @param request HTTP request
     * @return Person list response
     */
    public Mono<ServerResponse> listPeople(ServerRequest request) {
        Flux<Person> people = this.repository.allPeople2();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Person.class);
    }

    /**
     * Get person information by ID (simplified version)
     * 
     * @param personId Person ID
     * @return Person information
     */
    public Mono<Person> getPerson(int personId) {
        return Mono.justOrEmpty(this.repository.getPerson(personId));
    }

    /**
     * Create new person information (simplified version)
     * 
     * @param person Person information
     * @return Creation result
     */
    public Mono<Void> createPerson(Person person) {
        return Mono.justOrEmpty(person).doOnNext(repository::savePerson).thenEmpty(Mono.empty());
    }

    /**
     * Get list of all person information (simplified version)
     * 
     * @return Person list
     */
    public Flux<Person> listPeople() {
        return Flux.fromIterable(this.repository.allPeople());
    }

}
