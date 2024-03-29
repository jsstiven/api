package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UsuariosModel;

import jakarta.persistence.Tuple;

@Repository
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<UsuariosModel, Integer> {

    //Cambiar la contrasena
    @Query(value = "UPDATE usuarios set contrasena = :contrasena WHERE correo = :correo", nativeQuery = true)
    public UsuariosModel cambioContrasena(@Param("correo") String correo, @Param("contrasena") String contrasena );

    // listar tutores
    @Query(value = "select rhu.id as id, CONCAT(u.nombres, ' ', u.apellidos) as nombres, u.correo as correo, proac.nombre as programa from usuarios u join roles_has_usuarios rhu ON rhu.usuarios_cc = u.cc JOIN programaac proac ON proac.idprogramaac = u.programaid where rhu.roles_idroles = 2", nativeQuery = true)
    public ArrayList<Tuple> listarTutores();

    // login
    @Query(value = "select r.rol as rol from roles r join roles_has_usuarios rhu on r.idrol = rhu.roles_idroles join usuarios u on rhu.usuarios_cc = u.cc where u.usuario = :usuario and u.contrasena = :contrasena", nativeQuery = true)
    public ArrayList<Tuple> login(@Param("usuario") String usuario, @Param("contrasena") String contrasena);

    // Guardar usuario
    @Query(value = "INSERT INTO public.usuarios(cc, nombres, apellidos, correo, usuario, contrasena, programaid) VALUES (:cc, :nombres, :apellidos, :correo, :usuario, :contrasena, :programaid)", nativeQuery = true)
    public UsuariosModel guardarUsuario(@Param("cc") Integer cc, @Param("nombres") String nombres,
            @Param("apellidos") String apellidos, @Param("correo") String correo, @Param("usuario") String usuario,
            @Param("contrasena") String contrasena, @Param("programaid") Integer programaid);

    //listar roles
    @Query(value = "select idrol, rol from roles where idrol != 1", nativeQuery = true)
    public ArrayList<Tuple> listarRoles();

    //listar estudiantes
    @Query(value = "select u.cc as cedula, CONCAT(u.nombres, ' ', u.apellidos) as nombres, u.correo as correo, pac.nombre as programa from usuarios u JOIN roles_has_usuarios rhu ON rhu.usuarios_cc = u.cc JOIN programaac pac ON pac.idprogramaac = u.programaid where rhu.roles_idroles = 1 AND u.cc not in (select cc from usuarios u1 JOIN roles_has_usuarios rhu1 ON rhu1.usuarios_cc = u1.cc where rhu1.roles_idroles = 2 or rhu1.roles_idroles = 3)", nativeQuery = true)
    public ArrayList<Tuple> listarEstudiantes();

    //Listar Becarios
    @Query(value = "select rhu.id as idbecario, (select idrol from roles where idrol = rhu.roles_idroles) as idroles, (select rol from roles where idrol = rhu.roles_idroles) as rol , u.cc as cedula, CONCAT(u.nombres, ' ', u.apellidos) as nombres, (select nombre from programaac where idprogramaac = u.programaid) as programaacademico, u.correo as correo, u.usuario as usuario from usuarios u JOIN roles_has_usuarios rhu ON rhu.usuarios_cc = u.cc where rhu.roles_idroles = 2 or rhu.roles_idroles = 3", nativeQuery = true)
    public ArrayList<Tuple> listarBecarios();

    //Recordar el usuario
    @Query(value = "select usuario, correo from usuarios where cc = :cedula", nativeQuery = true)
    public ArrayList<Tuple> recordarUsuario(@Param("cedula") Integer cedula);

}
