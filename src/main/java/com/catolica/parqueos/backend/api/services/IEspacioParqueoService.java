package com.catolica.parqueos.backend.api.services;
import java.util.List;

import com.catolica.parqueos.backend.api.models.entity.EspacioParqueo;

public interface IEspacioParqueoService {
	public List<EspacioParqueo> findAll();

	public EspacioParqueo save(EspacioParqueo espacioParqueo);

	public void delete(Long id);

	public EspacioParqueo findById(Long Id);
}



