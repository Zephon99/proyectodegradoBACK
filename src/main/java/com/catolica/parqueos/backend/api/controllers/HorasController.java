package com.catolica.parqueos.backend.api.controllers;


import com.catolica.parqueos.backend.api.Response.Response;
import com.catolica.parqueos.backend.api.modelos.HorasModel;
import com.catolica.parqueos.backend.api.modelos.VehiculoModel;
import com.catolica.parqueos.backend.api.models.entity.Horas;
import com.catolica.parqueos.backend.api.models.entity.Vehiculo;
import com.catolica.parqueos.backend.api.services.HorasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/horas")
public class HorasController {

    HorasServiceImpl horasService;

    @Autowired
    public HorasController(HorasServiceImpl horasService) {
        this.horasService = horasService;
    }




    @RequestMapping(
            value = "createHora",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response createHora(@RequestBody HorasModel horasModel){
        Response response = new Response();
        try{
            horasService.createHoras(horasModel);
        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getHoras",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getHoras(){
        Response response = new Response();
        try{
            ArrayList<Horas> horas = horasService.findAll();
            response.setData(horas);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getHorasByHora/{horas}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getHorasByHora(@PathVariable("horas") String horas){
        Response response = new Response();

        try{

            Horas horas1 = horasService.findHorasbyHoras(horas);
            response.setData(horas1);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }
}
