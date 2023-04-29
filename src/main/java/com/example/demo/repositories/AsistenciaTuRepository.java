package com.example.demo.repositories;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import jakarta.persistence.Tuple;
import com.example.demo.models.asistenciaTuModel;

@Repository
@EnableJpaRepositories
public interface AsistenciaTuRepository extends JpaRepository<asistenciaTuModel, Integer> {

    @Query(value = "select u.nombres as nombres, u.apellidos as apellidos, u.cc as cedula, CAST(ast.entrada as TIME) as entrada, CAST(ast.salida as TIME) as salida, ast.fecha as fecha from asistenciatu ast join roles_has_usuarios rhu ON rhu.id = ast.id_roles_has_usuarios join usuarios u on u.cc = rhu.usuarios_cc where rhu.roles_idroles = 2", nativeQuery = true)
    ArrayList<Tuple> reporteBecarios();
    
}
