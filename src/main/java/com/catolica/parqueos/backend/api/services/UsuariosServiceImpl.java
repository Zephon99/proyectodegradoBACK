package com.catolica.parqueos.backend.api.services;

import com.catolica.parqueos.backend.api.dao.IUsuariosDao;
import com.catolica.parqueos.backend.api.modelos.UsuariosModel;
import com.catolica.parqueos.backend.api.models.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
public class UsuariosServiceImpl {
    private IUsuariosDao iUsuariosDao;

    @Autowired
    public void UsuariosServiceImpl (IUsuariosDao iUsuariosDao){
        this.iUsuariosDao = iUsuariosDao;
    }



    public void createUser (UsuariosModel usuariosModel){
        Usuarios usuarios = new Usuarios();
        usuarios.setUsuarioCod(usuariosModel.getUsuarioCod());
        usuarios.setUsuarioEmail(usuariosModel.getUsuarioEmail());
        usuarios.setUsuarioPassword(usuariosModel.getUsuarioPassword());
        usuarios.setUsuarioTipo(usuariosModel.getUsuarioTipo());
        usuarios.setFecha(usuariosModel.getFecha());
        usuarios.setCelular(usuariosModel.getCelular());
        usuarios.setInstitucionId(usuariosModel.getInstitucionId());
        usuarios.setPersonaId(usuariosModel.getPersonaId());
        usuarios.setNombre(usuariosModel.getNombre());
        usuarios.setApellido(usuariosModel.getApellido());
        usuarios.setCi(usuariosModel.getCi());
        iUsuariosDao.save(usuarios);


    }

    public Usuarios findUsuarioByEmail(String email){
        return iUsuariosDao.findUsuariosByUsuarioEmail(email);
    }

    public Usuarios findUsuarioById(Long id){
        return iUsuariosDao.findUsuariosByUsuarioId(id);
    }




    public ArrayList<Usuarios> getUsuarios() {
        return (ArrayList<Usuarios>)iUsuariosDao.findAll();
    }


}
