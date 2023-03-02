package com.catolica.parqueos.backend.api.controllers;


import com.catolica.parqueos.backend.api.Response.Response;
import com.catolica.parqueos.backend.api.modelos.RegistroIncidentesModel;
import com.catolica.parqueos.backend.api.modelos.ReservaModel;
import com.catolica.parqueos.backend.api.services.RegistroIncidentesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registroIncidentes")
public class RegistroIncidentesController {


    private RegistroIncidentesServiceImpl registroIncidentesService;

    @Autowired
    public RegistroIncidentesController(RegistroIncidentesServiceImpl registroIncidentesService) {
        this.registroIncidentesService = registroIncidentesService;
    }


    @RequestMapping(
            value = "createIncidente",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response createIncidente(@RequestBody RegistroIncidentesModel registroIncidentesModel){
        Response response = new Response();
        try{
            registroIncidentesService.createRegistroIncidente(registroIncidentesModel);
        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }
}
