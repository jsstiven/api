package com.example.demo.services;

import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.asistenciaTuModel;
import com.example.demo.repositories.AsistenciaTuRepository;
import com.example.demo.views.VistaReporteAsistenciaTu;

import jakarta.persistence.Tuple;

@Service

public class AsistenciaTuService {
    @Autowired
    AsistenciaTuRepository asistenciaTuRepository;

    // Descargar Reporte
    public boolean DescargarReporteTu(String fileName) {

        List<VistaReporteAsistenciaTu> datos = this.reporteAsisTu();

        try {

            SXSSFWorkbook workbook = new SXSSFWorkbook(1);
            SXSSFSheet sheet = workbook.createSheet();
            Row nRow = null;
            Cell nCell = null;

            // GENERAR CABECERA

            Object[] cabecera = { "Nombres", "Apellidos", "Cedula", "Entrada", "Salida", "Fecha" };
            nRow = sheet.createRow(0);
            for (int i = 0; i < cabecera.length; i++) {
                nCell = nRow.createCell(i);
                nCell.setCellValue(cabecera[i].toString());
            }

            // GENERAR CUERPO

            Iterator<VistaReporteAsistenciaTu> it = datos.iterator();
            int pageRow = 1;
            while (it.hasNext()) {
                VistaReporteAsistenciaTu bodyExcel = it.next();
                Object[] bodyExcel2 = new Object[6];

                bodyExcel2[0] = bodyExcel.getNombres();
                bodyExcel2[1] = bodyExcel.getApellidos();
                bodyExcel2[2] = bodyExcel.getCedula();
                bodyExcel2[3] = bodyExcel.getEntrada();
                bodyExcel2[4] = bodyExcel.getSalida();
                bodyExcel2[5] = bodyExcel.getFecha();

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

    // Guardar asistencia tutor

    public void guardarAsisTutor(asistenciaTuModel asistenciaTuModel) {
        asistenciaTuRepository.save(asistenciaTuModel);
    }

    // Reporte asistencia tutores

    public ArrayList<VistaReporteAsistenciaTu> reporteAsisTu() {
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
