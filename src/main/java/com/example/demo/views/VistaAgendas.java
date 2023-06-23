package com.example.demo.views;

import java.sql.Date;
import java.sql.Time;

public class VistaAgendas {

    Integer idagendacion;
    Integer cedulaTutor;
    String nombresTutor;
    Integer cedulaEstudiante;
    String nombresEstudiante;
    String tema;
    Date fecha;
    Time hora;

    public Integer getIdagendacion() {
        return idagendacion;
    }

    public void setIdagendacion(Integer idagendacion) {
        this.idagendacion = idagendacion;
    }

    public Integer getCedulaTutor() {
        return cedulaTutor;
    }

    public void setCedulaTutor(Integer cedulaTutor) {
        this.cedulaTutor = cedulaTutor;
    }

    public String getNombresTutor() {
        return nombresTutor;
    }

    public void setNombresTutor(String nombresTutor) {
        this.nombresTutor = nombresTutor;
    }

    public Integer getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(Integer cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public String getNombresEstudiante() {
        return nombresEstudiante;
    }

    public void setNombresEstudiante(String nombresEstudiante) {
        this.nombresEstudiante = nombresEstudiante;
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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

}
