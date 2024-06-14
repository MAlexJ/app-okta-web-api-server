package com.malexj.handlers;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.malexj.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageHandler {

  private final MessageService messageService;

  @Cacheable
  public Mono<ServerResponse> getPublic(final ServerRequest request) {
    log.info("request path - {}", request.path());
    log.info("request path variables - {}", request.pathVariables());
    return messageService.makePublicMessage().flatMap(body -> ServerResponse.ok().bodyValue(body));
  }

  @Cacheable
  public Mono<ServerResponse> getProtected(final ServerRequest request) {
    return messageService.makeProtectedMessage().flatMap(ok()::bodyValue);
  }

  @Cacheable
  public Mono<ServerResponse> getAdmin(final ServerRequest request) {
    return messageService.makeAdminMessage().flatMap(ok()::bodyValue);
  }
}
