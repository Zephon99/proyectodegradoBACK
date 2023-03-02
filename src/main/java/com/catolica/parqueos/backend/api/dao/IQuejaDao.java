package com.catolica.parqueos.backend.api.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catolica.parqueos.backend.api.models.entity.Queja;

@Repository
public interface IQuejaDao extends CrudRepository<Queja, Long>{
	@Query(value ="SELECT q.queja_id, concat(u.nombre,' ',u.apellido), q.queja_description, q.queja_date_registration FROM `quejas` q inner join usuarios u WHERE q.usuario_id=u.usuario_id;", nativeQuery = true)
	 public List<Queja> listaQuejas();
}


