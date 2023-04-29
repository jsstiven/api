package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

public class ProgramaController {
    @Autowired
    ProgramaService programaService;

    //Listar programa
    @GetMapping("/listarPrograma")
    public ArrayList<ProgramaModel> obtenerPrograma() {
        return programaService.buscarPrograma();
    }
    //Guardar programa
    @PostMapping("/GuardarPrograma")
    public void guardarPrograma(@RequestBody ProgramaModel programaModel){
        programaService.guardarProgramaAc(programaModel);
    }

}
