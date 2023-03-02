package com.catolica.parqueos.backend.api.controllers;

import com.catolica.parqueos.backend.api.Response.Response;
import com.catolica.parqueos.backend.api.modelos.UsuariosModel;
import com.catolica.parqueos.backend.api.models.entity.Usuarios;
import com.catolica.parqueos.backend.api.services.UsuariosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private UsuariosServiceImpl usuariosServiceImpl;

    @Autowired
    public void UsuariosController(UsuariosServiceImpl usuariosServiceImpl){
        this.usuariosServiceImpl = usuariosServiceImpl;
    }

    @RequestMapping(
            value = "createUsuarios",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response createUsuarios(@RequestBody UsuariosModel usuariosModel){
        Response response = new Response();
        try{
            usuariosServiceImpl.createUser(usuariosModel);
        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getUsuarios",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUsuarios(){
        Response response = new Response();
        try{
            ArrayList<Usuarios> usuarios = usuariosServiceImpl.getUsuarios();
            response.setData(usuarios);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getUsuarioByEmail/{usuario_email}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUsuarioByEmail(@PathVariable("usuario_email") String email){
        Response response = new Response();
        System.out.println(email);
        try{

            Usuarios usuarios = usuariosServiceImpl.findUsuarioByEmail(email);
            System.out.println("ID USUARIO:"+usuarios.getUsuarioId());
            response.setData(usuarios);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getUsuarioById/{usuario_id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUsuarioById(@PathVariable("usuario_id") Long id){
        Response response = new Response();
        System.out.println(id);
        try{

            Usuarios usuarios = usuariosServiceImpl.findUsuarioById(id);
            System.out.println("ID USUARIO:"+usuarios.getUsuarioId());
            response.setData(usuarios);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }
}
