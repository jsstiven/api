package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.AsistenciaTuService;
import com.example.demo.views.VistaReporteAsistenciaTu;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@Controller
@RequestMapping(value = "/asistenciatutor")
public class AsistenciaTuController {
    @Autowired
    AsistenciaTuService asTuService;

    // Guardar Usuario
    @GetMapping("/reportetutor")
    public ArrayList<VistaReporteAsistenciaTu> reporteTutor() {
        return asTuService.reporteAsisTu();
    }
    
}
