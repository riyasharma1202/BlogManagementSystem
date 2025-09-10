package com.ncu.blog.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;


@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
        
    }

    @Bean
    public RestClient commentRestClient() {
        return RestClient.builder()
            .baseUrl("http://localhost:9003/comments")
            .build();
    }

}
