package com.catolica.parqueos.backend.api.dao;
import org.springframework.data.repository.CrudRepository;
import com.catolica.parqueos.backend.api.models.entity.EspacioParqueo;

import java.util.ArrayList;


public interface IEspacioParqueoDao extends CrudRepository<EspacioParqueo, Long>{

        public ArrayList<EspacioParqueo> findAll();



}

