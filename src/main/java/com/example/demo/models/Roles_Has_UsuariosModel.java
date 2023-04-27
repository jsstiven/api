package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles_has_usuarios")
public class Roles_Has_UsuariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Integer id;

    Integer roles_idroles;
    Integer usuarios_cc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoles_idroles() {
        return roles_idroles;
    }

    public void setRoles_idroles(Integer roles_idroles) {
        this.roles_idroles = roles_idroles;
    }

    public Integer getUsuarios_cc() {
        return usuarios_cc;
    }

    public void setUsuarios_cc(Integer usuarios_cc) {
        this.usuarios_cc = usuarios_cc;
    }

}
