package com.fal.bloques;

public class Bloques {

    private static final char[][] BLOQUES_PREDEFINIDOS = {
            {'B', 'O'}, {'X', 'K'}, {'D', 'Q'}, {'C', 'P'}, {'N', 'A'},
            {'G', 'T'}, {'R', 'E'}, {'T', 'G'}, {'Q', 'D'}, {'F', 'S'},
            {'H', 'U'}, {'V', 'I'}, {'A', 'T'}, {'O', 'B'}, {'E', 'R'},
            {'F', 'S'}, {'L', 'Y'}, {'P', 'C'}, {'Z', 'M'}, {'J', 'M'}
    };

    public static boolean puedoObtenerPalabra(String palabra) {
        return puedoObtenerPalabra(palabra, BLOQUES_PREDEFINIDOS);
    }

    public static boolean puedoObtenerPalabra(String palabra, char[][] bloques) {
        if (palabra == null || palabra.isEmpty()) {
            return true;
        }

        palabra = palabra.toUpperCase();
        boolean[] used = new boolean[bloques.length];
        return backtrack(palabra, 0, bloques, used);
    }

    private static boolean backtrack(String palabra, int index, char[][] bloques, boolean[] used) {
        if (index == palabra.length()) {
            return true;
        }

        char letraActual = palabra.charAt(index);

        for (int i = 0; i < bloques.length; i++) {
            if (!used[i]) {
                // NO convertir a mayúsculas aquí - los bloques ya están en el formato correcto
                char lado1 = bloques[i][0];
                char lado2 = bloques[i][1];

                if (letraActual == lado1 || letraActual == lado2) {
                    used[i] = true;
                    if (backtrack(palabra, index + 1, bloques, used)) {
                        return true;
                    }
                    used[i] = false; // Backtrack
                }
            }
        }

        return false;
    }

    // Método de debug para ver qué está pasando
    public static void debugCD() {
        System.out.println("=== DEBUG CD ===");
        char[][] bloquesPersonalizados = {{'A', 'B'}, {'C', 'D'}};

        System.out.println("Bloques: [('A','B'), ('C','D')]");
        System.out.println("Palabra: 'CD'");
        System.out.println("Convertido a mayúsculas: " + "CD".toUpperCase());

        for (int i = 0; i < bloquesPersonalizados.length; i++) {
            System.out.println("Bloque " + i + ": '" + bloquesPersonalizados[i][0] + "','" + bloquesPersonalizados[i][1] + "'");
        }

        boolean resultado = puedoObtenerPalabra("CD", bloquesPersonalizados);
        System.out.println("Resultado: " + resultado);

        // Debug paso a paso
        System.out.println("\n=== DEBUG PASO A PASO ===");
        String palabra = "CD";
        boolean[] used = new boolean[bloquesPersonalizados.length];

        // Primera letra: 'C'
        char letraC = palabra.charAt(0);
        System.out.println("Buscando 'C'");
        for (int i = 0; i < bloquesPersonalizados.length; i++) {
            char lado1 = bloquesPersonalizados[i][0];
            char lado2 = bloquesPersonalizados[i][1];
            System.out.println("  Bloque " + i + ": " + lado1 + "," + lado2 + " -> " +
                    (letraC == lado1 || letraC == lado2));
        }

        // Segunda letra: 'D'
        char letraD = palabra.charAt(1);
        System.out.println("Buscando 'D'");
        for (int i = 0; i < bloquesPersonalizados.length; i++) {
            char lado1 = bloquesPersonalizados[i][0];
            char lado2 = bloquesPersonalizados[i][1];
            System.out.println("  Bloque " + i + ": " + lado1 + "," + lado2 + " -> " +
                    (letraD == lado1 || letraD == lado2));
        }
    }

    public static void main(String[] args) {
        debugCD();
    }
}