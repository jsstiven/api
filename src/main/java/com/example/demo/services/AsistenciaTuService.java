package com.example.demo.services;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.asistenciaTuModel;
import com.example.demo.repositories.AsistenciaTuRepository;
import com.example.demo.views.VistaReporteAsistenciaTu;



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

            Object[] cabecera = { "Dia", "Hora Entrada 1", "Hora Salida 1", "Hora Entrada 2", "Hora Salida 2",
                    "Nombres Tutor" };
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

                bodyExcel2[0] = bodyExcel.getDia();
                bodyExcel2[1] = bodyExcel.getHoraEntrada1();
                bodyExcel2[2] = bodyExcel.getHoraSalida1();
                bodyExcel2[3] = bodyExcel.getHoraEntrada2();
                bodyExcel2[4] = bodyExcel.getHoraSalida2();
                bodyExcel2[5] = bodyExcel.getNombreTutor();

                nRow = sheet.createRow(pageRow++);

                for (int i = 0; i < bodyExcel2.length; i++) {
                    nCell = nRow.createCell(i);
                    if(bodyExcel2[i] != null){                    
                        nCell.setCellValue(bodyExcel2[i].toString());   
                    }else{
                        nCell.setCellValue("");
                    }
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
            System.out.println(e);
            return false;
        }
    }

    // Guardar asistencia tutor

    public void guardarAsisTutor(asistenciaTuModel asistenciaTuModel) {
        String caracteres = asistenciaTuModel.getDatos().toString();
        char[] caracter = new char[asistenciaTuModel.getDatos().toString().length()];
        String datofinal = "";
        for (int i = 0; i < caracter.length; i++) {
            if (caracteres.charAt(i) == '=') {
                caracter[i] = ':';
            } else {
                caracter[i] = caracteres.charAt(i);
            }
        }
        for (int i = 0; i < caracter.length; i++) {
            datofinal = datofinal + caracter[i];
        }

        asistenciaTuRepository.guaradarAsistenciaTu(datofinal, asistenciaTuModel.getId_roles_has_usuarios(), asistenciaTuModel.getFecha());

    }

    // Reporte asistencia tutores

    public ArrayList<VistaReporteAsistenciaTu> reporteAsisTu() throws NoSuchElementException {

        JSONArray arrayjs = new JSONArray(asistenciaTuRepository.reporteBecarios());
        ArrayList<VistaReporteAsistenciaTu> dato = new ArrayList<VistaReporteAsistenciaTu>();
        VistaReporteAsistenciaTu asiTu = new VistaReporteAsistenciaTu();

        for (int i = 0; i < arrayjs.length(); i++) {

            JSONObject obj = arrayjs.getJSONObject(i);

            JSONObject obj1 = (JSONObject) obj.get("datos");

            String[] c = obj1.keySet().toArray(new String[obj1.keySet().size()]);

            for (int j = 0; j < c.length; j++) {

                if (c[j] == "horaEntrada1") {

                    asiTu.setHoraEntrada1(obj1.get(c[j]).toString());

                } else if (c[j] == "horaSalida1") {

                    asiTu.setHoraSalida1(obj1.get(c[j]).toString());

                } else if (c[j] == "horaEntrada2") {

                    asiTu.setHoraEntrada2(obj1.get(c[j]).toString());

                } else if (c[j] == "horaSalida2") {

                    asiTu.setHoraSalida2(obj1.get(c[j]).toString());

                } else if (c[j] == "dia") {

                    asiTu.setDia(obj1.get(c[j]).toString());

                }
            }

            asiTu.setNombreTutor(obj.get("nombre_tutor").toString());
            asiTu.setFecha(obj.get("fecha").toString());

            dato.add(asiTu);

            asiTu = new VistaReporteAsistenciaTu();

        }

        return dato;
    }

    // Reporte asistencia tutores

    public String listaAsisTu() {

        JSONArray arrayjs = new JSONArray(asistenciaTuRepository.reporteBecarios());
        if(!arrayjs.toString().isEmpty()){
            return arrayjs.toString();
        }else{
            return "No se encontro registros";
        }

    }

}
