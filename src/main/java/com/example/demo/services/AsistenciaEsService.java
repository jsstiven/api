package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.AsistenciaEsRepository;

@Service

public class AsistenciaEsService {
    @Autowired
    AsistenciaEsRepository asistenciaEsRepository;
}
