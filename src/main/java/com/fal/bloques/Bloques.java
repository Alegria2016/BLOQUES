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
}