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
    @Query(value = "select rhu.id as id, u.nombres as nombres, u.apellidos as apellidos from usuarios u join roles_has_usuarios rhu ON rhu.usuarios_cc = u.cc where rhu.roles_idroles = 2", nativeQuery = true)
    public ArrayList<Tuple> listarTutores();

    // login
    @Query(value = "select r.rol as rol from roles r join roles_has_usuarios rhu on r.idrol = rhu.roles_idroles join usuarios u on rhu.usuarios_cc = u.cc where u.usuario = :usuario and u.contrasena = :contrasena", nativeQuery = true)
    public ArrayList<Tuple> login(@Param("usuario") String usuario, @Param("contrasena") String contrasena);

    // Guardar usuario
    @Query(value = "INSERT INTO public.usuarios(cc, nombres, apellidos, correo, usuario, contrasena, programaid) VALUES (:cc, :nombres, :apellidos, :correo, :usuario, :contrasena, :programaid)", nativeQuery = true)
    public UsuariosModel guardarUsuario(@Param("cc") Integer cc, @Param("nombres") String nombres,
            @Param("apellidos") String apellidos, @Param("correo") String correo, @Param("usuario") String usuario,
            @Param("contrasena") String contrasena, @Param("programaid") Integer programaid);
}
