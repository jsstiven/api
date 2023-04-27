package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendacion_has_roles_has_usuarios")
public class Agendacion_Has_Roles_Has_UsuariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Integer id;

    Integer agendacion_idagendacion;
    Integer roles_has_usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgendacion_idagendacion() {
        return agendacion_idagendacion;
    }

    public void setAgendacion_idagendacion(Integer agendacion_idagendacion) {
        this.agendacion_idagendacion = agendacion_idagendacion;
    }

    public Integer getRoles_has_usuarios() {
        return roles_has_usuarios;
    }

    public void setRoles_has_usuarios(Integer roles_has_usuarios) {
        this.roles_has_usuarios = roles_has_usuarios;
    }

}
