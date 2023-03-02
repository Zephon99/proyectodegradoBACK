package com.catolica.parqueos.backend.api.dao;

import com.catolica.parqueos.backend.api.models.entity.Horas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface IHorasDao extends JpaRepository<Horas,Integer> {

    public Horas findHorasByHoras(String hora);

    public ArrayList<Horas> findAll();
}
