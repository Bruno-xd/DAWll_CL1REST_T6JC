package com.examencl1.DSWII_CL1REST_T6JC.service;


import com.examencl1.DSWII_CL1REST_T6JC.model.MensajeResponse;
import org.springframework.stereotype.Service;

@Service
public class PreguntasService {


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
        StringBuilder numerosPerfectos = new StringBuilder("Números perfectos encontrados: ");
        for (int numero = 1; numero <= limite; numero++) {
            if (esNumeroPerfecto(numero)) {
                numerosPerfectos.append(numero).append(",");
            }
        }
        if (numerosPerfectos.toString().equals("Números perfectos encontrados: ")) {
            return MensajeResponse.builder().resultado("No se encontraron números perfectos.").build();
        }
        numerosPerfectos.delete(numerosPerfectos.length() - 2, numerosPerfectos.length());
        return MensajeResponse.builder().resultado(numerosPerfectos.toString()).build();
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


}
