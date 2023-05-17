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
        if (asTuService.DescargarReporteTu("\\Trabajos\\demo\\src\\main\\files\\ReportesTutores.xlsx")) {
            return "/files/ReportesTutores.xlsx";
        } else {
            return "error no genero reporte";
        }
    }

    // Guardar asistencia Tutor

    @PostMapping("/guardarasistencia")
    public String guardarAsisTutor(@RequestBody asistenciaTuModel asistenciaTuModel) {
        if(asTuService.guardarAsisTutor(asistenciaTuModel)){
            return "Se guardo la asistencia";
        }else{
            return "Error no guardo la asistencia";
        }
    }

    // Reporte Tutor
    @GetMapping("/reportetutor")
    public ArrayList<VistaReporteAsistenciaTu> reporteTutor() {
        return asTuService.reporteAsisTu();
    }

}
