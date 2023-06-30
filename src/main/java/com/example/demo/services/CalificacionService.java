package com.example.demo.services;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CalificacionModel;
import com.example.demo.repositories.CalificacionRepository;

@Service

public class CalificacionService {
    @Autowired
    CalificacionRepository calificacionRepositry;

    // Editar Calificacion

    public void editarCalificacion(CalificacionModel calificacionModel, Integer idCalificacion) {
        calificacionRepositry.editarCalificacion(calificacionModel.getComentarios(), calificacionModel.getPuntuacion(),
                calificacionModel.getCces(), calificacionModel.getId_roles_has_usuarios(), idCalificacion);
    }

    // Guardar Calificacion

    public void guardarCalificacion(CalificacionModel calificacionModel) {
        calificacionRepositry.guardarCalificacion(calificacionModel.getComentarios(), calificacionModel.getPuntuacion(),
                calificacionModel.getCces(), calificacionModel.getId_roles_has_usuarios());
    }

    // listar calificacion diaria

    public String listarDiario() {
        JSONArray arrayjs = new JSONArray(calificacionRepositry.listarCalificacionDiaria());
        return arrayjs.toString();
    }

    // listar calificacion mensual

    public String listarMensual(Integer rhuid) {
        JSONArray arrayjs = new JSONArray(calificacionRepositry.listarCalificacionMensual(rhuid));
        return arrayjs.toString();
    }
    
    // listar calificacion mensual con asignatura

    public String listarMensualAsignatura(Integer rhuid, String asignatura) {
        JSONArray arrayjs = new JSONArray(calificacionRepositry.listarCalificacionMensualAsignatura(rhuid, asignatura));
        return arrayjs.toString();
    }
}
