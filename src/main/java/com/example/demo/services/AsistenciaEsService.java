package com.example.demo.services;

import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
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

    // Descargar Reporte
    public Boolean descargarReporteEs(String fileName) {
        List<VistaReporteAsistenciaEs> datos = this.reporteAsisEstu();
        try {

            SXSSFWorkbook workbook = new SXSSFWorkbook(1);
            SXSSFSheet sheet = workbook.createSheet();
            Row nRow = null;
            Cell nCell = null;

            // GENERAR CABECERA

            Object[] cabecera = { "Cedula", "Nombres", "Apellidos", "Asignatura", "Tema", "Fecha", "Cedula Estudiante",
                    "Nombre Estudiante", "Apellido Estudiante", "Programa Academico", "Puntuacion", "Comentarios" };
            nRow = sheet.createRow(0);
            for (int i = 0; i < cabecera.length; i++) {
                nCell = nRow.createCell(i);
                nCell.setCellValue(cabecera[i].toString());
            }

            // GENERAR CUERPO

            Iterator<VistaReporteAsistenciaEs> it = datos.iterator();
            int pageRow = 1;
            while (it.hasNext()) {
                VistaReporteAsistenciaEs bodyExcel = it.next();
                Object[] bodyExcel2 = new Object[12];

                bodyExcel2[0] = bodyExcel.getCedula();
                bodyExcel2[1] = bodyExcel.getNombres();
                bodyExcel2[2] = bodyExcel.getApellidos();
                bodyExcel2[3] = bodyExcel.getAsignatura();
                bodyExcel2[4] = bodyExcel.getTema();
                bodyExcel2[5] = bodyExcel.getFecha();
                bodyExcel2[6] = bodyExcel.getCedulaEstudiante();
                bodyExcel2[7] = bodyExcel.getNombreEstudiante();
                bodyExcel2[8] = bodyExcel.getApellidoEstudiante();
                bodyExcel2[9] = bodyExcel.getProgramaAcademico();
                bodyExcel2[10] = bodyExcel.getPuntuacion();
                bodyExcel2[11] = bodyExcel.getComentarios();

                nRow = sheet.createRow(pageRow++);

                for (int i = 0; i < bodyExcel2.length; i++) {
                    nCell = nRow.createCell(i);
                    nCell.setCellValue(bodyExcel2[i].toString());
                }

            }

            // GENERAR ARCHIVO

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            workbook.dispose();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Guardar asistencia estudiante
    public void guardarAsistenciaEs(AsistenciaEsModel asistenciaEsModel) {
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
            asiEstu.setProgramaAcademico((String) i.get("programaAcademico"));
            asiEstu.setPuntuacion((Integer) i.get("puntuacion"));
            asiEstu.setComentarios((String) i.get("comentarios"));

            dato.add(asiEstu);
            asiEstu = new VistaReporteAsistenciaEs();
        }

        return dato;
    }

}
