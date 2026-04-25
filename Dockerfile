## =========================
## STAGE 1 - BUILD
## =========================
FROM quay.io/quarkus/ubi9-quarkus-mandrel-builder-image:jdk-21 AS build

WORKDIR /code

# arquivos do Maven wrapper
COPY --chown=quarkus:quarkus mvnw /code/mvnw
COPY --chown=quarkus:quarkus .mvn /code/.mvn
COPY --chown=quarkus:quarkus pom.xml /code/

USER quarkus

# baixa dependências
RUN ./mvnw -B dependency:go-offline

# código fonte
COPY --chown=quarkus:quarkus src /code/src

# build JVM (NÃO native)
RUN ./mvnw package -DskipTests

## =========================
## STAGE 2 - RUNTIME
## =========================
FROM quay.io/quarkus/ubi9-quarkus-micro-image:2.0

WORKDIR /work/

# copia artefato Quarkus JVM
COPY --from=build /code/target/quarkus-app /work/

# permissões (importante para Render)
RUN chmod -R 775 /work && \
    chown -R 1001:root /work

EXPOSE 8080

USER 1001
CMD ["sh", "-c", "java -Dquarkus.http.host=0.0.0.0 -Dquarkus.http.port=$PORT -jar /work/quarkus-app/quarkus-run.jar"]