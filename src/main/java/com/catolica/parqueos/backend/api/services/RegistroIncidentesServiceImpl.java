package com.catolica.parqueos.backend.api.services;

import com.catolica.parqueos.backend.api.dao.IRegistroIncidentesDao;
import com.catolica.parqueos.backend.api.modelos.RegistroIncidentesModel;
import com.catolica.parqueos.backend.api.models.entity.RegistroIncidentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroIncidentesServiceImpl {

    private IRegistroIncidentesDao iRegistroIncidentesDao;


    @Autowired
    public RegistroIncidentesServiceImpl(IRegistroIncidentesDao iRegistroIncidentesDao) {
        this.iRegistroIncidentesDao = iRegistroIncidentesDao;
    }

    public void createRegistroIncidente(RegistroIncidentesModel registroIncidentesModel){
        RegistroIncidentes registroIncidentes = new RegistroIncidentes();
        registroIncidentes.setIdUsuarioOriginante(registroIncidentesModel.getIdUsuarioOriginante());
        registroIncidentes.setIdUsuarioDestinante(registroIncidentesModel.getIdUsuarioDestinante());
        registroIncidentes.setFecha(registroIncidentesModel.getFecha());
        registroIncidentes.setHora(registroIncidentesModel.getHora());
        registroIncidentes.setEstado(registroIncidentesModel.isEstado());
        iRegistroIncidentesDao.save(registroIncidentes);

    }
}
