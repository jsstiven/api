package com.example.demo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "asistenciatu")
public class asistenciaTuModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idasistenciatu;

    private Object datos;
    private Date fecha;
    private Integer id_roles_has_usuarios;

    public Integer getIdasistenciatu() {
        return idasistenciatu;
    }

    public void setIdasistenciatu(Integer idasistenciatu) {
        this.idasistenciatu = idasistenciatu;
    }

    public Integer getId_roles_has_usuarios() {
        return id_roles_has_usuarios;
    }

    public void setId_roles_has_usuarios(Integer id_roles_has_usuarios) {
        this.id_roles_has_usuarios = id_roles_has_usuarios;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    
}
