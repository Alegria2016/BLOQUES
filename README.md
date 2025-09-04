# App Bloques

Proyecto Java con Spring Boot que resuelve el problema de formar palabras usando bloques de letras, siguiendo reglas específicas. Incluye pruebas unitarias y ejemplos de uso.

## Funcionalidad

La clase principal [`com.fal.bloques.Bloques`](src/main/java/com/fal/bloques/Bloques.java) implementa el método [`puedoObtenerPalabra`](src/main/java/com/fal/bloques/Bloques.java) que determina si una palabra puede formarse usando un conjunto de bloques de letras, donde cada bloque solo puede usarse una vez y cada letra de la palabra debe estar en algún bloque.

El proyecto incluye:
- Ejecución de casos de prueba en consola desde [`com.fal.bloques.BloquesApplication`](src/main/java/com/fal/bloques/BloquesApplication.java).
- Pruebas unitarias en [`com.fal.bloques.BloquesTest`](src/test/java/com/fal/bloques/BloquesTest.java).

## Estructura

```
src/
  main/
    java/com/fal/bloques/
      Bloques.java
      BloquesApplication.java
    resources/
      application.properties
  test/
    java/com/fal/bloques/
      BloquesTest.java
      BloquesApplicationTests.java
pom.xml
mvnw / mvnw.cmd
```

## Requisitos

- Java 17+
- Maven 3.9+

## Ejecución local paso a paso

1. **Clona el repositorio**
   ```sh
   git clone <URL_DEL_REPOSITORIO>
   cd bloques
   ```

2. **Compila el proyecto**
   ```sh
   ./mvnw clean install
   ```

3. **Ejecuta la aplicación**
   ```sh
   ./mvnw spring-boot:run
   ```
   Esto ejecuta [`com.fal.bloques.BloquesApplication`](src/main/java/com/fal/bloques/BloquesApplication.java) y muestra los resultados de los casos de prueba en consola.

4. **Ejecuta las pruebas unitarias**
   ```sh
   ./mvnw test
   ```
   Verás los resultados de los tests definidos en [`com.fal.bloques.BloquesTest`](src/test/java/com/fal/bloques/BloquesTest.java).

## Personalización

Puedes modificar los bloques o agregar nuevos casos de prueba editando [`Bloques.java`](src/main/java/com/fal/bloques/Bloques.java) y [`BloquesTest.java`](src/test/java/com/fal/bloques/BloquesTest.java).

##
