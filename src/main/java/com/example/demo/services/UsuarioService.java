package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UsuariosModel;
import com.example.demo.repositories.UsuarioRepository;

@Service

public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // Metodos


}
