package com.catolica.parqueos.backend.api.services;
import java.util.List;

import com.catolica.parqueos.backend.api.models.entity.Queja;

public interface IQuejaService {
	public List<Queja> listaQuejas();
	public List<Queja> findAll();

	public Queja save(Queja queja);

	public void delete(Long id);

	public Queja findById(Long Id);
}



