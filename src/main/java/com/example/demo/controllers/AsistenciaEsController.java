package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AsistenciaEsModel;
import com.example.demo.models.CalificacionModel;
import com.example.demo.services.AsistenciaEsService;
import com.example.demo.services.CalificacionService;
import com.example.demo.views.VistaGuardarAsisEs;
import com.example.demo.views.VistaReporteAsistenciaEs;

@RestController
@Controller
@RequestMapping(value = "/asistenciaestudiante")
public class AsistenciaEsController {
    @Autowired
    AsistenciaEsService asEstuService;
    @Autowired
    CalificacionService calificacionService;

    //Guardar asistencia estudiante

    @PostMapping("/guardarasisestudiante")
    public void guardarAsisEstudiante(@RequestBody VistaGuardarAsisEs vistaGuardarAsisEs){

        AsistenciaEsModel asies = new AsistenciaEsModel();
        CalificacionModel ca = new CalificacionModel();

        asies.setAsignatura(vistaGuardarAsisEs.getAsignatura());
        asies.setGrupo(vistaGuardarAsisEs.getGrupo());
        asies.setDia(vistaGuardarAsisEs.getDia());
        asies.setId_roles_has_usuarios(vistaGuardarAsisEs.getId_roles_has_usuarios());
        asies.setTema(vistaGuardarAsisEs.getTema());
        asies.setCcEs(vistaGuardarAsisEs.getCces());

        ca.setPuntuacion(vistaGuardarAsisEs.getPuntuacion());
        ca.setComentarios(vistaGuardarAsisEs.getComentarios());
        ca.setCces(vistaGuardarAsisEs.getCces());
        ca.setId_roles_has_usuarios(vistaGuardarAsisEs.getId_roles_has_usuarios());

        asEstuService.guardarAsistenciaEs(asies);
        calificacionService.guardarCalificacion(ca);
    }

    // Reporte asistencia estudiante
    @GetMapping("/reporteestudiante")
    public ArrayList<VistaReporteAsistenciaEs> reporteEstudiante() {
        return asEstuService.reporteAsisEstu();
    }
}