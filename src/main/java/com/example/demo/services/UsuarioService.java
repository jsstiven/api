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
