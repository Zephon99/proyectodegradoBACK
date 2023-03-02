package com.catolica.parqueos.backend.api.services;
import java.util.List;

import com.catolica.parqueos.backend.api.models.entity.Parqueo;

public interface IParqueoService {
	public List<Parqueo> findAll();

	public Parqueo save(Parqueo parqueo);

	public void delete(Long id);

	public Parqueo findById(Long Id);
}



