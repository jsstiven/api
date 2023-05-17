package com.example.demo.repositories;

import java.util.List;

import org.json.JSONException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CalificacionModel;


@Repository
@EnableJpaRepositories
public interface CalificacionRepositry extends JpaRepository<CalificacionModel, Integer>{
    
    @Query(value = "select json_build_object('CantidadPuntuacion', count(ca.puntuacion), 'Puntuacion', ca.puntuacion, 'fecha', ase.dia, 'Nombres', CONCAT(u.nombres, ' ', u.apellidos)) as datos from asistenciases ase join roles_has_usuarios rhu ON rhu.id = ase.id_roles_has_usuarios join calificacion ca ON ca.id_roles_has_usuarios = rhu.id join usuarios u ON u.cc = rhu.usuarios_cc where ase.cces = ca.cces group by ase.dia, ca.puntuacion, u.nombres, u.apellidos", nativeQuery = true)
    public List<Object> listarCalificacionDiaria() throws JSONException;

    @Query(value = "select json_build_object( 'CantidadPuntuacion', count(ca.puntuacion), 'Puntuacion', ca.puntuacion, 'Mes', to_char(ase.dia, 'TMMonth'), 'Nombres', CONCAT(u.nombres, ' ', u.apellidos)) from asistenciases ase join roles_has_usuarios rhu ON rhu.id = ase.id_roles_has_usuarios join calificacion ca ON ca.id_roles_has_usuarios = rhu.id join usuarios u ON u.cc = rhu.usuarios_cc where ase.cces = ca.cces group by ase.dia, ca.puntuacion, u.nombres, u.apellidos", nativeQuery = true)
    public List<Object> listarCalificacionMensual() throws JSONException;

}
