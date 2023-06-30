package com.example.demo.services;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AgendacionModel;
import com.example.demo.repositories.AgendacionRepository;
import com.example.demo.views.VistaAgendas;

import jakarta.persistence.Tuple;

@Service

public class AgendacionService {

    @Autowired
    AgendacionRepository agendacionRepository;

    // Guardar Agendacion

    public void guardarAgendacion(AgendacionModel agendacionModel) {
        agendacionRepository.save(agendacionModel);
    }

    // Editar agendacion

    public void editarAgenda(AgendacionModel agendacionModel) {
        System.out.println(agendacionModel.getIdagendacion());
        System.out.println(agendacionModel.getCces());
        agendacionRepository.editarAgenda(agendacionModel.getTema(), agendacionModel.getGrupo(),
                agendacionModel.getCces(), agendacionModel.getFecha(), agendacionModel.getHora(),
                agendacionModel.getIdagendacion());
    }

    // Cancelar o maracar realizada tutoria agendada

    public void cancelarTutoria(AgendacionModel agendacionModel) {
        agendacionRepository.cancelarTutoria(agendacionModel.getActivo(), agendacionModel.getIdagendacion());
    }

    // Reporte asistencia estudiantes
    public ArrayList<VistaAgendas> reporteAgendas() {

        ArrayList<VistaAgendas> dato = new ArrayList<VistaAgendas>();
        VistaAgendas agenda = new VistaAgendas();

        for (Tuple i : agendacionRepository.reporteAgendacion()) {

            agenda.setIdagendacion((Integer) i.get("idagendacion"));
            agenda.setIdTutor((Integer) i.get("idTutor"));
            agenda.setCedulaTutor((Integer) i.get("cedulatutor"));
            agenda.setNombresTutor((String) i.get("nombretutor"));
            agenda.setCedulaEstudiante((Integer) i.get("cedulaestudiante"));
            agenda.setNombresEstudiante((String) i.get("nombreestudiante"));
            agenda.setTema((String) i.get("tema"));
            agenda.setGrupo((String) i.get("grupo"));
            agenda.setFecha((Date) i.get("fecha"));
            agenda.setHora((Time) i.get("hora"));
            
            dato.add(agenda);

            agenda = new VistaAgendas();
        }

        return dato;
    }
}
