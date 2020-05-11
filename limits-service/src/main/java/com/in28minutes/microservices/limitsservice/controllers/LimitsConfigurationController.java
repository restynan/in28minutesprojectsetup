package com.in28minutes.microservices.limitsservice.controllers;

import com.in28minutes.microservices.limitsservice.configurations.Configuration;
import com.in28minutes.microservices.limitsservice.models.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
@EnableDiscoveryClient
public class LimitsConfigurationController {
    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsConfiguration()
    {
        return new LimitsConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }

}
