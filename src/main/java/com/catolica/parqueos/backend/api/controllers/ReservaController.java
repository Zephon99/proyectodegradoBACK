package com.catolica.parqueos.backend.api.controllers;


import com.catolica.parqueos.backend.api.Response.Response;
import com.catolica.parqueos.backend.api.modelos.ReservaModel;
import com.catolica.parqueos.backend.api.modelos.UsuariosModel;
import com.catolica.parqueos.backend.api.models.entity.Reserva;
import com.catolica.parqueos.backend.api.models.entity.ReservaDia;
import com.catolica.parqueos.backend.api.models.entity.Usuarios;
import com.catolica.parqueos.backend.api.services.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private ReservaServiceImpl reservaService;
    @Autowired
    private ReservaController(ReservaServiceImpl reservaService){
        this.reservaService = reservaService;
    }

    @RequestMapping(
            value = "createReserva",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response createReserva(@RequestBody ReservaModel reservaModel){
        Response response = new Response();
        try{
            reservaService.createReserva(reservaModel);
        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getReservaByUserAndTimeAndLot",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getReservaByUserAndTimeAndLot(@RequestParam(name = "usuario_id") Long id,@RequestParam(name="espacio_parqueoid") Long espacio,@RequestParam (name = "horas_id")int horasId,@RequestParam (name="status") String status){
        Response response = new Response();

        try{

            Reserva reserva = reservaService.findReservaByUsuarioIdAndHorasIdAndEspacioParqueoidAndStatus(id,espacio,horasId,status);
            response.setData(reserva);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "getReservaByTimeAndStatus",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUsuarioByEmail(@RequestParam(name = "horas_id") int horasId,@RequestParam(name = "status") String status){
        Response response = new Response();

        try{

            ArrayList<Reserva> reservas= reservaService.findReservasByHorasIdAndStatus(horasId,status);
            response.setData(reservas);

        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(
            value = "updateReservaToDisable/{reserva_id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response updateReservaToDisable(@PathVariable("reserva_id") int id){
        Response response = new Response();
        try{
            reservaService.updateReservaStatusToDesactivado(id,"0");
        }catch (Exception e){
            response.setSuccess(false);
            response.setStatusMessage(e.getMessage());
        }
        return response;
    }

}
