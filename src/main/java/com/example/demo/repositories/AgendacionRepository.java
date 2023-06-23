package com.example.demo.repositories;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AgendacionModel;

import jakarta.persistence.Tuple;

@Repository
@EnableJpaRepositories
public interface AgendacionRepository extends JpaRepository<AgendacionModel, Integer> {

    @Query(value = "UPDATE public.agendacion SET activo= :activo WHERE idagendacion = :idAgendacion", nativeQuery = true)
    AgendacionModel cancelarTutoria(@Param("activo") Boolean activo, @Param("idAgendacion") Integer idAgendacion);

    @Query(value = "UPDATE public.agendacion SET fecha=:fecha, hora=:hora WHERE idagendacion = :idAgendacion", nativeQuery = true)
    AgendacionModel editarAgenda(@Param("fecha") Date fecha, @Param("hora") Time hora,
            @Param("idAgendacion") Integer idAgendacion);

    @Query(value = "select ag.idagendacion as idagendacion, u.cc as cedulatutor, CONCAT(u.nombres, ' ', u.apellidos) AS nombretutor, (select cc from usuarios where cc = ag.cces) as cedulaestudiante, (select CONCAT(nombres, ' ', apellidos) from usuarios where cc = ag.cces) as nombreestudiante, ag.tema as tema, ag.fecha as fecha, ag.hora as hora from agendacion ag join agendacion_has_roles_has_usuarios agrhu ON agrhu.agendacion_idagendacion = ag.idagendacion join roles_has_usuarios rhu ON rhu.id = agrhu.roles_has_usuarios join usuarios u ON u.cc = rhu.usuarios_cc where ag.activo = '1'", nativeQuery = true)
    ArrayList<Tuple> reporteAgendacion();

}
