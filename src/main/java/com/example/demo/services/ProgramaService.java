package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ProgramaModel;
import com.example.demo.repositories.ProgramaRepository;

@Service
public class ProgramaService {

    @Autowired
    ProgramaRepository programaRepository;

    // Metodos

    public ArrayList<ProgramaModel> buscarPrograma() {
        return (ArrayList<ProgramaModel>) programaRepository.findAll();
    }
}
