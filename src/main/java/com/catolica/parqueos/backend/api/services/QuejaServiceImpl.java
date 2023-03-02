package com.catolica.parqueos.backend.api.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catolica.parqueos.backend.api.dao.IQuejaDao;
import com.catolica.parqueos.backend.api.models.entity.Queja;

	@Service
	public class QuejaServiceImpl implements IQuejaService{

		@Autowired
		private IQuejaDao quejaDao;
		@Override
		@Transactional(readOnly = true)
		public List<Queja> listaQuejas() {
			
			return (List<Queja>) quejaDao.listaQuejas();
		}
		@Override
		@Transactional(readOnly = true)
		public List<Queja> findAll() {

			return (List<Queja>) quejaDao.findAll();
		}

		@Override
		@Transactional
		public Queja save(Queja queja) {

			return quejaDao.save(queja);
		}

		@Override
		@Transactional
		public void delete(Long id) {
			quejaDao.deleteById(id);
		}

		@Override
		@Transactional(readOnly = true)
		public Queja findById(Long Id) {
			return quejaDao.findById(Id).orElse(null);

		}
	}


