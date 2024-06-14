package com.malexj.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "client")
public record ClientApplicationProperties(String originUrl) {}
