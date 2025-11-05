# Movie Play API

API para gestionar películas, creada con Spring Boot.

## Tecnologías

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Docker
- Langchain4j

## Cómo ejecutar la aplicación

1.  **Iniciar la base de datos:**
    ```bash
    docker-compose up -d
    ```

2.  **Ejecutar la aplicación:**
    ```bash
    ./gradlew bootRun
    ```

## Estructura del proyecto

El proyecto sigue una arquitectura en capas:

-   `web`: Contiene los controladores de la API REST.
-   `domain`: Contiene la lógica de negocio y los modelos.
-   `persistence`: Contiene los repositorios y las entidades de la base de datos.

## Endpoints de la API

A continuación se muestran ejemplos de cómo interactuar con la API utilizando `curl`.

### Obtener todas las películas

```bash
curl -X GET http://localhost:8080/parent/movies
```

### Obtener una película por ID

```bash
curl -X GET http://localhost:8080/parent/movies/1
```

### Crear una nueva película

El endpoint devuelve un estado `201 Created` tras la creación.

```bash
curl -X POST http://localhost:8080/parent/movies \
-H "Content-Type: application/json" \
-d '{
  "title": "Inception",
  "director": "Christopher Nolan",
  "releaseYear": 2010
}'
```

### Actualizar una película

El endpoint devuelve un estado `200 OK` si la actualización se ha realizado correctamente.

```bash
curl -X PUT http://localhost:8080/parent/movies/1 \
-H "Content-Type: application/json" \
-d '{
  "title": "Inception: The Director's Cut"
}'
```

### Eliminar una película

El endpoint devuelve un estado `200 OK` si la película se ha eliminado correctamente.

```bash
curl -X DELETE http://localhost:8080/parent/movies/1
```

### Generar una sugerencia de película

```bash
curl -X POST http://localhost:8080/parent/suggestion \
-H "Content-Type: application/json" \
-d '{
  "userPreferences": "I want a sci-fi movie with a complex plot"
}'
```
