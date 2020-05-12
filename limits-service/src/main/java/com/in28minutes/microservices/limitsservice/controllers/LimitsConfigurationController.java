package com.in28minutes.microservices.limitsservice.controllers;

import com.in28minutes.microservices.limitsservice.configurations.Configuration;
import com.in28minutes.microservices.limitsservice.models.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//
//http://localhost:8081/actuator/refresh
@RestController
@RefreshScope
@EnableDiscoveryClient
public class LimitsConfigurationController {
    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsConfiguration()
    {
        return new LimitsConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }

///using hystrix

    @GetMapping("/fault-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitsConfiguration retrieveConfiguration()
    {
        throw new RuntimeException("Not available");
    }
    public LimitsConfiguration fallbackRetrieveConfiguration()
    {
     return new LimitsConfiguration(38,90);
    }
}
