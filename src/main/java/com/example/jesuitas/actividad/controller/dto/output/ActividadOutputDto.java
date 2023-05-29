package com.example.jesuitas.actividad.controller.dto.output;

import com.example.jesuitas.actividad.domain.Actividad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActividadOutputDto {
    private Integer idActividad;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String hora;
    private String etapa;
    private Integer participantesMax;

    public ActividadOutputDto(Actividad actividad) {
        setIdActividad(actividad.getIdActividad());
        setTitulo(actividad.getTitulo());
        setDescripcion(actividad.getDescripcion());
        setFecha(actividad.getFecha());
        setHora(actividad.getHora());
        setEtapa(actividad.getEtapa());
        setParticipantesMax(actividad.getParticipantesMax());
    }

    public ActividadOutputDto(List<Actividad> actividad) {
    }
}
