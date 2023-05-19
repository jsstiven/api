package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "calificacion")
public class CalificacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idcalificacion;

    private String comentarios;
    private Integer puntuacion;
    private Integer cces;
    private Integer id_roles_has_usuarios;
    private Integer idasistenciases;

    public Integer getIdcalificacion() {
        return idcalificacion;
    }

    public void setIdcalificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getCces() {
        return cces;
    }

    public void setCces(Integer cces) {
        this.cces = cces;
    }

    public Integer getId_roles_has_usuarios() {
        return id_roles_has_usuarios;
    }

    public void setId_roles_has_usuarios(Integer id_roles_has_usuarios) {
        this.id_roles_has_usuarios = id_roles_has_usuarios;
    }

    public Integer getIdasistenciases() {
        return idasistenciases;
    }

    public void setIdasistenciases(Integer idasistenciases) {
        this.idasistenciases = idasistenciases;
    }

    

}
