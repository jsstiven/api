package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.AgendacionService;
import com.example.demo.views.VistaAgendas;

@RestController
@Controller
@RequestMapping(value = "/agendacion")
public class AgendacionController {
    @Autowired
    AgendacionService agendacionService;

    // Reporte asistencia estudiante
    @GetMapping("/reporteagendacion")
    public ArrayList<VistaAgendas> reporteEstudiante() {
        return agendacionService.reporteAgendas();
    }
}
