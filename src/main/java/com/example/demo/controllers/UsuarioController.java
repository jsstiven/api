package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.RolesModel;
import com.example.demo.models.Roles_Has_UsuariosModel;
import com.example.demo.models.UsuariosModel;
import com.example.demo.services.Roles_Has_UsuariosService;
import com.example.demo.services.UsuarioService;

import jakarta.persistence.Tuple;

@RestController
@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    Roles_Has_UsuariosService rhuService = new Roles_Has_UsuariosService();
    Roles_Has_UsuariosModel nuevaAsig = new Roles_Has_UsuariosModel();
    // Actualizar usuario

    // Guardar Usuario
    @PostMapping("/guardarusuario")
    public void guardarUsuarios(@RequestBody UsuariosModel usuariosModel) {
        nuevaAsig.setId(1);
        nuevaAsig.setRoles_idroles(1);
        nuevaAsig.setUsuarios_cc(usuariosModel.getCc());

        try {
            usuarioService.guardarUsuarios(usuariosModel);
            System.out.println(nuevaAsig.getRoles_idroles() + " / " + nuevaAsig.getUsuarios_cc() + " / ");
            rhuService.guardarAsignacion(nuevaAsig);
        } catch (Exception e) {
            System.out.println("error de no traer consulta");
        }
        try {
            System.out.println(nuevaAsig.getRoles_idroles() + " / " + nuevaAsig.getUsuarios_cc() + " / ");
            rhuService.guardarAsignacion(nuevaAsig);
        } catch (Exception e) {
            System.out.println("error de no traer consulta");
        }

    }

    // Login
    @PostMapping("/login")
    public ArrayList<RolesModel> login(@RequestBody UsuariosModel usuariosModel) {
        return usuarioService.login(usuariosModel.getUsuario(), usuariosModel.getContrasena());
    }

}
