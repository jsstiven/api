package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Roles_Has_UsuariosModel;
import com.example.demo.repositories.Roles_Has_UsuariosRepository;

@Service
public class Roles_Has_UsuariosService {
    @Autowired
    Roles_Has_UsuariosRepository rhuRepository;

    public void guardarAsignacion(Roles_Has_UsuariosModel rhuModel) {
        rhuRepository.guardarAsig(rhuModel.getRoles_idroles(), rhuModel.getUsuarios_cc());
    }
 
    public void editarAsignacion(Roles_Has_UsuariosModel rhuModel) {
        rhuRepository.editarAsig( rhuModel.getRoles_idroles(), rhuModel.getUsuarios_cc());
    }
}
