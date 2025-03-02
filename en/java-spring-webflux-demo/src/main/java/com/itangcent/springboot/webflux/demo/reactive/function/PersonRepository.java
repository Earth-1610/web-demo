/*
 * Copyright 2002-2016 the original author or authors.
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

/**
 * Person Information Repository Interface
 *
 * @author layker
 */
public interface PersonRepository {

    /**
     * Get person information by ID (synchronous way)
     *
     * @param id Person ID
     * @return Person information
     */
    Person getPerson(int id);

    /**
     * Get person information by ID (reactive way)
     *
     * @param id Person ID
     * @return Mono object containing person information
     */
    Mono<Person> getPerson2(int id);

    /**
     * Save person information (synchronous way)
     *
     * @param person Person information
     */
    void savePerson(Person person);

    /**
     * Save person information (reactive way)
     *
     * @param personMono Mono object containing person information
     * @return Save result
     */
    Mono<Void> savePerson2(Mono<Person> personMono);

    /**
     * Get all person information (synchronous way)
     *
     * @return List of person information
     */
    Iterable<Person> allPeople();

    /**
     * Get all person information (reactive way)
     *
     * @return Flux object containing person information
     */
    Flux<Person> allPeople2();

    Mono<Person> savePersonReturned2(Mono<Person> person);
}
