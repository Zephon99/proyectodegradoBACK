package com.catolica.parqueos.backend.api.services;

import com.catolica.parqueos.backend.api.dao.IUsuariosDao;
import com.catolica.parqueos.backend.api.dao.IVehiculoDao;
import com.catolica.parqueos.backend.api.modelos.UsuariosModel;
import com.catolica.parqueos.backend.api.modelos.VehiculoModel;
import com.catolica.parqueos.backend.api.models.entity.Usuarios;
import com.catolica.parqueos.backend.api.models.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VehiculoServiceImpl {
    IVehiculoDao iVehiculoDao;
    IUsuariosDao iUsuariosDao;

    @Autowired
    public void VehiculosServiceImpl (IVehiculoDao iVehiculoDao,IUsuariosDao iUsuariosDao){
        this.iVehiculoDao = iVehiculoDao;
        this.iUsuariosDao = iUsuariosDao;

    }

    public void createVehiculo (VehiculoModel vehiculoModel){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehiculoColor(vehiculoModel.getVehiculoColor());
        vehiculo.setVehiculoMarca(vehiculoModel.getVehiculoMarca());
        vehiculo.setVehiculoPlaca(vehiculoModel.getVehiculoPlaca());
        vehiculo.setUsuarioId(vehiculoModel.getUsuarioId());
        vehiculo.setStatus(vehiculoModel.getStatus());
        iVehiculoDao.save(vehiculo);
    }

    public void updateVehiculoStatusToDesactivado (Long usuarioId){
        Vehiculo vehiculo = iVehiculoDao.findVehiculoByUsuarioIdAndStatus(usuarioId,"activo");
        vehiculo.setStatus("desactivado");
        iVehiculoDao.save(vehiculo);
    }


    public void updateVehiculoStatusToActivado (String placa){

        Vehiculo vehiculo = iVehiculoDao.findVehiculoByVehiculoPlaca(placa);
        vehiculo.setStatus("activo");
        iVehiculoDao.save(vehiculo);
    }

    public void updateVehiculoStatusToEliminado (String placa){

        Vehiculo vehiculo = iVehiculoDao.findVehiculoByVehiculoPlaca(placa);
        vehiculo.setStatus("eliminado");
        iVehiculoDao.save(vehiculo);
    }



    public ArrayList<Vehiculo> getVehiculos(){
        return (ArrayList<Vehiculo>) iVehiculoDao.findAll();
    }

    public Vehiculo findVehiculoByVehiculoPlaca(String vehiculoPlaca){
        return iVehiculoDao.findVehiculoByVehiculoPlaca(vehiculoPlaca);
    }

    public Vehiculo findVehiculoByUsuarioIdAndStatus(Long usuarioId,String status){
        return iVehiculoDao.findVehiculoByUsuarioIdAndStatus(usuarioId,status);
    }

    public ArrayList<Vehiculo> findVehiculosByUsuarioId(Long usuarioId){
        return iVehiculoDao.findVehiculosByUsuarioId(usuarioId);
    }


}
