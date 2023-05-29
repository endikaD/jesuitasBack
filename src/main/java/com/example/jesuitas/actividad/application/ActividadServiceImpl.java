package com.example.jesuitas.actividad.application;

import com.example.jesuitas.actividad.controller.dto.input.ActividadInputDto;
import com.example.jesuitas.actividad.controller.dto.output.ActividadOutputDto;
import com.example.jesuitas.actividad.domain.Actividad;
import com.example.jesuitas.actividad.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActividadServiceImpl implements ActividadService {
    @Autowired
    ActividadRepository actividadRepository;

    @Override
    public ActividadOutputDto añadirActividad(ActividadInputDto actividadInputDto) {
        Actividad actividad = new Actividad();

        actividad.setTitulo(actividadInputDto.getTitulo());
        actividad.setDescripcion(actividadInputDto.getDescripcion());
        actividad.setFecha(actividadInputDto.getFecha());
        actividad.setHora(actividadInputDto.getHora());
        actividad.setEtapa(actividadInputDto.getEtapa());
        actividad.setParticipantesMax(actividadInputDto.getParticipantesMax());

        actividadRepository.save(actividad);
        return new ActividadOutputDto(actividad);
    }

    @Override
    public ActividadOutputDto obtenerActividadPorId(Integer id) {
        Actividad actividad = actividadRepository.findById(id).orElseThrow();
        return new ActividadOutputDto(actividad);
    }

    @Override
    public List<ActividadOutputDto> obtenerActividades(Integer pagina, Integer tamanio) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanio);
        return actividadRepository.findAll(pageRequest).getContent().stream().map(ActividadOutputDto::new).toList();
    }

    @Override
    public ActividadOutputDto actualizarActividad(Integer id, ActividadInputDto actividadInputDto) {
        Actividad actividad = actividadRepository.findById(id).orElseThrow();

        actividad.setTitulo(actividadInputDto.getTitulo());
        actividad.setDescripcion(actividadInputDto.getDescripcion());
        actividad.setFecha(actividadInputDto.getFecha());
        actividad.setHora(actividadInputDto.getHora());
        actividad.setEtapa(actividadInputDto.getEtapa());
        actividad.setParticipantesMax(actividadInputDto.getParticipantesMax());

        actividadRepository.save(actividad);
        return new ActividadOutputDto(actividad);
    }

    @Override
    public void borrarActividad(Integer id) throws Exception {
        actividadRepository.delete(actividadRepository.findById(id).orElseThrow());
    }

    @Override
    public List<ActividadOutputDto> obtenerActividadPorFecha(String fecha) {
        List<ActividadOutputDto> actividadOutputDtoArrayList = new ArrayList<>();
        for (Actividad actividad: actividadRepository.findByFecha(fecha)) {
            actividadOutputDtoArrayList.add(new ActividadOutputDto(actividad));
        }
        return actividadOutputDtoArrayList;

    }

    @Override
    public List<ActividadOutputDto> obtenerActividadPorEtapa(String etapa) {
        List<ActividadOutputDto> actividadOutputDtoArrayList = new ArrayList<>();
        for (Actividad actividad: actividadRepository.findByEtapa(etapa)) {
            actividadOutputDtoArrayList.add(new ActividadOutputDto(actividad));
        }
        return actividadOutputDtoArrayList;
    }

    @Override
    public ActividadOutputDto obtenerActividadPorTitulo(String titulo) {
        Actividad actividad = actividadRepository.findByTitulo(titulo);
        return new ActividadOutputDto(actividad);
    }
}
