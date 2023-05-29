package com.example.jesuitas.actividad.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActividadInputDto {
    private String titulo;
    private String descripcion;
    private String fecha;
    private String hora;
    private String etapa;
    private Integer participantesMax;
}
