package com.gridgain.training.spring.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.springframework.boot.autoconfigure.IgniteConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteConfig {

    @Bean
    public IgniteConfigurer configurer() {
        return igniteConfiguration -> {
            igniteConfiguration.setClientMode(true);
        };
    }

}

