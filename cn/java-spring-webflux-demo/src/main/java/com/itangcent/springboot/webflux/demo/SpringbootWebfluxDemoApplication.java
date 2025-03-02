package com.itangcent.springboot.webflux.demo;

import com.itangcent.springboot.webflux.demo.reactive.function.DummyPersonRepository;
import com.itangcent.springboot.webflux.demo.reactive.function.PersonHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Spring WebFlux 示例应用程序入口类
 */
@SpringBootApplication
public class SpringbootWebfluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebfluxDemoApplication.class, args);
    }

    /**
     * 配置人员处理器Bean
     * @return PersonHandler实例
     */
    @Bean
    public PersonHandler personHandler() {
        return new PersonHandler(new DummyPersonRepository());
    }

    /**
     * 配置路由函数
     * 通过函数式编程方式定义HTTP接口路由
     * 
     * @param personHandler 人员处理器
     * @return 路由函数
     */
    @Bean
    public RouterFunction<ServerResponse> routingFunction(PersonHandler personHandler) {
        return nest(path("/person"),
                nest(accept(APPLICATION_JSON),
                        route(GET("/{id}"), personHandler::getPerson)
                                .andRoute(method(HttpMethod.GET), personHandler::listPeople)
                ).andRoute(POST("/").and(contentType(APPLICATION_JSON)), personHandler::createPerson));
    }
}
