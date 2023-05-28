package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AsignaturasModel;

import jakarta.persistence.Tuple;

@Repository
@EnableJpaRepositories
public interface AsignaturasRepository extends JpaRepository<AsignaturasModel, Integer> {

    @Query(value = "SELECT nombreasignatura FROM asignaturas", nativeQuery = true)
    ArrayList<Tuple> listaAsignaturas();
}
