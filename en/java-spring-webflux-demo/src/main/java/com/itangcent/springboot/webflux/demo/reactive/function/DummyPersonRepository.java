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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mock Implementation of Person Information Repository
 * Used for testing and demonstration, data stored in memory
 */
public class DummyPersonRepository implements PersonRepository {

    /**
     * Map storing person information in memory
     */
    private final Map<Integer, Person> people = new HashMap<>();

    /**
     * Constructor
     * Initializes some test data
     */
    public DummyPersonRepository() {
        this.people.put(1, new Person("John Doe", 42));
        this.people.put(2, new Person("Jane Doe", 36));
    }

    /**
     * Get person information by ID (reactive way)
     * 
     * @param id Person ID
     * @return Mono object containing person information
     */
    @Override
    public Mono<Person> getPerson2(int id) {
        return Mono.justOrEmpty(this.people.get(id));
    }

    /**
     * Get all person information (reactive way)
     * 
     * @return Flux object containing all person information
     */
    @Override
    public Flux<Person> allPeople2() {
        return Flux.fromIterable(this.people.values());
    }

    /**
     * Save person information (reactive way)
     * 
     * @param personMono Mono object containing person information
     * @return Completion signal for save operation
     */
    @Override
    public Mono<Void> savePerson2(Mono<Person> personMono) {
        Mono<Void> voidMono = personMono.doOnNext(person -> {
            System.out.println("1:" + LocalTime.now().toString());
            int id = people.size() + 1;
            people.put(id, person);
            System.out.format("Saved %s with id %d%n", person, id);
        }).then(Mono.empty());
        System.out.println("2:" + LocalTime.now().toString());
        return voidMono;
    }

    /**
     * Save person information and return saved object (reactive way)
     * 
     * @param personMono Mono object containing person information
     * @return Saved person information
     */
    @Override
    public Mono<Person> savePersonReturned2(Mono<Person> personMono) {
        Mono voidMono = personMono.doOnNext(person -> {
            System.out.println("1:" + LocalTime.now().toString());
            int id = people.size() + 1;
            people.put(id, person);
            System.out.format("Saved %s with id %d%n", person, id);
        }).then(personMono);
        System.out.println("2:" + LocalTime.now().toString());
        return voidMono;
    }

    /**
     * Get person information by ID (synchronous way)
     * 
     * @param id Person ID
     * @return Person information
     */
    @Override
    public Person getPerson(int id) {
        return this.people.get(id);
    }

    /**
     * Get all person information (synchronous way)
     * 
     * @return List of person information
     */
    @Override
    public List<Person> allPeople() {
        return new ArrayList<>(this.people.values());
    }

    /**
     * Save person information (synchronous way)
     * 
     * @param p Person information
     */
    @Override
    public void savePerson(Person p) {
        int id = people.size() + 1;
        people.put(id, p);
        System.out.format("Saved %s with id %d%n", p, id);
    }
}
