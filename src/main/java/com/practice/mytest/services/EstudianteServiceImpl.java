package com.practice.mytest.services;

import com.practice.mytest.domain.Estudiante;
import com.practice.mytest.repositories.EstudianteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public Estudiante findEstudianteById(Long id) {
        return estudianteRepository.findById(id).get();
    }

    @Override
    public List<Estudiante> findAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante saveEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public ResponseEntity<Estudiante> updateEstudianteById(Long id, Estudiante estudiante) {
        Estudiante newEstudiante = estudianteRepository.findById(id).get();

        newEstudiante.setCedula_estudiante(estudiante.getCedula_estudiante());
        newEstudiante.setMatricula_estudiante(estudiante.getMatricula_estudiante());
        newEstudiante.setCarrera_abrev(estudiante.getCarrera_abrev());
        newEstudiante.setCreditos_cursados(estudiante.getCreditos_cursados());
        newEstudiante.setCreditos_total(estudiante.getCreditos_total());
        newEstudiante.setFecha_envio(estudiante.getFecha_envio());

        final Estudiante theEstudiante = estudianteRepository.save(newEstudiante);
        return ResponseEntity.ok(theEstudiante);
    }

    @Override
    public Map<String, Boolean> deleteEstudianteById(Long id) {

        Estudiante eliminarEstudiante = estudianteRepository.findById(id).get();
        estudianteRepository.delete(eliminarEstudiante);
        Map<String,Boolean> responseEliminado = new HashMap<>();
        responseEliminado.put("Eliminado!!",Boolean.TRUE);
        return responseEliminado;
    }
}
