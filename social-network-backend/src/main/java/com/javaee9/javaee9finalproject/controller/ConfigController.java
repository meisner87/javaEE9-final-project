package com.javaee9.javaee9finalproject.controller;

import com.javaee9.javaee9finalproject.dto.InitialConfig;
import com.javaee9.javaee9finalproject.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/config")
@CrossOrigin("http://localhost:4200")
//https://developer.mozilla.org/en-US/docs/Web/Security/Same-origin_policy
public class ConfigController {
    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping()
    public InitialConfig provideInitialConfig() {
        log.info("provide initial config was called");

        return configService.getInitialConfig();
    }
}