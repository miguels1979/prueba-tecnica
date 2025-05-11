# Etapa 1: compilar todos los módulos
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagen base
FROM openjdk:21-jdk-slim
WORKDIR /app

# Argumento para decidir qué servicio arrancar
ARG SERVICE
ENV SERVICE_JAR=${SERVICE}.jar

# Copiar el JAR deseado (uno por imagen)
COPY --from=builder /build/${SERVICE}/target/${SERVICE}-0.0.1-SNAPSHOT.jar /app/${SERVICE}.jar

# EXPOSE 8081  # para percentage-provider-service
# EXPOSE 8082  # para percentage-calculation-api

CMD ["sh", "-c", "java -jar ${SERVICE_JAR}"]
