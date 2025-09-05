package com.fal.bloques.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.fal.bloques.Bloques;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BloquesController {

    @GetMapping("/resultados")
    public String mostrarResultados(Model model) {
        String[] palabras = {"A", "LIBRO", "BOZO", "TRAJE", "COMUN", "CAMPANA", "DORITO", "ARLEQUIN"};
        boolean[] resultadosEsperados = {true, true, false, true, true, false, true, true};

        List<TestResult> resultados = new ArrayList<>();
        boolean todosPasaron = true;

        for (int i = 0; i < palabras.length; i++) {
            boolean resultado = Bloques.puedoObtenerPalabra(palabras[i]);
            boolean exitoso = resultado == resultadosEsperados[i];

            if (!exitoso) {
                todosPasaron = false;
            }

            resultados.add(new TestResult(
                    palabras[i],
                    resultado,
                    resultadosEsperados[i],
                    exitoso
            ));
        }

        model.addAttribute("resultados", resultados);
        model.addAttribute("todosPasaron", todosPasaron);
        model.addAttribute("fechaEjecucion", LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        return "resultado-bloques";
    }

    public static class TestResult {
        private String palabra;
        private boolean resultadoReal;
        private boolean resultadoEsperado;
        private boolean exitoso;

        public TestResult(String palabra, boolean resultadoReal,
                          boolean resultadoEsperado, boolean exitoso) {
            this.palabra = palabra;
            this.resultadoReal = resultadoReal;
            this.resultadoEsperado = resultadoEsperado;
            this.exitoso = exitoso;
        }

        public String getPalabra() { return palabra; }
        public boolean isResultadoReal() { return resultadoReal; }
        public boolean isResultadoEsperado() { return resultadoEsperado; }
        public boolean isExitoso() { return exitoso; }

        public String getResultadoRealStr() {
            return resultadoReal ? "True" : "False";
        }

        public String getResultadoEsperadoStr() {
            return resultadoEsperado ? "True" : "False";
        }

        public String getIcono() {
            return exitoso ? "✓" : "✗";
        }
    }
}