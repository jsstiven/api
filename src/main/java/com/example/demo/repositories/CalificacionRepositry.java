package com.example.demo.repositories;

import java.util.List;

import org.json.JSONException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CalificacionModel;

@Repository
@EnableJpaRepositories
public interface CalificacionRepositry extends JpaRepository<CalificacionModel, Integer> {

    @Query(value = "insert into public.calificacion(comentarios, puntuacion, cces, id_roles_has_usuarios, idasistenciases) values (:comentarios, :puntuacion, :cedulaes, :rhu, (select max(es.idasistenciases) from asistenciases es))", nativeQuery = true)
    public void guardarCalificacion(@Param("comentarios") String comentarios, @Param("puntuacion") Integer puntuacion,
            @Param("cedulaes") Integer cedulaes, @Param("rhu") Integer rhu);

    @Query(value = "select json_build_object('Promedio', cast(sum(ca.puntuacion) as decimal)/cast(count(ca.puntuacion) as decimal), 'Fecha', es.dia, 'Nombres', CONCAT(u.nombres, ' ', u.apellidos) ) from calificacion ca join asistenciases es ON es.idasistenciases = ca.idasistenciases join roles_has_usuarios ON roles_has_usuarios.id = es.id_roles_has_usuarios join usuarios u ON u.cc = roles_has_usuarios.usuarios_cc group by es.dia, es.id_roles_has_usuarios, u.nombres, u.apellidos", nativeQuery = true)
    public List<Object> listarCalificacionDiaria() throws JSONException;

    @Query(value = "select json_build_object('Promedio', cast(sum(ca.puntuacion) as float)/cast(count(ca.puntuacion) as float), 'Mes', to_char(es.dia, 'TMMonth')) from calificacion ca join asistenciases es ON es.idasistenciases = ca.idasistenciases where ca.id_roles_has_usuarios = :idtutor group by to_char(es.dia, 'TMMonth'), es.id_roles_has_usuarios", nativeQuery = true)
    public List<Object> listarCalificacionMensual(@Param("idtutor") Integer idTutor) throws JSONException;

}
