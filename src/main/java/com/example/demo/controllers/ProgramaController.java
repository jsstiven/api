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

import com.example.demo.models.ProgramaModel;
import com.example.demo.services.ProgramaService;

@RestController
@Controller
@RequestMapping(value = "/programa")
@CrossOrigin(origins = "*")

public class ProgramaController {
    @Autowired
    ProgramaService programaService;

    // Listar programa
    @GetMapping("/listarPrograma")
    public String obtenerPrograma() {
        ArrayList<ProgramaModel> dato = programaService.buscarPrograma();
        JSONArray arrayjs = new JSONArray(dato.toArray());

        if (!arrayjs.toString().isEmpty()) {
            return arrayjs.toString();
        } else {
            return "No hay informacion";
        }
    }

    // Guardar programa
    @PostMapping("/GuardarPrograma")
    public String guardarPrograma(@RequestBody ProgramaModel programaModel) {
        try {
            programaService.guardarProgramaAc(programaModel);
            return "El programa se ha guardado con exito";
        } catch (Exception e) {
            System.out.println(e);
            return "No se pudo guardar el programa";
        }
    }

}
