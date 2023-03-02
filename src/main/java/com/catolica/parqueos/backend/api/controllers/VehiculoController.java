package com.catolica.parqueos.backend.api.controllers;


import com.catolica.parqueos.backend.api.Response.Response;
import com.catolica.parqueos.backend.api.modelos.UsuariosModel;
import com.catolica.parqueos.backend.api.modelos.VehiculoModel;
import com.catolica.parqueos.backend.api.models.entity.Usuarios;
import com.catolica.parqueos.backend.api.models.entity.Vehiculo;
import com.catolica.parqueos.backend.api.services.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    private VehiculoServiceImpl vehiculoService;

    @Autowired
    public VehiculoController(VehiculoServiceImpl vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @RequestMapping(
            value = "createVehiculo",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response createVehiculo(@RequestBody VehiculoModel vehiculoModel){
        Response response = new Response();
        try{
            vehiculoService.createVehiculo(vehiculoModel);
        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getVehiculos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getVehiculos(){
        Response response = new Response();
        try{
            ArrayList<Vehiculo> vehiculos = vehiculoService.getVehiculos();
            response.setData(vehiculos);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getVehiculoByPlaca/{vehiculo_placa}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getVehiculoByVehiculoPlaca(@PathVariable("vehiculo_placa") String placa){
        Response response = new Response();
        System.out.println(placa);
        try{

            Vehiculo vehiculo = vehiculoService.findVehiculoByVehiculoPlaca(placa);
            response.setData(vehiculo);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getVehiculosByUsuarioIdAndStatus/{usuario_id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getVehiculosByUsuarioIdAndStatus(@PathVariable("usuario_id") Long usuarioId){
        Response response = new Response();
        System.out.println(usuarioId);
        try{

            Vehiculo vehiculo = vehiculoService.findVehiculoByUsuarioIdAndStatus(usuarioId,"activo");

            response.setData(vehiculo);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getVehiculosByUsuarioId/{usuario_id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getVehiculosByUsuarioId(@PathVariable("usuario_id") Long usuarioId){
        Response response = new Response();
        System.out.println(usuarioId);
        try{

            ArrayList<Vehiculo> vehiculos = vehiculoService.findVehiculosByUsuarioId(usuarioId);

            response.setData(vehiculos);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "updateVehiculoStatusToDesactivado/{usuario_id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response updateVehiculoStatusToDesactivado(@PathVariable("usuario_id") Long usuarioId){
        Response response = new Response();
        try{
            vehiculoService.updateVehiculoStatusToDesactivado(usuarioId);
        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "updateVehiculoStatusToActivado/{vehiculo_placa}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response updateVehiculoStatusToActivado(@PathVariable("vehiculo_placa") String placa){
        Response response = new Response();
        try{
            vehiculoService.updateVehiculoStatusToActivado(placa);
        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "updateVehiculoStatusToEliminado/{vehiculo_placa}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response updateVehiculoStatusToEliminado(@PathVariable("vehiculo_placa") String placa){
        Response response = new Response();
        try{
            vehiculoService.updateVehiculoStatusToEliminado(placa);
        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }
}
