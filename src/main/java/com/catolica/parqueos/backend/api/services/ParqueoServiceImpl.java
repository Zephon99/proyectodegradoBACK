package com.catolica.parqueos.backend.api.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catolica.parqueos.backend.api.dao.IParqueosDao;
import com.catolica.parqueos.backend.api.models.entity.Parqueo;

	@Service
	public class ParqueoServiceImpl implements IParqueoService{

		@Autowired
		private IParqueosDao parqueoDao;

		@Override
		@Transactional(readOnly = true)
		public List<Parqueo> findAll() {

			return (List<Parqueo>) parqueoDao.findAll();
		}

		@Override
		@Transactional
		public Parqueo save(Parqueo parqueo) {

			return parqueoDao.save(parqueo);
		}

		@Override
		@Transactional
		public void delete(Long id) {
			parqueoDao.deleteById(id);
		}

		@Override
		@Transactional(readOnly = true)
		public Parqueo findById(Long Id) {
			return parqueoDao.findById(Id).orElse(null);

		}


	}


