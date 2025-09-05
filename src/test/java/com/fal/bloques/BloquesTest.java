package com.fal.bloques;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
@SpringBootTest
public class BloquesTest {

    @Test
    public void testPalabraVacia() {
        assertTrue(Bloques.puedoObtenerPalabra(""));
    }

    @Test
    public void testPalabraA() {
        assertTrue(Bloques.puedoObtenerPalabra("A"));
        assertTrue(Bloques.puedoObtenerPalabra("a"));
    }

    @Test
    public void testPalabraLIBRO() {
        assertTrue(Bloques.puedoObtenerPalabra("LIBRO"));
    }

    @Test
    public void testPalabraBOZO() {
        assertFalse(Bloques.puedoObtenerPalabra("BOZO"));
    }

    @Test
    public void testPalabraTRAJE() {
        assertTrue(Bloques.puedoObtenerPalabra("TRAJE"));
    }

    @Test
    public void testPalabraCOMUN() {
        assertTrue(Bloques.puedoObtenerPalabra("COMUN"));
    }

    @Test
    public void testPalabraCAMPANA() {
        assertFalse(Bloques.puedoObtenerPalabra("CAMPANA"));
    }

    @Test
    public void testPalabraDORITO() {
        assertTrue(Bloques.puedoObtenerPalabra("DORITO"));
    }

    @Test
    public void testPalabraARLEQUIN() {
        assertTrue(Bloques.puedoObtenerPalabra("ARLEQUIN"));
    }

    @Test
    public void testPalabraNull() {
        assertTrue(Bloques.puedoObtenerPalabra(null));
    }

    @Test
    public void testBloquesPersonalizados() {
        // Para que "CD" sea True, necesitamos MÁS de un bloque que contenga C o D
        char[][] bloquesPersonalizados = {
                {'A', 'B'},
                {'C', 'D'},  // Este bloque se usará para 'C'
                {'X', 'D'}   // Este bloque se usará para 'D'
        };

        System.out.println("=== TEST BLOQUES PERSONALIZADOS ===");
        System.out.println("A: " + Bloques.puedoObtenerPalabra("A", bloquesPersonalizados));
        System.out.println("B: " + Bloques.puedoObtenerPalabra("B", bloquesPersonalizados));
        System.out.println("C: " + Bloques.puedoObtenerPalabra("C", bloquesPersonalizados));
        System.out.println("D: " + Bloques.puedoObtenerPalabra("D", bloquesPersonalizados));
        System.out.println("CD: " + Bloques.puedoObtenerPalabra("CD", bloquesPersonalizados));
        System.out.println("AB: " + Bloques.puedoObtenerPalabra("AB", bloquesPersonalizados));

        // Tests CORREGIDOS
        assertTrue("A debería ser True", Bloques.puedoObtenerPalabra("A", bloquesPersonalizados));
        assertTrue("B debería ser True", Bloques.puedoObtenerPalabra("B", bloquesPersonalizados));
        assertTrue("C debería ser True", Bloques.puedoObtenerPalabra("C", bloquesPersonalizados));
        assertTrue("D debería ser True", Bloques.puedoObtenerPalabra("D", bloquesPersonalizados));
        assertTrue("CD debería ser True (con bloques suficientes)",
                Bloques.puedoObtenerPalabra("CD", bloquesPersonalizados));
        assertFalse("AB debería ser False (mismo bloque no se puede usar dos veces)",
                Bloques.puedoObtenerPalabra("AB", bloquesPersonalizados));
        assertFalse("ABC debería ser False",
                Bloques.puedoObtenerPalabra("ABC", bloquesPersonalizados));
    }

