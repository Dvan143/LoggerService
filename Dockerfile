FROM openjdk:26-ea-9-jdk-bookworm

COPY target/BankAppLoggingService-0.0.1-SNAPSHOT.jar LoggingService.jar

ENTRYPOINT ["java", "-jar", "LoggingService.jar"]