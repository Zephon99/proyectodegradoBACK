package com.catolica.parqueos.backend.api.dao;

import com.catolica.parqueos.backend.api.models.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IVehiculoDao extends JpaRepository<Vehiculo,Integer> {

    public Vehiculo findVehiculoByVehiculoPlaca(String placa);


    public Vehiculo findVehiculoByUsuarioIdAndStatus(Long usuarioId,String status);

    public ArrayList<Vehiculo> findVehiculosByUsuarioId(Long usuarioId);


}
