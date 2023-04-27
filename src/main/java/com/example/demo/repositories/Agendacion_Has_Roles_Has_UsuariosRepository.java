package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Agendacion_Has_Roles_Has_UsuariosModel;

@Repository
@EnableJpaRepositories
public interface Agendacion_Has_Roles_Has_UsuariosRepository extends JpaRepository<Agendacion_Has_Roles_Has_UsuariosModel, Integer> {
}
