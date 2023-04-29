package com.example.demo.services;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AsistenciaEsModel;
import com.example.demo.repositories.AsistenciaEsRepository;
import com.example.demo.views.VistaReporteAsistenciaEs;

import jakarta.persistence.Tuple;

@Service

public class AsistenciaEsService {
    @Autowired
    AsistenciaEsRepository asistenciaEsRepository;

    // Guardar asistencia estudiante
    public void guardarAsistenciaEs(AsistenciaEsModel asistenciaEsModel){
        asistenciaEsRepository.save(asistenciaEsModel);
    }
    

    // Reporte asistencia estudiantes
    public ArrayList<VistaReporteAsistenciaEs> reporteAsisEstu() {

        ArrayList<VistaReporteAsistenciaEs> dato = new ArrayList<VistaReporteAsistenciaEs>();
        VistaReporteAsistenciaEs asiEstu = new VistaReporteAsistenciaEs();

        for (Tuple i : asistenciaEsRepository.reporteAsisEstudiantes()) {

            asiEstu.setCedula((Integer) i.get("cedula"));
            asiEstu.setNombres((String) i.get("nombres"));
            asiEstu.setApellidos((String) i.get("apellidos"));
            asiEstu.setAsignatura((String) i.get("asignatura"));
            asiEstu.setTema((String) i.get("tema"));
            asiEstu.setFecha((Date) i.get("fecha"));
            asiEstu.setCedulaEstudiante((Integer) i.get("cedulaEstudiante"));
            asiEstu.setNombreEstudiante((String) i.get("nombreEstudiante"));
            asiEstu.setApellidoEstudiante((String) i.get("apellidoEstudiante"));
            asiEstu.setPuntuacion((Integer) i.get("puntuacion"));
            asiEstu.setComentarios((String) i.get("comentarios"));

            dato.add(asiEstu);
            asiEstu = new VistaReporteAsistenciaEs();
        }

        return dato;
    }

}
