package com.fal.bloques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BloquesApplication {

	public static void main(String[] args) {

		SpringApplication.run(BloquesApplication.class, args);

		String[] palabras = {"A", "LIBRO", "BOZO", "TRAJE", "COMUN", "CAMPANA", "DORITO", "ARLEQUIN"};
		boolean[] resultadosEsperados = {true, true, false, true, true, false, true, true};

		System.out.println("Ejemplo – Casos de prueba:");
		System.out.println("----------------------------------------");

		boolean todosPasaron = true;
		for (int i = 0; i < palabras.length; i++) {
			boolean resultado = Bloques.puedoObtenerPalabra(palabras[i]);
			String estado = resultado == resultadosEsperados[i] ? "✓" : "✗";
			String resultadoStr = resultado ? "True" : "False";
			String esperadoStr = resultadosEsperados[i] ? "True" : "False";

			System.out.println(estado + " " + palabras[i] + ": " + resultadoStr + " (esperado: " + esperadoStr + ")");


		}
	}

}
