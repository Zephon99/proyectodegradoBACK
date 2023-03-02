package com.catolica.parqueos.backend.api.dao;

import com.catolica.parqueos.backend.api.models.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosDao extends JpaRepository<Usuarios,Long> {

    public Usuarios findUsuariosByUsuarioEmail(String email);

    public Usuarios findUsuariosByUsuarioId(Long id);

}
