package com.example.jesuitas.actividad.controller;


import com.example.jesuitas.actividad.application.ActividadService;
import com.example.jesuitas.actividad.controller.dto.input.ActividadInputDto;
import com.example.jesuitas.actividad.controller.dto.output.ActividadOutputDto;
import com.example.jesuitas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividad")
@CrossOrigin(origins = "*")
public class ActividadController {
    @Autowired
    ActividadService actividadService;

    @PostMapping
    public ActividadOutputDto añadirActividad(@RequestBody ActividadInputDto actividadInputDto) throws Exception {
        return actividadService.añadirActividad(actividadInputDto);
    }

    @GetMapping
    public List<ActividadOutputDto> obtenerListaActividades(@RequestParam(defaultValue = "0", required = false) Integer pagina, @RequestParam(defaultValue = "4", required = false) Integer tamanio) {
        return actividadService.obtenerActividades(pagina, tamanio);
    }

    @GetMapping("/{id}")
    public ActividadOutputDto obtenerActividadPorId(@PathVariable Integer id) throws Exception {

        return actividadService.obtenerActividadPorId(id);
    }

    @PutMapping("/{id}")
    public ActividadOutputDto actualizarActividad(@PathVariable Integer id, @RequestBody ActividadInputDto actividadInputDto) throws Exception {
        return actividadService.actualizarActividad(id, actividadInputDto);
    }

    @DeleteMapping("/{id}")
    public void borrarActividad(@PathVariable Integer id) throws Exception {
        actividadService.borrarActividad(id);
    }

    @GetMapping("/fecha/{fecha}")
    public List<ActividadOutputDto> obtenerActividadPorFecha(@PathVariable String fecha) throws Exception {
        return actividadService.obtenerActividadPorFecha(fecha);
    }

    @GetMapping("/etapa/{etapa}")
    public List<ActividadOutputDto> obtenerActividadPorEtapa(@PathVariable String etapa) throws Exception {
        return actividadService.obtenerActividadPorEtapa(etapa);
    }

    @GetMapping("/titulo/{titulo}")
    public ActividadOutputDto obtenerActividadPorTitulo(@PathVariable String titulo) throws Exception {
        return actividadService.obtenerActividadPorTitulo(titulo);
    }
}
