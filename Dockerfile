# Stage 1: Build the JAR
FROM maven:3.9-eclipse-temurin-21 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

# Stage 2: Runtime image
FROM eclipse-temurin:21-jre-jammy
COPY --from=build /usr/src/app/target/quarkus-app/ /deployments/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/deployments/quarkus-run.jar"]
