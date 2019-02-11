package com.practice.mytest.controllers;

import com.practice.mytest.domain.Estudiante;
import com.practice.mytest.services.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(EstudianteController.BASE_URL)
public class EstudianteController {

    static final String BASE_URL = "/api/fundapec/estudiantes";

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/{id}")
    public Estudiante getEstudianteById(@PathVariable Long id){
        return estudianteService.findEstudianteById(id);
    }

    @GetMapping
     List<Estudiante> getAllEstudiantes(){
        return estudianteService.findAllEstudiantes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante addEstudiante(@RequestBody Estudiante estudiante){
        return estudianteService.saveEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id,
                                                       @RequestBody @Valid Estudiante estudiante){
        return estudianteService.updateEstudianteById(id, estudiante);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteEstudiante(@PathVariable Long id){
        return estudianteService.deleteEstudianteById(id);
    }
}
