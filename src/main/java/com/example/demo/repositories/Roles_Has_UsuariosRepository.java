package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Roles_Has_UsuariosModel;

@Repository
@EnableJpaRepositories
public interface Roles_Has_UsuariosRepository extends JpaRepository<Roles_Has_UsuariosModel, Integer> {

    @Query(value = "INSERT INTO public.roles_has_usuarios(roles_idroles, usuarios_cc) VALUES (:roles_idroles, :usuarios_cc)", nativeQuery = true)
    public Roles_Has_UsuariosModel guardarAsig(@Param("roles_idroles") Integer roles_idroles,
            @Param("usuarios_cc") Integer usuarios_cc);

    @Query(value = "UPDATE public.roles_has_usuarios SET roles_idroles= :roles_idroles WHERE id = (select id from roles_has_usuarios where usuarios_cc = :usuarios_cc and roles_idroles != 1)", nativeQuery = true)
    public Roles_Has_UsuariosModel editarAsig(@Param("roles_idroles") Integer roles_idroles,
            @Param("usuarios_cc") Integer usuarios_cc);
            
}
