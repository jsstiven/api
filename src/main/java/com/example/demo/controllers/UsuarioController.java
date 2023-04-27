package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UsuariosModel;
import com.example.demo.services.UsuarioService;

@RestController
@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;


}
