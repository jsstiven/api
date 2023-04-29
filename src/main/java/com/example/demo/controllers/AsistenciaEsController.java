package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.AsistenciaEsService;
import com.example.demo.views.VistaReporteAsistenciaEs;

@RestController
@Controller
@RequestMapping(value = "/asistenciaestudiante")
public class AsistenciaEsController {
    @Autowired
    AsistenciaEsService asEstuService;

    // Reporte asistencia estudiante
    @GetMapping("/reporteestudiante")
    public ArrayList<VistaReporteAsistenciaEs> reporteEstudiante() {
        return asEstuService.reporteAsisEstu();
    }
}
