package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AsistenciaEsModel;

import jakarta.persistence.Tuple;

@Repository
@EnableJpaRepositories
public interface AsistenciaEsRepository extends JpaRepository<AsistenciaEsModel, Integer> {

    @Query(value = "select u.cc as cedulatutor, roles_has_usuarios.id as cedula, ca.idcalificacion as idCalificacion, ase.idasistenciases as idAsistencia, CONCAT(u.nombres, ' ', u.apellidos) as nombresTutor, ase.asignatura as asignatura, ase.tema as tema, ase.grupo,ase.dia as fecha, ase.cces as cedulaEstudiante, (select CONCAT(nombres, ' ', apellidos) from usuarios where cc = ase.cces) as nombresEstudiante, (select nombre from programaac pac JOIN usuarios u ON u.programaid = pac.idprogramaac where u.cc =ase.cces) as programaAcademico, ca.puntuacion as puntuacion, ca.comentarios as comentarios from calificacion ca join asistenciases ase ON ase.idasistenciases = ca.idasistenciases join roles_has_usuarios ON roles_has_usuarios.id = ase.id_roles_has_usuarios join usuarios u ON u.cc = roles_has_usuarios.usuarios_cc where ase.cces = ca.cces", nativeQuery = true)
    ArrayList<Tuple> reporteAsisEstudiantes();

    @Query(value = "UPDATE public.asistenciases SET asignatura = :asignatura, grupo = :grupo, dia = :fecha, id_roles_has_usuarios = :idtutor, tema = :tema, cces = :cedulaestudiante WHERE idasistenciases = :idasistencia", nativeQuery = true)
    ArrayList<Tuple> editarAsisEstudiantes(@Param("asignatura") String asignatura, @Param("grupo") String grupo,
            @Param("fecha") Date dia, @Param("idtutor") Integer idTutot, @Param("tema") String tema,
            @Param("cedulaestudiante") Integer cedulaEstudiante, @Param("idasistencia") Integer idAsistencia);
}
