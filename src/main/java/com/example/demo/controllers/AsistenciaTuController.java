package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.asistenciaTuModel;
import com.example.demo.services.AsistenciaTuService;
import com.example.demo.views.VistaReporteAsistenciaTu;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Controller
@RequestMapping(value = "/asistenciatutor")
@CrossOrigin(origins = "*")

public class AsistenciaTuController {
    @Autowired
    AsistenciaTuService asTuService;

    // Descargar Reporte

    @GetMapping("/descargarreportetutor")
    public String descargarReporteEs() {
        if (asTuService.DescargarReporteTu(
                "C:\\Users\\USUARIO\\Downloads\\ReportesTutores.xlsx")) {
            return "C:/Users/USUARIO/Downloads/ReportesTutores.xlsx";
        } else {
            return "";
        }
    }

    // Guardar asistencia Tutor

    @PostMapping("/guardarasistencia")
    public String guardarAsisTutor(@RequestBody asistenciaTuModel asistenciaTuModel) {

        try {
            System.out.println(asistenciaTuModel.getId_roles_has_usuarios());
            System.out.println(asistenciaTuModel.getDatos().toString());
            try {
                asTuService.guardarAsisTutor(asistenciaTuModel);
            } catch (Exception e) {
                System.out.println("no trae consulta");
            }
            return "Se guardo la asistencia";
        } catch (Exception e) {
            return "Error no guardo la asistencia";
        }
    }

    // Reporte Tutor
    @GetMapping("/reportetutor")
    public ArrayList<VistaReporteAsistenciaTu> reporteTutor() {
        return asTuService.reporteAsisTu();
    }

    // Reporte Tutor
    @GetMapping("/listartutor")
    public String listarTutor() {
        return asTuService.listaAsisTu();
    }
}
