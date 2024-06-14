package com.malexj;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import static java.util.Arrays.stream;

@Slf4j
@SpringBootApplication
@ConfigurationPropertiesScan
public class AppOktaWebApiServerApplication {

    enum DotEnv {
        SERVER_PORT, CLIENT_ORIGIN_URL, SERVER_OKTA_OAUTH2_ISSUER, SERVER_OKTA_OAUTH2_AUDIENCE
    }

    public static void main(String[] args) {
        dotEnvSafeCheck();
        SpringApplication.run(AppOktaWebApiServerApplication.class, args);
    }


    private static void dotEnvSafeCheck() {
        final var dotenv = Dotenv.configure().ignoreIfMissing().load();
        stream(DotEnv.values()).map(DotEnv::name).filter(varName -> dotenv.get(varName, "").isEmpty()).findFirst().ifPresent(varName -> {
            log.error("[Fatal] Missing or empty environment variable: {}", varName);
            System.exit(1);
        });
    }

}
