# App Bloques

Proyecto Java con Spring Boot que resuelve el problema de formar palabras usando bloques de letras, siguiendo reglas específicas. Incluye pruebas unitarias y ejemplos de uso.


## Resultados Ejecucion de la Función

```
Ejemplo – Casos de prueba:
----------------------------------------
✓ A: True (esperado: True)
✓ LIBRO: True (esperado: True)
✓ BOZO: False (esperado: False)
✓ TRAJE: True (esperado: True)
✓ COMUN: True (esperado: True)
✓ CAMPANA: False (esperado: False)
✓ DORITO: True (esperado: True)
✓ ARLEQUIN: True (esperado: True)

```

## Controlador de prueba de los resultados.
Se realiza un controlador de prueba para mostrar los resultados mediante una plantilla Html, los resultados se pueden ver en la siguiente ruta una vez se inicia la aplicación.
Url: http://localhost:8080/resultados

<img width="779" height="532" alt="image" src="https://github.com/user-attachments/assets/fb87181b-0b13-4c7b-8e90-fe9d88edf7b6" />



## Requisitos

- Java 17+
- Maven 3.9+

## Ejecución local paso a paso

1. **Clona el repositorio**
   ```sh
   git clone https://github.com/Alegria2016/BLOQUES
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



---

## Autor

BTG Pactual - Prueba de Desarrollo Felix Alegria L.
