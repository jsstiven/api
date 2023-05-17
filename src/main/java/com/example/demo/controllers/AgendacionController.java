package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class AgendacionController {
    @Autowired
    AgendacionService agendacionService;
    @Autowired
    Agendacion_Has_Roles_Has_UsuariosService agrhuService;

    // Guardar agendacion
    @PostMapping("/guardaragenda/query")
    public String guaradarAgenda(@RequestBody AgendacionModel agendacionModel,
            @RequestParam("cedulatu") Integer idtutor) {
        try {
            agendacionService.guardarAgendacion(agendacionModel);
            try {
                agrhuService.guardarAsigAgenda(idtutor);
            } catch (Exception e) {
                System.out.println("no trae consulta");
            }

            return "Agendacion guardada con exito";
        } catch (Exception e) {
            System.out.println(e);
            return "No se pudo guardar la agendacion";
        }

    }

    // Editar hora agendacion
    @PostMapping("/editaragenda")
    public String editarAgenda(@RequestBody AgendacionModel agendacionModel) {
        try {
            try {
                agendacionService.editarAgenda(agendacionModel);
            } catch (Exception e) {
                System.out.println("no traer consulta");
            }

            return "Se ha editado la agendacion con exito";
                
        } catch (Exception e) {
            System.out.println(e);
            return "No se pudo editar la agendacion";
        }
    }

    // Cancelar o maracar realizada tutoria agendada
    @PostMapping("/cancelartutoria")
    public String cancelarTutoria(@RequestBody AgendacionModel agendacionModel) {
        try {
            try {
                agendacionService.cancelarTutoria(agendacionModel);
            } catch (Exception e) {
                System.out.println("no traer consulta");
            }
            
            return "Se ha cancelado la Tutoria con exito";
        } catch (Exception e) {
            System.out.println(e);
            return "Nose pudo cancelar la tutoria";
        }
        
    }

    // Reporte asistencia estudiante
    @GetMapping("/reporteagendacion")
    public ArrayList<VistaAgendas> reporteEstudiante() {
        return agendacionService.reporteAgendas();
    }
}
