package com.practice.mytest.services;

import com.practice.mytest.domain.Estudiante;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EstudianteService {

    Estudiante findEstudianteById(Long id);
    List<Estudiante> findAllEstudiantes();
    Estudiante saveEstudiante(Estudiante estudiante);
    ResponseEntity<Estudiante> updateEstudianteById(Long id, Estudiante estudiante);
    Map<String, Boolean> deleteEstudianteById(Long id);
}
