package com.practice.mytest.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 11)
    private String cedula_estudiante;
    @Column(length = 9)
    private String matricula_estudiante;
    @Column(length = 3)
    private String carrera_abrev;
    @Column(length = 3)
    private int creditos_total;
    @Column(length = 3)
    private int creditos_cursados;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_envio;

}
