package com.catolica.parqueos.backend.api.dao;
import org.springframework.data.repository.CrudRepository;
import com.catolica.parqueos.backend.api.models.entity.Parqueo;

public interface IParqueosDao extends CrudRepository<Parqueo, Long>{

}

