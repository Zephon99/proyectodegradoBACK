package com.catolica.parqueos.backend.api.services;

import com.catolica.parqueos.backend.api.dao.IHorasDao;
import com.catolica.parqueos.backend.api.modelos.HorasModel;
import com.catolica.parqueos.backend.api.models.entity.Horas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HorasServiceImpl {
    IHorasDao iHorasDao;

    @Autowired
    public HorasServiceImpl(IHorasDao iHorasDao) {
        this.iHorasDao = iHorasDao;
    }

    public void createHoras(HorasModel horasModel){
        Horas horas = new Horas();
        horas.setHoras(horasModel.getHoras());
        iHorasDao.save(horas);
    }

    public ArrayList<Horas> findAll(){
        return  iHorasDao.findAll();
    }

    public Horas findHorasbyHoras(String hora){
        return  iHorasDao.findHorasByHoras(hora);
    }
}
