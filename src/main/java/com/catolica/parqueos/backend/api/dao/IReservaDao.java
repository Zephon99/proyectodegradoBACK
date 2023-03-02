package com.catolica.parqueos.backend.api.dao;

import com.catolica.parqueos.backend.api.models.entity.Reserva;
import com.fasterxml.classmate.types.ResolvedRecursiveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IReservaDao extends JpaRepository<Reserva,Integer> {
    public Reserva findReservaByReservaId(int id);

    public Reserva findReservaByUsuarioIdAndEspacioParqueoidAndHorasIdAndStatus(Long usuarioId,Long espacioParqueoid,int horasId,String status);

    public ArrayList<Reserva> findReservasByHorasId(int horasId);

    public ArrayList<Reserva>findReservasByHorasIdAndStatus(int horasId,String status);

    public Reserva findReservaByReservaIdAndStatus(int id,String status);
}
