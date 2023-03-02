package com.catolica.parqueos.backend.api.services;
import java.util.ArrayList;
import java.util.List;

import com.catolica.parqueos.backend.api.models.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catolica.parqueos.backend.api.dao.IEspacioParqueoDao;
import com.catolica.parqueos.backend.api.models.entity.EspacioParqueo;

	@Service
	public class EspacioParqueoServiceImpl implements IEspacioParqueoService{

		@Autowired
		private IEspacioParqueoDao espacioParqueoDao;

		@Override
		@Transactional(readOnly = true)
		public List<EspacioParqueo> findAll() {

			return (List<EspacioParqueo>) espacioParqueoDao.findAll();
		}

		@Override
		@Transactional
		public EspacioParqueo save(EspacioParqueo parqueo) {

			return espacioParqueoDao.save(parqueo);
		}

		@Override
		@Transactional
		public void delete(Long id) {
			espacioParqueoDao.deleteById(id);
		}

		@Override
		@Transactional(readOnly = true)
		public EspacioParqueo findById(Long Id) {
			return espacioParqueoDao.findById(Id).orElse(null);

		}

		public ArrayList<EspacioParqueo> getEspacioParqueos(){
			return (ArrayList<EspacioParqueo>) espacioParqueoDao.findAll();
		}



	}


