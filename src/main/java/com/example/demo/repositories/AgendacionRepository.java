package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AgendacionModel;

import jakarta.persistence.Tuple;

@Repository
@EnableJpaRepositories
public interface AgendacionRepository extends JpaRepository<AgendacionModel, Integer> {

    @Query(value = "select ag.idagendacion as idagendacion, u.cc as cedula, u.nombres as nombres, u.apellidos as apellidos, ag.tema as tema, ag.fecha as fecha, ag.hora as hora from agendacion ag join agendacion_has_roles_has_usuarios agrhu ON agrhu.agendacion_idagendacion = ag.idagendacion join roles_has_usuarios rhu ON rhu.id = agrhu.roles_has_usuarios join usuarios u ON u.cc = rhu.usuarios_cc where ag.activo = '1'", nativeQuery = true)
    ArrayList<Tuple> reporteAgendacion();

}
