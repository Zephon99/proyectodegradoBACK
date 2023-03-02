package com.catolica.parqueos.backend.api.services;

import com.catolica.parqueos.backend.api.dao.IReservaDao;
import com.catolica.parqueos.backend.api.modelos.ReservaModel;
import com.catolica.parqueos.backend.api.models.entity.Reserva;
import com.catolica.parqueos.backend.api.models.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReservaServiceImpl {

    private IReservaDao iReservaDao;

    @Autowired
    public ReservaServiceImpl(IReservaDao iReservaDao) {
        this.iReservaDao = iReservaDao;
    }

    public Reserva findReservaByIdReserva(int id){
        return iReservaDao.findReservaByReservaId(id);
    }

    public void createReserva(ReservaModel reservaModel){
        Reserva reserva = new Reserva();
        reserva.setEspacioParqueoid(reservaModel.getEspacioParqueoid());
        reserva.setHorasId(reservaModel.getHorasId());
        reserva.setUsuarioId(reservaModel.getUsuarioId());
        reserva.setStatus(reservaModel.getStatus());
        iReservaDao.save(reserva);

    }

    public Reserva findReservaByUsuarioIdAndHorasIdAndEspacioParqueoidAndStatus(Long usuarioId,Long espacioParqueoid,int horasId,String status){
        return iReservaDao.findReservaByUsuarioIdAndEspacioParqueoidAndHorasIdAndStatus(usuarioId,espacioParqueoid,horasId,status);
    }

    public void updateReservaStatusToDesactivado (int reservaId,String status){
        Reserva reserva = iReservaDao.findReservaByReservaIdAndStatus(reservaId,"1");
        reserva.setStatus("0");
        iReservaDao.save(reserva);
    }

    public ArrayList<Reserva> findReservasByHorasId(int horasId){
        return iReservaDao.findReservasByHorasId(horasId);
    }

    public ArrayList<Reserva> findReservasByHorasIdAndStatus(int horasId,String status){
        return iReservaDao.findReservasByHorasIdAndStatus(horasId,status);
    }
}
