package com.example.demo.views;

import java.sql.Date;
import java.sql.Time;

public class VistaAgendas {

    Integer idagendacion;
    Integer cedula;
    String nombres;
    String apellidos;
    String tema;
    Date fecha;
    Time hora;

    public Integer getIdagendacion() {
        return idagendacion;
    }

    public void setIdagendacion(Integer idagendacion) {
        this.idagendacion = idagendacion;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
