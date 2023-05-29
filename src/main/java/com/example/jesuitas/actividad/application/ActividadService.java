package com.example.jesuitas.actividad.application;


import com.example.jesuitas.actividad.controller.dto.input.ActividadInputDto;
import com.example.jesuitas.actividad.controller.dto.output.ActividadOutputDto;

import java.util.List;

public interface ActividadService {
    ActividadOutputDto añadirActividad(ActividadInputDto actividadInputDto);

    ActividadOutputDto obtenerActividadPorId(Integer id);

    List<ActividadOutputDto> obtenerActividades(Integer pagina, Integer tamanio);

    ActividadOutputDto actualizarActividad(Integer id, ActividadInputDto actividadInputDto);

    void borrarActividad(Integer id) throws Exception;
    List<ActividadOutputDto> obtenerActividadPorFecha(String fecha);
    List<ActividadOutputDto> obtenerActividadPorEtapa(String etapa);
    ActividadOutputDto obtenerActividadPorTitulo(String titulo);
}
