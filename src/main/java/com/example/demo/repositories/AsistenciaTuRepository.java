package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.models.asistenciaTuModel;

@Repository
@EnableJpaRepositories
public interface AsistenciaTuRepository extends JpaRepository<asistenciaTuModel, Integer> {

    @Query(value = "INSERT INTO public.asistenciatu(id_roles_has_usuarios, datos) VALUES (:idTutor, cast(:datos AS json))", nativeQuery = true)
    void guaradarAsistenciaTu(@Param("datos") String datos, @Param("idTutor") Integer idTutor);

    @Query(value = "SELECT  json_build_object('id', idasistenciatu , 'datos', datos,'nombre_tutor', (select CONCAT(nombres, ' ', apellidos) from usuarios where cc = rhu.usuarios_cc)) FROM asistenciatu ast JOIN roles_has_usuarios rhu ON rhu.id = ast.id_roles_has_usuarios", nativeQuery = true)
    List<Object> reporteBecarios();

}
