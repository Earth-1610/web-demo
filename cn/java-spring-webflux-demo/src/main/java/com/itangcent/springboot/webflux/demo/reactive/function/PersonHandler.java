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
 * 人员信息处理器
 * 处理所有与人员相关的HTTP请求
 */
public class PersonHandler {

    /**
     * 人员信息仓储接口
     */
    private final PersonRepository repository;

    /**
     * 构造函数
     * 
     * @param repository 人员信息仓储实例
     */
    public PersonHandler(PersonRepository repository) {
        this.repository = repository;
    }

    /**
     * 获取指定ID的人员信息
     * 
     * @param request HTTP请求
     * @return 人员信息响应
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
     * 创建新的人员信息
     * 
     * @param request HTTP请求
     * @return 创建结果响应
     */
    public Mono<ServerResponse> createPerson(ServerRequest request) {
        Mono<Person> person = request.bodyToMono(Person.class);
        return ServerResponse.ok().build(this.repository.savePerson2(person));
    }

    /**
     * 获取所有人员信息列表
     * 
     * @param request HTTP请求
     * @return 人员列表响应
     */
    public Mono<ServerResponse> listPeople(ServerRequest request) {
        Flux<Person> people = this.repository.allPeople2();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Person.class);
    }

    /**
     * 获取指定ID的人员信息（简化版）
     * 
     * @param personId 人员ID
     * @return 人员信息
     */
    public Mono<Person> getPerson(int personId) {
        return Mono.justOrEmpty(this.repository.getPerson(personId));
    }

    /**
     * 创建新的人员信息（简化版）
     * 
     * @param person 人员信息
     * @return 创建结果
     */
    public Mono<Void> createPerson(Person person) {
        return Mono.justOrEmpty(person).doOnNext(repository::savePerson).thenEmpty(Mono.empty());
    }

    /**
     * 获取所有人员信息列表（简化版）
     * 
     * @return 人员列表
     */
    public Flux<Person> listPeople() {
        return Flux.fromIterable(this.repository.allPeople());
    }

}
