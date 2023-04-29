package com.example.demo.services;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.AsistenciaTuRepository;
import com.example.demo.views.VistaReporteAsistenciaTu;

import jakarta.persistence.Tuple;

@Service

public class AsistenciaTuService {
    @Autowired
    AsistenciaTuRepository asistenciaTuRepository;

    // Reporte asistencia tutores

    public ArrayList<VistaReporteAsistenciaTu> reporteAsisTu(){
        ArrayList<VistaReporteAsistenciaTu> dato = new ArrayList<VistaReporteAsistenciaTu>();
        VistaReporteAsistenciaTu asiTu = new VistaReporteAsistenciaTu();

        for (Tuple i : asistenciaTuRepository.reporteBecarios()) {
            
            asiTu.setNombres((String) i.get("nombres"));
            asiTu.setApellidos((String) i.get("apellidos"));
            asiTu.setCedula((Integer) i.get("cedula"));
            asiTu.setEntrada((Time) i.get("entrada"));
            asiTu.setSalida((Time) i.get("salida"));
            asiTu.setFecha((Date) i.get("fecha"));

            dato.add(asiTu);

            asiTu = new VistaReporteAsistenciaTu();
        }

        return dato;
    }
}
