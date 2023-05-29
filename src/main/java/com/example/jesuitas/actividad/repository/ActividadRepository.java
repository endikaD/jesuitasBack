package com.example.jesuitas.actividad.repository;


import com.example.jesuitas.actividad.domain.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
    List<Actividad> findByFecha(String fecha);
    List<Actividad> findByEtapa(String etapa);
    Actividad findByTitulo(String titulo);

}
