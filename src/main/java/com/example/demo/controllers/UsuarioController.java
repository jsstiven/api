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
import com.example.demo.views.VistaEstudiantes;
import com.example.demo.views.VistaUsuarios;

@RestController
@Controller
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")

public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    Roles_Has_UsuariosService rhuService = new Roles_Has_UsuariosService();

    // cambiar contraseña

    @PostMapping("/cambiarcontrasena")
    public void cambiarContrasena(@RequestBody UsuariosModel usuariosModel) {
        usuarioService.cambiarContrasena(usuariosModel);
    }

    // Listar Tutores

    @GetMapping("/listatutores")
    public String listaTutores() {
        ArrayList<UsuariosModel> dato = usuarioService.listaTutores();
        JSONArray arrayjs = new JSONArray(dato.toArray());
        if (!arrayjs.toString().isEmpty()) {
            return arrayjs.toString();
        } else {
            return "No hay registros";
        }
    }

    // Listar Roles

    @GetMapping("/listaroles")
    public String listaRoles() {
        ArrayList<RolesModel> dato = usuarioService.listaRoles();
        JSONArray arrayjs = new JSONArray(dato.toArray());
        if (!arrayjs.toString().isEmpty()) {
            return arrayjs.toString();
        } else {
            return "No hay registros";
        }
    }

    // Listar Estudiantes

    @GetMapping("/listaestudiantes")
    public String listaEstudiantes() {
        ArrayList<VistaEstudiantes> dato = usuarioService.listaEstudiantes();
        JSONArray arrayjs = new JSONArray(dato.toArray());
        if (!arrayjs.toString().isEmpty()) {
            return arrayjs.toString();
        } else {
            return "No hay registros";
        }
    }

    // Guardar Usuario
    @PostMapping("/guardarusuario")
    public String guardarUsuarios(@RequestBody VistaUsuarios vistaUsuarios) {

        Roles_Has_UsuariosModel nuevaAsig = new Roles_Has_UsuariosModel();
        UsuariosModel usuariosModel = new UsuariosModel();
        try {

            nuevaAsig.setRoles_idroles(vistaUsuarios.getRoles_idroles());
            nuevaAsig.setUsuarios_cc(vistaUsuarios.getCc());

            usuariosModel.setCc(vistaUsuarios.getCc());
            usuariosModel.setNombres(vistaUsuarios.getNombres());
            usuariosModel.setApellidos(vistaUsuarios.getApellidos());
            usuariosModel.setUsuario(vistaUsuarios.getUsuario());
            usuariosModel.setCorreo(vistaUsuarios.getCorreo());
            usuariosModel.setContrasena(vistaUsuarios.getContrasena());
            usuariosModel.setPrograma_id(vistaUsuarios.getPrograma_id());

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
