package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AsistenciaEsModel;

import jakarta.persistence.Tuple;

@Repository
@EnableJpaRepositories
public interface AsistenciaEsRepository extends JpaRepository<AsistenciaEsModel, Integer> {

    @Query(value = "select u.cc as cedula, u.nombres as nombres, u.apellidos as apellidos, ase.asignatura as asignatura, ase.tema as tema, ase.dia as fecha, ase.cces as cedulaEstudiante, (select nombres from usuarios where cc = ase.cces) as nombreEstudiante, (select apellidos from usuarios where cc = ase.cces) as apellidoEstudiante, (select nombre from programaac pac JOIN usuarios u ON u.programaid = pac.idprogramaac where u.cc =ase.cces) as programaAcademico, ca.puntuacion as puntuacion,  ca.comentarios as comentarios from asistenciases ase join roles_has_usuarios rhu ON rhu.id = ase.id_roles_has_usuarios join calificacion ca ON ca.id_roles_has_usuarios = rhu.id join usuarios u ON u.cc = rhu.usuarios_cc where ase.cces = ca.cces", nativeQuery = true)
    ArrayList<Tuple> reporteAsisEstudiantes();
}
