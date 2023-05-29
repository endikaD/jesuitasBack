package com.example.jesuitas.actividad.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad", nullable = false)
    private Integer idActividad;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "hora")
    private String hora;
    @Column(name = "etapa")
    private String etapa;
    @Column(name = "participantes")
    private Integer participantesMax;

}
