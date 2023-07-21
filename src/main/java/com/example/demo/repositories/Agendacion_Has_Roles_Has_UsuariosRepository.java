package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Agendacion_Has_Roles_Has_UsuariosModel;

@Repository
@EnableJpaRepositories
public interface Agendacion_Has_Roles_Has_UsuariosRepository extends JpaRepository<Agendacion_Has_Roles_Has_UsuariosModel, Integer> {
    

    @Query(value = "INSERT INTO public.agendacion_has_roles_has_usuarios(agendacion_idagendacion, roles_has_usuarios) VALUES ((select idagendacion from agendacion where idagendacion = (select MAX(idagendacion) from agendacion)), :idtutor)", nativeQuery = true)
    public void guardArasig(@Param("idtutor") Integer idtutor);

    @Query(value = "UPDATE public.agendacion_has_roles_has_usuarios SET roles_has_usuarios = :idtutor where agendacion_idagendacion = :idagendar", nativeQuery = true)
    public void editarAsig(@Param("idtutor") Integer idTutor, @Param("idagendar") Integer idAgendar);
}
