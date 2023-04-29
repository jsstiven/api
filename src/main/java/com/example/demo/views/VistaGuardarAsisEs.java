package com.example.demo.views;

import java.sql.Date;

public class VistaGuardarAsisEs {

    private String asignatura;
    private String grupo;
    private Date dia;
    private Integer id_roles_has_usuarios;
    private String tema;
    private Integer cces;
    private String comentarios;
    private Integer puntuacion;

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Integer getId_roles_has_usuarios() {
        return id_roles_has_usuarios;
    }

    public void setId_roles_has_usuarios(Integer id_roles_has_usuarios) {
        this.id_roles_has_usuarios = id_roles_has_usuarios;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getCces() {
        return cces;
    }

    public void setCces(Integer cces) {
        this.cces = cces;
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

}
