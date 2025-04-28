# Percentage Calculation API

## Descripción

Este microservicio permite calcular un porcentaje basado en valores dinámicos obtenidos de otro microservicio. La API soporta cálculo y almacenamiento en caché del porcentaje durante 30 minutos.

## Requisitos

- **Docker** (para ejecutar la base de datos y el microservicio en contenedores).
- **Java 21** (o compatible).
- **Postman/Swagger** para probar la API.

## Instrucciones para ejecutar el servicio

### 1. Clonar el repositorio

git clone https://github.com/tu-repositorio/percentage-calculation-api.git
cd percentage-calculation-api

### 2. Construir el proyecto con Maven
mvn clean install

### 3. Ejecutar el servicio en un contenedor Docker
Paso 1: Construir las imágenes de Docker para ambos microservicios
Para el microservicio percentage-calculation-api:
docker build -t percentage-calculation-api .
Para el microservicio percentage-provider-service:
docker build -t percentage-provider-service .
Paso 2: Iniciar los contenedores de los microservicios y de la base de datos Postgres
docker-compose up -d
### 4. Acceder a la API
http://localhost:8082/swagger-ui/index.html

