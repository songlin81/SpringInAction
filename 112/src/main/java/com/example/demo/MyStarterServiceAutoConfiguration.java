package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyStarterProperties.class)
@ConditionalOnClass(MyStarter.class)
@ConditionalOnProperty(prefix = "spring.mystarter", value = "enabled", matchIfMissing = true)
public class MyStarterServiceAutoConfiguration {
    @Autowired
    private MyStarterProperties myproperties;
    @Bean
    @ConditionalOnMissingBean(MyStarter.class)
    public MyStarter MyStarterService(){
        MyStarter myStarterService = new MyStarter(myproperties);
        return myStarterService;
    }
}