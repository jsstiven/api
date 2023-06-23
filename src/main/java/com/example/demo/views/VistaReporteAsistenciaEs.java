package com.example.demo.views;

import java.sql.Date;

public class VistaReporteAsistenciaEs {
    Integer cedulaTutor;
    Integer cedula;
    String nombresTutor;
    String asignatura;
    String tema;
    Date fecha;
    Integer cedulaEstudiante;
    String nombresEstudiante;
    String programaAcademico;
    Integer puntuacion;
    String comentarios;

    public String getNombresTutor() {
        return nombresTutor;
    }

    public void setNombresTutor(String nombresTutor) {
        this.nombresTutor = nombresTutor;
    }

    public String getNombresEstudiante() {
        return nombresEstudiante;
    }

    public void setNombresEstudiante(String nombresEstudiante) {
        this.nombresEstudiante = nombresEstudiante;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(Integer cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public Integer getCedulaTutor() {
        return cedulaTutor;
    }

    public void setCedulaTutor(Integer cedulaTutor) {
        this.cedulaTutor = cedulaTutor;
    }

}
