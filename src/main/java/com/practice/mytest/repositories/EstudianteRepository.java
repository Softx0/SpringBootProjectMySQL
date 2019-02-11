package com.practice.mytest.repositories;

import com.practice.mytest.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
}
