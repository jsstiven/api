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
        calificacionRepositry.guardarCalificacion(calificacionModel.getComentarios(), calificacionModel.getPuntuacion(), calificacionModel.getCces(), calificacionModel.getId_roles_has_usuarios());
    }

    //listar calificacion 

    public String listarDiario(){
        JSONArray arrayjs = new JSONArray(calificacionRepositry.listarCalificacionDiaria());
        return arrayjs.toString();
    }

    //listar calificacion 

    public String listarMensual(Integer rhuid){
        JSONArray arrayjs = new JSONArray(calificacionRepositry.listarCalificacionMensual(rhuid));
        return arrayjs.toString();
    }
}
