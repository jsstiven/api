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

import com.example.demo.models.RolesModel;
import com.example.demo.models.Roles_Has_UsuariosModel;
import com.example.demo.models.UsuariosModel;
import com.example.demo.services.Roles_Has_UsuariosService;
import com.example.demo.services.UsuarioService;

@RestController
@Controller
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")

public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    Roles_Has_UsuariosService rhuService = new Roles_Has_UsuariosService();
    Roles_Has_UsuariosModel nuevaAsig = new Roles_Has_UsuariosModel();

    // cambiar contraseña

    @PostMapping("/cambiarcontrasena")
    public void cambiarContrasena(@RequestBody UsuariosModel usuariosModel) {
        usuarioService.cambiarContrasena(usuariosModel);
    }

    // Listar Tutores

    @GetMapping("/listatutores")
    public String listatutores() {
        ArrayList<UsuariosModel> dato = usuarioService.listaTutores();
        JSONArray arrayjs = new JSONArray(dato.toArray());
        if (!arrayjs.toString().isEmpty()) {
            return arrayjs.toString();
        } else {
            return "No hay registros";
        }
    }

    // Guardar Usuario
    @PostMapping("/guardarusuario")
    public String guardarUsuarios(@RequestBody UsuariosModel usuariosModel) {
        try {

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

            return "Usuario guardado con exito";

        } catch (Exception e) {
            System.out.println(e);
            return "No se guardo el usuario";
        }

    }

    // Login
    @PostMapping("/login")
    public ArrayList<RolesModel> login(@RequestBody UsuariosModel usuariosModel) {
        return usuarioService.login(usuariosModel.getUsuario(), usuariosModel.getContrasena());
    }

}
