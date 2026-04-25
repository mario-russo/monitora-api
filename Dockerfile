## Stage 1: build
FROM quay.io/quarkus/ubi9-quarkus-mandrel-builder-image:jdk-21 AS build

WORKDIR /code

COPY --chown=quarkus:quarkus mvnw /code/mvnw
COPY --chown=quarkus:quarkus .mvn /code/.mvn
COPY --chown=quarkus:quarkus pom.xml /code/

USER quarkus

# baixa dependências
RUN ./mvnw -B org.apache.maven.plugins:maven-dependency-plugin:3.8.1:go-offline

# copia código fonte
COPY --chown=quarkus:quarkus src /code/src

# build JVM (NÃO native)
RUN ./mvnw package -DskipTests


## Stage 2: runtime
FROM quay.io/quarkus/ubi9-quarkus-micro-image:2.0

WORKDIR /work/

# copia artefato correto do Quarkus JVM
COPY --from=build /code/target/quarkus-app /work/

# permissões
RUN chmod -R 775 /work && \
    chown -R 1001:root /work

EXPOSE 8080

USER 1001

# JVM run
CMD ["java", "-jar", "/work/quarkus-run.jar"]