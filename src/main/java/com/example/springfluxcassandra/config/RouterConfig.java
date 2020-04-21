package com.example.springfluxcassandra.config;

import com.example.springfluxcassandra.service.RouterHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class RouterConfig {

    @Bean
    RouterFunction routerFunction(RouterHandler routerHandler){
        return RouterFunctions.route(RequestPredicates.GET("/student/all"), routerHandler::getAll)
                .andRoute(RequestPredicates.GET("/student/id/{id}"), routerHandler::getById)
                .andRoute(RequestPredicates.GET("/student/after/{id}"),routerHandler::getAfterId);
    }
}
