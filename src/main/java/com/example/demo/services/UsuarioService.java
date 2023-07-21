package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.RolesModel;
import com.example.demo.models.Roles_Has_UsuariosModel;
import com.example.demo.models.UsuariosModel;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.views.VistaBecarios;
import com.example.demo.views.VistaEstudiantes;

import jakarta.persistence.Tuple;

@Service

public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // Login
    public ArrayList<RolesModel> login(String usuario, String contrasena) {

        ArrayList<RolesModel> dato = new ArrayList<RolesModel>();
        RolesModel r = new RolesModel();

        for (Tuple i : usuarioRepository.login(usuario, contrasena)) {
            r.setRol((String) i.get("rol"));
            dato.add(r);
            r = new RolesModel();
        }

        return dato;
    }

    // cambiar contraseña
    public void cambiarContrasena(UsuariosModel usuariosModel) {
        try {
            usuarioRepository.cambioContrasena(usuariosModel.getCorreo(), usuariosModel.getContrasena());
        } catch (Exception e) {
            System.out.println("no trae consulta");
        }
    }

    //Recordar Usuario
    public ArrayList<UsuariosModel> recordarUsuario(UsuariosModel usuariosModel) {
        ArrayList<UsuariosModel> dato = new ArrayList<UsuariosModel>();
        UsuariosModel u = new UsuariosModel();

        for (Tuple i : usuarioRepository.recordarUsuario(usuariosModel.getCc())) {

            u.setUsuario((String) i.get("usuario"));
            u.setCorreo((String) i.get("correo"));

            dato.add(u);

            u = new UsuariosModel();
        }

        return dato;
    }



    // listar Roles
    public ArrayList<RolesModel> listaRoles() {
        ArrayList<RolesModel> dato = new ArrayList<RolesModel>();
        RolesModel r = new RolesModel();

        for (Tuple i : usuarioRepository.listarRoles()) {

            r.setIdrol((Integer) i.get("idrol"));
            r.setRol((String) i.get("rol"));

            dato.add(r);

            r = new RolesModel();
        }

        return dato;
    }

    // Listar Becarios

    public ArrayList<VistaBecarios> listaBecarios() {
        ArrayList<VistaBecarios> dato = new ArrayList<VistaBecarios>();
        VistaBecarios b = new VistaBecarios();

        for (Tuple i : usuarioRepository.listarBecarios()) {

            b.setIdBecario((Integer) i.get("idbecario"));
            b.setIdRoles((Integer) i.get("idroles"));
            b.setRol((String) i.get("rol"));
            b.setCedula((Integer) i.get("cedula"));
            b.setNombres((String) i.get("nombres"));
            b.setProgramaAcademico((String) i.get("programaacademico"));
            b.setCorreo((String) i.get("correo"));
            b.setUsuario((String) i.get("usuario"));

            dato.add(b);

            b = new VistaBecarios();
        }

        return dato;
    }

    // Listar Tutores

    public ArrayList<VistaEstudiantes> listaTutores() {
        ArrayList<VistaEstudiantes> dato = new ArrayList<VistaEstudiantes>();
        VistaEstudiantes u = new VistaEstudiantes();

        for (Tuple i : usuarioRepository.listarTutores()) {

            u.setCedula((Integer) i.get("id"));
            u.setNombres((String) i.get("nombres"));
            u.setCorreo((String) i.get("correo"));
            u.setPrograma((String) i.get("programa"));

            dato.add(u);

            u = new VistaEstudiantes();
        }

        return dato;
    }

    // Listar Estudiantes

    public ArrayList<VistaEstudiantes> listaEstudiantes() {
        ArrayList<VistaEstudiantes> dato = new ArrayList<VistaEstudiantes>();
        VistaEstudiantes e = new VistaEstudiantes();

        for (Tuple i : usuarioRepository.listarEstudiantes()) {

            e.setCedula((Integer) i.get("cedula"));
            e.setNombres((String) i.get("nombres"));
            e.setCorreo((String) i.get("correo"));
            e.setPrograma((String) i.get("programa"));

            dato.add(e);

            e = new VistaEstudiantes();
        }

        return dato;
    }

    // Guardar usuario
    public void guardarUsuarios(UsuariosModel usuariosModel) {
        usuarioRepository.guardarUsuario(usuariosModel.getCc(), usuariosModel.getNombres(),
                usuariosModel.getApellidos(), usuariosModel.getCorreo(), usuariosModel.getUsuario(),
                usuariosModel.getContrasena(), usuariosModel.getPrograma_id());
    }
}
