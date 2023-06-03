package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AsignaturasModel;
import com.example.demo.repositories.AsignaturasRepository;

import jakarta.persistence.Tuple;

@Service
public class AsignaturasServices {
    @Autowired
    AsignaturasRepository asignaturasRepository;

    // Listar asignaturas
    public ArrayList<AsignaturasModel> listaAsignaturas() {
        ArrayList<AsignaturasModel> dato = new ArrayList<AsignaturasModel>();
        AsignaturasModel a = new AsignaturasModel();

        for (Tuple i : asignaturasRepository.listaAsignaturas()) {

            a.setNombreasignatura((String) i.get("nombreasignatura"));

            dato.add(a);

            a = new AsignaturasModel();
        }

        return dato;
    }

    // crear asignatura

    public void crearAsignatura(AsignaturasModel asignaturasModel) {
        try {
            asignaturasRepository.guardarAsignaturas(asignaturasModel.getNombreasignatura());   
        } catch (Exception e) {
            System.out.println("no trae consulta");
        }
    }

}
