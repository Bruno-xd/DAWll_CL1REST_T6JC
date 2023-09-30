package com.examencl1.DSWII_CL1REST_T6JC.controller;

import com.examencl1.DSWII_CL1REST_T6JC.model.MensajeResponse;
import com.examencl1.DSWII_CL1REST_T6JC.service.PreguntasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/pregunta")
public class PreguntasController {

    private PreguntasService preguntasService;


    @GetMapping("/pregunta1")
    public ResponseEntity<MensajeResponse> anioBisiesto (@RequestParam Integer anio){
        return new ResponseEntity<>(preguntasService.AnioBisiesto(anio), HttpStatus.OK);
    }

    @GetMapping ("/pregunta2")
    public ResponseEntity<MensajeResponse> determinarAprobacion (@RequestParam Integer c1,
                                                                 @RequestParam Integer c2,
                                                                 @RequestParam Integer c3){
        return new ResponseEntity<>(preguntasService.determinarAprobacion(c1,c2,c3),HttpStatus.OK);
    }

    @GetMapping("/pregunta3")
    public ResponseEntity<MensajeResponse> validarNroPerfecto (@RequestParam Integer numero){
        return new ResponseEntity<>(preguntasService.validarNumerosPerfectos(numero), HttpStatus.OK);
    }

    @GetMapping("/pregunta4")
    public ResponseEntity<MensajeResponse> verificaAlcoholemia (@RequestParam char indicador,
                                                                @RequestParam double tasa){
        return new ResponseEntity<>(preguntasService.verificarAlcoholemia(indicador,tasa), HttpStatus.OK);
    }

}
