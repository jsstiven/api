package com.example.demo.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AsignaturasModel;
import com.example.demo.services.AsignaturasServices;

@RestController
@Controller
@RequestMapping(value = "/asignaturas")
@CrossOrigin(origins = "*")

public class AsignaturasController {
    @Autowired
    AsignaturasServices asignaturasServices;

    // Listar asignaturas

    @GetMapping("/listaasignaturas")
    public String listatutores() {
        ArrayList<AsignaturasModel> dato = asignaturasServices.listaAsignaturas();
        JSONArray arrayjs = new JSONArray(dato.toArray());

        if (!arrayjs.toString().isEmpty()) {
            return arrayjs.toString();
        } else {
            return "No hay informacion";
        }

    }

    @PostMapping("/guardarasigntura")
    public String guardarAsignatura(@RequestBody AsignaturasModel asignaturasModel) {
        try {
            System.out.println(asignaturasModel.getNombreasignatura());
            asignaturasServices.crearAsignatura(asignaturasModel);
            return "Guardado con exito";
        } catch (Exception e) {
            System.out.println(e);
            return "Error";
        }
    }

}
