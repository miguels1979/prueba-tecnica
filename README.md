# Percentage Calculation API

## Descripción

Este microservicio permite calcular un porcentaje basado en valores dinámicos obtenidos de otro microservicio. La API soporta cálculo y almacenamiento en caché del porcentaje durante 30 minutos.

## Requisitos

- **Docker** (para ejecutar la base de datos y el microservicio en contenedores).
- **Java 21** (o compatible).
- **Postman/Swagger** para probar la API.

## Instrucciones para ejecutar el servicio

### 1. Clonar el repositorio

git clone https://github.com/tu-repositorio/prueba-tecnica.git
cd prueba-tecnica

### 2. Construir las imágenes  de Docker (sin usar caché)
docker-compose build --no-cache

### 3. Levantar los contenedores
docker-compose up -d

Esto levantará:
- Base de datos PostgreSQL (localhost:5432)
- Microservicio percentage-provider-service (localhost:8081)
- Microservicio percentage-calculation-api (localhost:8082)

### 4. Acceder a la API
Accede a la documentación Swagger en tu navegador:
http://localhost:8082/webjars/swagger-ui/index.html

### Estructura de Carpetas
prueba-tecnica/
│
├── docker-compose.yml
├── Dockerfile
├── percentage-calculation-api/
├── percentage-provider-service/
└── ...

### 5. Apagar y limpiar contenedores

- Para detener los contenedores:
    docker-compose down
- Para limpiar volúmenes y redes (opcional):
    docker-compose down -v --remove-orphans




