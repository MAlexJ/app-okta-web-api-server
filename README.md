## Spring WebFlux/Java

Spring WebFlux API servers authorization using Auth0

info: https://developer.auth0.com/resources/code-samples/full-stack/hello-world/basic-access-control/spa/react-javascript/spring-webflux-java

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