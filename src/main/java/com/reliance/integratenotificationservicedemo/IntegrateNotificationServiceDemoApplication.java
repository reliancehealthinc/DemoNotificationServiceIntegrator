package com.reliance.integratenotificationservicedemo;

import com.reliance.integratenotificationservicedemo.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ApplicationProperties.class })
public class IntegrateNotificationServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrateNotificationServiceDemoApplication.class, args);
    }

}
