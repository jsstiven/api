package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Roles_Has_UsuariosModel;

@Repository
@EnableJpaRepositories
public interface Roles_Has_UsuariosRepository extends JpaRepository<Roles_Has_UsuariosModel, Integer> {
    
}