    @Test
    public void testLetrasRepetidas() {
        // Para letras repetidas, necesitamos múltiples bloques con la misma letra
        // PERO con una configuración que haga imposible formar "AAA"
        char[][] bloquesConRepetidas = {
                {'A', 'B'},  // Bloque 1 con A
                {'C', 'D'},  // Bloque sin A
                {'E', 'A'},  // Bloque 2 con A
                {'F', 'G'}   // Bloque sin A - solo hay 2 bloques con A, no 3
        };

        System.out.println("=== TEST LETRAS REPETIDAS ===");
        System.out.println("A: " + Bloques.puedoObtenerPalabra("A", bloquesConRepetidas));
        System.out.println("AA: " + Bloques.puedoObtenerPalabra("AA", bloquesConRepetidas));
        System.out.println("AAA: " + Bloques.puedoObtenerPalabra("AAA", bloquesConRepetidas));
        System.out.println("AB: " + Bloques.puedoObtenerPalabra("AB", bloquesConRepetidas));

        // Tests CORREGIDOS
        assertTrue("A debería ser True", Bloques.puedoObtenerPalabra("A", bloquesConRepetidas));
        assertTrue("AA debería ser True (dos bloques con A)",
                Bloques.puedoObtenerPalabra("AA", bloquesConRepetidas));
        assertFalse("AAA debería ser False (solo DOS bloques con A, no tres)",
                Bloques.puedoObtenerPalabra("AAA", bloquesConRepetidas));
        assertTrue("AB debería ser True", Bloques.puedoObtenerPalabra("AB", bloquesConRepetidas));
    }

    @Test
    public void testMismoBloqueDosLetras() {
        char[][] unSoloBloque = {{'A', 'B'}};

        System.out.println("=== TEST MISMO BLOQUE DOS LETRAS ===");
        System.out.println("A: " + Bloques.puedoObtenerPalabra("A", unSoloBloque));
        System.out.println("B: " + Bloques.puedoObtenerPalabra("B", unSoloBloque));
        System.out.println("AB: " + Bloques.puedoObtenerPalabra("AB", unSoloBloque));

        assertTrue("A debería ser True", Bloques.puedoObtenerPalabra("A", unSoloBloque));
        assertTrue("B debería ser True", Bloques.puedoObtenerPalabra("B", unSoloBloque));
        assertFalse("AB debería ser False - mismo bloque", Bloques.puedoObtenerPalabra("AB", unSoloBloque));
    }

    @Test
    public void testTodosLosCasosDelProblema() {
        // Casos de prueba del documento original - estos son los IMPORTANTES
        assertTrue("A debería ser True", Bloques.puedoObtenerPalabra("A"));
        assertTrue("LIBRO debería ser True", Bloques.puedoObtenerPalabra("LIBRO"));
        assertFalse("BOZO debería ser False", Bloques.puedoObtenerPalabra("BOZO"));
        assertTrue("TRAJE debería ser True", Bloques.puedoObtenerPalabra("TRAJE"));
        assertTrue("COMUN debería ser True", Bloques.puedoObtenerPalabra("COMUN"));
        assertFalse("CAMPANA debería ser False", Bloques.puedoObtenerPalabra("CAMPANA"));
        assertTrue("DORITO debería ser True", Bloques.puedoObtenerPalabra("DORITO"));
        assertTrue("ARLEQUIN debería ser True", Bloques.puedoObtenerPalabra("ARLEQUIN"));
    }

    @Test
    public void testCaseInsensitive() {
        assertTrue("libro en minúsculas", Bloques.puedoObtenerPalabra("libro"));
        assertTrue("TRAJE mezclado", Bloques.puedoObtenerPalabra("TrAjE"));
        assertTrue("arlequin en minúsculas", Bloques.puedoObtenerPalabra("arlequin"));
    }

    @Test
    public void testProblemaOriginalCompleto() {
        // Todos los casos del problema original en un solo test
        System.out.println("=== TEST EJEMPLO DE PRUEBAS COMPLETO  ===");

        String[] palabras = {"A", "LIBRO", "BOZO", "TRAJE", "COMUN", "CAMPANA", "DORITO", "ARLEQUIN"};
        boolean[] resultadosEsperados = {true, true, false, true, true, false, true, true};

        for (int i = 0; i < palabras.length; i++) {
            boolean resultado = Bloques.puedoObtenerPalabra(palabras[i]);
            System.out.println(palabras[i] + ": " + resultado + " (esperado: " + resultadosEsperados[i] + ")");
            assertEquals(palabras[i] + " debería ser " + resultadosEsperados[i],
                    resultadosEsperados[i], resultado);
        }
    }
}