package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ArrayList<AsignaturasModel> listatutores() {
        return asignaturasServices.listaAsignaturas();
    }
}
