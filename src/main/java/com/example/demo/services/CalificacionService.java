package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CalificacionModel;
import com.example.demo.repositories.CalificacionRepositry;

@Service

public class CalificacionService {
    @Autowired
    CalificacionRepositry calificacionRepositry;

    //Guardar Calificacion

    public void guardarCalificacion(CalificacionModel calificacionModel){
        calificacionRepositry.save(calificacionModel);
    }
}
