## Spring WebFlux/Java

* Java 21
* Springboot 3.3.0
* Gradle 8.8

Spring WebFlux API servers authorization using Auth0

info: https://developer.auth0.com/resources/code-samples/full-stack/hello-world/basic-access-control/spa/react-javascript/spring-webflux-java

### Springboot project setup

create .env file with properties:

```
SERVER_PORT=6060
SERVER_OKTA_OAUTH2_ISSUER=https://..../
SERVER_OKTA_OAUTH2_AUDIENCE=https://.......
CLIENT_ORIGIN_URL=http://localhost:4040
```

### Auth0 Set Up

info .....

### Maybe - Safely handle exceptions

https://github.com/JoseLion/maybe

Maybe<T> is a monadic wrapper similar to java.util.Optional, but with a different intention. By leveraging Optional<T>
benefits, it provides a functional API that safely allows to work with operations that throw checked (and unchecked)
exceptions.

### Gradle plugin for sonarlint code analysis.

https://plugins.gradle.org/plugin/se.solrike.sonarlint

### Checkstyle is a development tool to help programmers write Java code that adheres to a coding standard.

info: https://checkstyle.org/index.html

setup IDE:

* install plugin Checkstyle
  This plugin provides both real-time and scanning of Java files with Checkstyle from within IDEA
* config plugin, set path to checkstyle.xml file
* config refactor and auto import inside IDE: Editor >> Code Styler >> Java >> import checkstyle.xml

### Load environment variables from a .env file.

https://github.com/cdimascio/dotenv-java

### Using dotenv files with Spring Boot

https://stackoverflow.com/questions/58549361/using-dotenv-files-with-spring-boot

### Spring Actuator

* [Spring Boot Actuator: Health check, Auditing, Metrics gathering and Monitoring](https://www.callicoder.com/spring-boot-actuator/#:~:text=You%20can%20enable%20or%20disable,the%20identifier%20for%20the%20endpoint)

Endpoint ID Description:

* info - Displays information about your application.
* health - Displays your application’s health status.

Enable info and health endpoint in *.yaml file

```
management:
  endpoints:
    web:
      exposure:
        include: health,info
```

Actuator endpoints:

* /actuator
* /actuator/health
* /actuator/info

### Gradle Versions Plugin

Displays a report of the project dependencies that are up-to-date, exceed the latest version found, have upgrades, or
failed to be resolved, info: https://github.com/ben-manes/gradle-versions-plugin

command:

```
gradle dependencyUpdates
```

### Github action

issue:  ./gradlew: Permission denied
link: https://stackoverflow.com/questions/17668265/gradlew-permission-denied

You need to update the execution permission for gradlew

1. add action workflow

2. Locally pull changes

3. run Git command:

```
git update-index --chmod=+x gradlew
git add .
git commit -m "Changing permission of gradlew"
git push
```

### Hosting Springboot app

Render is a cloud platform that offers a variety of services for developers, including hosting for web applications,
databases, and static sites. Render aims to simplify the process of deploying and scaling applications by providing a
user-friendly interface and seamless integration with popular development tools.

Deploy for Free - https://render.com/ <br>
You can deploy instances of some Render services <br>
link: https://docs.render.com/free

Deploying a Spring Boot Application with Docker Image on Render <br>
tutorial: https://medium.com/@nithinsudarsan/deploying-a-spring-boot-application-with-docker-image-on-render-com-9a87f5ce5f72

### UptimeRobot: Monitor anything

UptimeRobot is a website monitoring service that checks the status of your websites, servers, and other online services
at regular intervals. It notifies you if any of your monitored services go down, helping you to quickly address any
issues and minimize downtime.

link: https://uptimerobot.com/ <br>

### Spring log level

link: https://medium.com/codex/spring-boot-logging-da61911ce8e6

```
logging:
  level:
    root: ${SERVER_ROOT_LOG_LEVEL:INFO}
    org.springframework: ${SERVER_SPRING_LOG_LEVEL:INFO}
```