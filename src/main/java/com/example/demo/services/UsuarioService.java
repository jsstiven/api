package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.RolesModel;
import com.example.demo.models.UsuariosModel;
import com.example.demo.repositories.UsuarioRepository;

import jakarta.persistence.Tuple;

@Service

public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    // Listar Tutores

    public ArrayList<UsuariosModel> listaTutores() {
        ArrayList<UsuariosModel> dato = new ArrayList<UsuariosModel>();
        UsuariosModel u = new UsuariosModel();

        for (Tuple i : usuarioRepository.listarTutores()) {

            u.setCc((Integer) i.get("id"));
            u.setNombres((String) i.get("nombres"));
            u.setApellidos((String) i.get("apellidos"));

            dato.add(u);

            u = new UsuariosModel();
        }

        return dato;
    }

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

    // Guardar usuario
    public void guardarUsuarios(UsuariosModel usuariosModel) {
        usuarioRepository.guardarUsuario(usuariosModel.getCc(), usuariosModel.getNombres(),
                usuariosModel.getApellidos(), usuariosModel.getCorreo(), usuariosModel.getUsuario(),
                usuariosModel.getContrasena(), usuariosModel.getPrograma_id());
    }
}
