package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Agendacion_Has_Roles_Has_UsuariosModel;
import com.example.demo.repositories.Agendacion_Has_Roles_Has_UsuariosRepository;

@Service

public class Agendacion_Has_Roles_Has_UsuariosService {
    @Autowired
    Agendacion_Has_Roles_Has_UsuariosRepository agrhuRepository;

    //Guardar asignacion agenda

    public void guardarAsigAgenda(Integer idtutor){
        agrhuRepository.guardArasig(idtutor);
    }

    public void editarAsigAgenda(Agendacion_Has_Roles_Has_UsuariosModel ahru){
        agrhuRepository.editarAsig(ahru.getRoles_has_usuarios(), ahru.getAgendacion_idagendacion());
    }


}
