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
 * 人员信息仓储接口
 *
 * @author layker
 */
public interface PersonRepository {

    /**
     * 获取指定ID的人员信息（同步方式）
     *
     * @param id 人员ID
     * @return 人员信息
     */
    Person getPerson(int id);

    /**
     * 获取指定ID的人员信息（响应式方式）
     *
     * @param id 人员ID
     * @return 人员信息Mono对象
     */
    Mono<Person> getPerson2(int id);

    /**
     * 保存人员信息（同步方式）
     *
     * @param person 人员信息
     */
    void savePerson(Person person);

    /**
     * 保存人员信息（响应式方式）
     *
     * @param personMono 人员信息Mono对象
     * @return 保存结果
     */
    Mono<Void> savePerson2(Mono<Person> personMono);

    /**
     * 获取所有人员信息（同步方式）
     *
     * @return 人员信息列表
     */
    Iterable<Person> allPeople();

    /**
     * 获取所有人员信息（响应式方式）
     *
     * @return 人员信息Flux对象
     */
    Flux<Person> allPeople2();

    Mono<Person> savePersonReturned2(Mono<Person> person);
}
