package com.examencl1.DSWII_CL1REST_T6JC.service;


import com.examencl1.DSWII_CL1REST_T6JC.model.MensajeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreguntasService {
    // METHODS
    public MensajeResponse AnioBisiesto (Integer numero){
        String resultado;
        resultado=((numero % 4 == 0 && numero % 100 != 0) || (numero % 400 == 0)) ?"Es bisiesto" : "No es Bisiesto";
        return  MensajeResponse.builder().resultado(resultado).build();
    }
    public MensajeResponse determinarAprobacion(int calificacion1, int calificacion2, int calificacion3) {
        double promedio = (calificacion1 + calificacion2 + calificacion3) / 3.0;
        String resultado = (promedio >= 70) ? "Aprobado" : "Reprobado";
        return MensajeResponse.builder().resultado(resultado).build();
    }

    public MensajeResponse validarNumerosPerfectos(int limite) {
        List<Integer> numerosPerfectos = new ArrayList<>();
        for (int numero = 1; numero <= limite; numero++) {
            if (esNumeroPerfecto(numero)) {
                numerosPerfectos.add(numero);
            }
        }
        if (numerosPerfectos.isEmpty()) {
            return MensajeResponse.builder().resultado("No se encontraron números perfectos.").build();
        }
        return MensajeResponse.builder().resultado("Números perfectos encontrados: " + numerosPerfectos).build();
    }
    public boolean esNumeroPerfecto(int numero) {
        int sumaDivisores = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }
        return sumaDivisores == numero;
    }

    public MensajeResponse verificarAlcoholemia(char indicadorVehiculo, double tasaAlcohol) {
        String resultado;
        switch (indicadorVehiculo) {
            case 'C':
            case 'A':
            case 'M':
                if (tasaAlcohol <= 0.3) {resultado = "El conductor no da positivo en el control de alcoholemia.";
                } else { resultado = "El conductor da positivo en el control de alcoholemia."; }
                break;
            case 'T':
                if (tasaAlcohol <= 0.5) {resultado = "El conductor no da positivo en el control de alcoholemia.";
                } else {resultado = "El conductor da positivo en el control de alcoholemia."; }
                break;
            default:
                resultado = "Indicador de vehículo no válido.";
                break;
        }
        return MensajeResponse.builder().resultado(resultado).build();
    }




}
