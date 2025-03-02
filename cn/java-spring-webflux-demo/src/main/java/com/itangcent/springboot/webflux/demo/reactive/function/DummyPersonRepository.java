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
 * 人员信息仓储的模拟实现类
 * 用于测试和演示，数据存储在内存中
 */
public class DummyPersonRepository implements PersonRepository {

    /**
     * 内存中存储人员信息的Map
     */
    private final Map<Integer, Person> people = new HashMap<>();

    /**
     * 构造函数
     * 初始化一些测试数据
     */
    public DummyPersonRepository() {
        this.people.put(1, new Person("John Doe", 42));
        this.people.put(2, new Person("Jane Doe", 36));
    }

    /**
     * 获取指定ID的人员信息（响应式方式）
     * 
     * @param id 人员ID
     * @return 包含人员信息的Mono对象
     */
    @Override
    public Mono<Person> getPerson2(int id) {
        return Mono.justOrEmpty(this.people.get(id));
    }

    /**
     * 获取所有人员信息（响应式方式）
     * 
     * @return 包含所有人员信息的Flux对象
     */
    @Override
    public Flux<Person> allPeople2() {
        return Flux.fromIterable(this.people.values());
    }

    /**
     * 保存人员信息（响应式方式）
     * 
     * @param personMono 包含人员信息的Mono对象
     * @return 保存操作的完成信号
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
     * 保存人员信息并返回保存的对象（响应式方式）
     * 
     * @param personMono 包含人员信息的Mono对象
     * @return 保存后的人员信息
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
     * 获取指定ID的人员信息（同步方式）
     * 
     * @param id 人员ID
     * @return 人员信息
     */
    @Override
    public Person getPerson(int id) {
        return this.people.get(id);
    }

    /**
     * 获取所有人员信息（同步方式）
     * 
     * @return 人员信息列表
     */
    @Override
    public List<Person> allPeople() {
        return new ArrayList<>(this.people.values());
    }

    /**
     * 保存人员信息（同步方式）
     * 
     * @param p 人员信息
     */
    @Override
    public void savePerson(Person p) {
        int id = people.size() + 1;
        people.put(id, p);
        System.out.format("Saved %s with id %d%n", p, id);
    }
}
