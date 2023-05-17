package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.HorariosService;

@RestController
@Controller
@RequestMapping(value = "/calificacion")
@CrossOrigin(origins = "*")

public class HorariosController {
    @Autowired
    HorariosService horariosService;
    
}
