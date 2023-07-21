package com.example.demo.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
import com.example.demo.views.VistaBecarios;
import com.example.demo.views.VistaEstudiantes;
import com.example.demo.views.VistaUsuarios;

import jakarta.persistence.Tuple;

@RestController
@Controller
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")

public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    Roles_Has_UsuariosService rhuService = new Roles_Has_UsuariosService();
    @Autowired
    private JavaMailSender mail;

    // Recordar Usuario

    @PostMapping("/recordarusuario")
    public String recordarUsuario(@RequestBody UsuariosModel usuariosModel) {

        ArrayList<UsuariosModel> dato = usuarioService.recordarUsuario(usuariosModel);
        String usuario = "";
        String correo = "";

        try {

            for (UsuariosModel i : dato) {
                usuario = i.getUsuario();
                correo = i.getCorreo();
            }

            if (correo != null && usuario != null) {

                SimpleMailMessage email = new SimpleMailMessage();
                email.setTo(correo);
                email.setFrom("jsvasquezo23@gmail.com");
                email.setSubject("RECORDATORIO DE USUARIO");
                email.setText("Buen dia \n\nEstimado usuario le recordamos que su usuario actual es " + usuario
                        + " \n\nQue tenga buen dia");

                mail.send(email);

                return "Se envio el correo";

            } else {

                return "";

            }
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }

    }

    // cambiar contraseña

    @PostMapping("/cambiarcontrasena")
    public void cambiarContrasena(@RequestBody UsuariosModel usuariosModel) {
        usuarioService.cambiarContrasena(usuariosModel);
    }

    // Login
    @PostMapping("/login")
    public ArrayList<RolesModel> login(@RequestBody UsuariosModel usuariosModel) {
        return usuarioService.login(usuariosModel.getUsuario(), usuariosModel.getContrasena());
    }

    // Listar Tutores

    @GetMapping("/listatutores")
    public String listaTutores() {
        ArrayList<VistaEstudiantes> dato = usuarioService.listaTutores();
        JSONArray arrayjs = new JSONArray(dato.toArray());
        if (!arrayjs.toString().isEmpty()) {
            return arrayjs.toString();
        } else {
            return "No hay registros";
        }
    }

    // Listar Becarios

    @GetMapping("/listabecarios")
    public String listaBecarios() {
        ArrayList<VistaBecarios> dato = usuarioService.listaBecarios();
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
            return "";
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

    // Crear asignacion

    @PostMapping("/asignarbecario")
    public String crearBecario(@RequestBody Roles_Has_UsuariosModel roles_Has_UsuariosModel) {
        try {
            try {
                rhuService.guardarAsignacion(roles_Has_UsuariosModel);
            } catch (Exception e) {
                System.out.println("ERROR");
            }
            return "Se guardo correctamente el becario";
        } catch (Exception e) {
            return "";
        }
    }

    // Editar asignacion
    @PostMapping("/editarbecario")
    public String editarBecario(@RequestBody Roles_Has_UsuariosModel roles_Has_UsuariosModel) {
        try {
            try {
                rhuService.editarBecario(roles_Has_UsuariosModel);
            } catch (Exception e) {
                System.out.println("No trajo resultados");
            }
            return "se guardo correctamente";
        } catch (Exception e) {
            return "";
        }
    }

    // Eliminar

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
                nuevaAsig = new Roles_Has_UsuariosModel();
                usuariosModel = new UsuariosModel();
            } catch (Exception e) {
                System.out.println("error de no traer consulta");
            }

            return "Usuario guardado con exito";

        } catch (Exception e) {
            System.out.println(e);
            return "No se guardo el usuario";
        }

    }

    // Editar Usuario

}
