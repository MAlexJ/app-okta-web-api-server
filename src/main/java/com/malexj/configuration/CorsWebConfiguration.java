package com.malexj.configuration;

import com.malexj.properties.ClientApplicationProperties;
import java.time.Duration;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
public class CorsWebConfiguration {

  private final ClientApplicationProperties applicationProps;

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    final var source = new UrlBasedCorsConfigurationSource();
    final var config = new CorsConfiguration();
    final var origins = List.of(applicationProps.originUrl());
    final var headers = List.of(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE);
    final var methods = List.of(HttpMethod.GET.name());
    final var maxAge = Duration.ofSeconds(86400);

    config.setAllowedOrigins(origins);
    config.setAllowedHeaders(headers);
    config.setAllowedMethods(methods);
    config.setMaxAge(maxAge);

    source.registerCorsConfiguration("/**", config);
    return source;
  }

  @Bean
  public CorsWebFilter corsWebFilter() {
    final var configSource = this.corsConfigurationSource();

    return new CorsWebFilter(configSource);
  }
}
