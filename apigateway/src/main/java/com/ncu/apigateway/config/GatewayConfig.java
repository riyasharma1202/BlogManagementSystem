package com.ncu.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder)
    {
        return builder.routes()
            .route("blogservice", r -> r.path("/blogs/**")
                .uri("lb://blogservice"))
            .route("commentservice", r -> r.path("/comments/**")
                .uri("lb://commentservice"))
            .build();
    }
}