package com.example.demo.services;

import org.json.JSONArray;
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

    //listar calificacion 

    public String listarDiario(){
        JSONArray arrayjs = new JSONArray(calificacionRepositry.listarCalificacionDiaria());
        return arrayjs.toString();
    }

    //listar calificacion 

    public String listarMensual(){
        JSONArray arrayjs = new JSONArray(calificacionRepositry.listarCalificacionMensual());
        return arrayjs.toString();
    }
}
