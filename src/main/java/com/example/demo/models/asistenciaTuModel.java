package com.example.demo.models;

import java.sql.Date;
import java.sql.Time;

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
    
    private Time entrada;
    private Time salida;
    private Date fecha;
    private Integer id_roles_has_usuarios;

    public Integer getIdasistenciatu() {
        return idasistenciatu;
    }

    public void setIdasistenciatu(Integer idasistenciatu) {
        this.idasistenciatu = idasistenciatu;
    }

    public Time getEntrada() {
        return entrada;
    }

    public void setEntrada(Time entrada) {
        this.entrada = entrada;
    }

    public Time getSalida() {
        return salida;
    }

    public void setSalida(Time salida) {
        this.salida = salida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId_roles_has_usuarios() {
        return id_roles_has_usuarios;
    }

    public void setId_roles_has_usuarios(Integer id_roles_has_usuarios) {
        this.id_roles_has_usuarios = id_roles_has_usuarios;
    }

}
