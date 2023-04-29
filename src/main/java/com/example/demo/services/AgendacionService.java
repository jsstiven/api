package com.example.demo.services;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.AgendacionRepository;
import com.example.demo.views.VistaAgendas;

import jakarta.persistence.Tuple;

@Service

public class AgendacionService {

    @Autowired
    AgendacionRepository agendacionRepository;

    // Reporte asistencia estudiantes
    public ArrayList<VistaAgendas> reporteAgendas() {

        ArrayList<VistaAgendas> dato = new ArrayList<VistaAgendas>();
        VistaAgendas agenda = new VistaAgendas();

        for (Tuple i : agendacionRepository.reporteAgendacion()) {

            agenda.setIdagendacion((Integer) i.get("idagendacion"));
            agenda.setCedula((Integer) i.get("cedula"));
            agenda.setNombres((String) i.get("nombres"));
            agenda.setApellidos((String) i.get("apellidos"));
            agenda.setTema((String) i.get("tema"));
            agenda.setFecha((Date) i.get("fecha"));
            agenda.setHora((Time) i.get("hora"));

            dato.add(agenda);

            agenda = new VistaAgendas();
        }

        return dato;
    }
}
