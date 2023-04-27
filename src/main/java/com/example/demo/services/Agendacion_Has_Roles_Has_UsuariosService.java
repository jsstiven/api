package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.Agendacion_Has_Roles_Has_UsuariosRepository;

@Service

public class Agendacion_Has_Roles_Has_UsuariosService {
    @Autowired
    Agendacion_Has_Roles_Has_UsuariosRepository agrhuRepository;
}
