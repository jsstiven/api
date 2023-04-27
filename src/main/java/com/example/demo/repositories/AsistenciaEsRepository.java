package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AsistenciaEsModel;

@Repository
@EnableJpaRepositories
public interface AsistenciaEsRepository extends JpaRepository<AsistenciaEsModel, Integer> {
    
}
