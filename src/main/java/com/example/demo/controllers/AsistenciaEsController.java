package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")

public class AsistenciaEsController {
    @Autowired
    AsistenciaEsService asEstuService;
    @Autowired
    CalificacionService calificacionService;

    // Descargar Reporte
    @GetMapping("/descargarreporteestu")
    public String descargarReporteEs() {
        if (asEstuService.descargarReporteEs("C:\\Users\\USUARIO\\Downloads\\ReportesEstudiantes.xlsx")) {
            return "C:/Users/USUARIO/Downloads/ReportesEstudiantes.xlsx";
        } else {
            return "";
        }
    }

    // Editar Asistencia Tutoria
    @PostMapping("/editarasisestudiante")
    public String editarAsisEstudiante(@RequestBody VistaReporteAsistenciaEs vrae) {

        AsistenciaEsModel asies = new AsistenciaEsModel();
        CalificacionModel ca = new CalificacionModel();
        try {

            asies.setAsignatura(vrae.getAsignatura());
            asies.setGrupo(vrae.getGrupo());
            asies.setDia(vrae.getFecha());
            asies.setId_roles_has_usuarios(vrae.getCedula());
            asies.setTema(vrae.getTema());
            asies.setCcEs(vrae.getCedulaEstudiante());

            ca.setPuntuacion(vrae.getPuntuacion());
            ca.setComentarios(vrae.getComentarios());
            ca.setCces(vrae.getCedulaEstudiante());
            ca.setId_roles_has_usuarios(vrae.getCedula());

            try {
                asEstuService.editarAsistenciaEs(asies, vrae.getIdasistencia());

            } catch (Exception e) {
                System.out.println("no trae consulta");
            }

            try {
                calificacionService.editarCalificacion(ca, vrae.getIdCalificacion());

            } catch (Exception e) {
                System.out.println("no trae consulta");
            }

            return "La asistencia se ha editado con exito";
        } catch (Exception e) {
            System.out.println(e);
            return "No se pudo guardar la asistencia";
        }
    }

    // Guardar asistencia estudiante

    @PostMapping("/guardarasisestudiante")
    public String guardarAsisEstudiante(@RequestBody VistaGuardarAsisEs vistaGuardarAsisEs) {

        AsistenciaEsModel asies = new AsistenciaEsModel();
        CalificacionModel ca = new CalificacionModel();
        try {

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
            
            try {

                asEstuService.guardarAsistenciaEs(asies);

            } catch (Exception e) {
                System.out.println("no trae consulta");
            }

            try {

                calificacionService.guardarCalificacion(ca);

            } catch (Exception e) {
                System.out.println("no trae consulta");
            }
            return "La asistencia se ha guardado con exito";
        } catch (Exception e) {
            System.out.println(e);
            return "No se pudo guardar la asistencia";
        }
    }

    // Reporte asistencia estudiante
    @GetMapping("/reporteestudiante")
    public ArrayList<VistaReporteAsistenciaEs> reporteEstudiante() {
        return asEstuService.reporteAsisEstu();
    }
}
