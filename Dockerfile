# Estágio 1: Builder - Compila a aplicação
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /build

# Copia arquivos de configuração do Maven
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY src src

# Baixa dependências (cache layer)
RUN mvn dependency:go-offline -B --no-transfer-progress

# Compila a aplicação
RUN mvn package -DskipTests -B --no-transfer-progress

# Estágio 2: Runtime - Imagem final
FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:1.24

ENV LANGUAGE='en_US:en'

WORKDIR /deployments

# Copia os artefatos do estágio builder
COPY --from=builder /build/target/quarkus-app/lib/ ./lib/
COPY --from=builder /build/target/quarkus-app/*.jar ./
COPY --from=builder /build/target/quarkus-app/app/ ./app/
COPY --from=builder /build/target/quarkus-app/quarkus/ ./quarkus/

EXPOSE 8080

USER 185

ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]