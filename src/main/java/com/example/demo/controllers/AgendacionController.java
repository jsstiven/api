package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AgendacionModel;
import com.example.demo.services.AgendacionService;
import com.example.demo.services.Agendacion_Has_Roles_Has_UsuariosService;
import com.example.demo.views.VistaAgendas;

@RestController
@Controller
@RequestMapping(value = "/agendacion")
public class AgendacionController {
    @Autowired
    AgendacionService agendacionService;
    @Autowired
    Agendacion_Has_Roles_Has_UsuariosService agrhuService;

    // Guardar agendacion
    @PostMapping("/guardaragenda/query")
    public void guaradarAgenda(@RequestBody AgendacionModel agendacionModel, @RequestParam("cedulatu") Integer idtutor){
        
        agendacionService.guardarAgendacion(agendacionModel);
        try {
            agrhuService.guardarAsigAgenda(idtutor);
        } catch (Exception e) {
           System.out.println("no trae consulta");
        }

    }


    // Reporte asistencia estudiante
    @GetMapping("/reporteagendacion")
    public ArrayList<VistaAgendas> reporteEstudiante() {
        return agendacionService.reporteAgendas();
    }
}
