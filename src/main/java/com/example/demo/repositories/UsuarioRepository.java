package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UsuariosModel;


@Repository
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<UsuariosModel, Integer> {
}
