package com.example.Cache;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Config demo(){
        return new Config().setInstanceName("Hazalecast-cache")
                .addMapConfig(new MapConfig().setName("myemp"));
    }
}
