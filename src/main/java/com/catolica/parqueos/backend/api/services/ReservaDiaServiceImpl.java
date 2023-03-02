package com.catolica.parqueos.backend.api.services;
import java.util.ArrayList;
import java.util.List;

import com.catolica.parqueos.backend.api.modelos.ReservaDiaModel;
import com.catolica.parqueos.backend.api.modelos.ReservaModel;
import com.catolica.parqueos.backend.api.models.entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catolica.parqueos.backend.api.dao.IReservaDiaDao;
import com.catolica.parqueos.backend.api.models.entity.ReservaDia;

	@Service
	public class ReservaDiaServiceImpl implements IReservaDiaService{

		@Autowired
		private IReservaDiaDao reservaDiaDao;
		
		/*@Override
		@Transactional(readOnly = true)
		public List<ReservaDiaVista> search() {
			
			return (List<ReservaDiaVista>) reservaDiaDao.search();
		}*/
		@Override
		@Transactional(readOnly = true)
		public List<Object> cantidadFechasReservas() {
			
			return (List<Object>) reservaDiaDao.cantidadFechasReservas();
		}
		@Override
		@Transactional(readOnly = true)
		public List<Object> cantidadDiasReservas() {
			
			return (List<Object>) reservaDiaDao.cantidadDiasReservas();
		}
		
		@Override
		@Transactional(readOnly = true)
		public List<Object> cantidadReservasParqueo() {
			
			return (List<Object>) reservaDiaDao.cantidadReservasParqueo();
		}
		
		@Override
		@Transactional(readOnly = true)
		public List<Object> cantidadParqueoReservas() {
			
			return (List<Object>) reservaDiaDao.cantidadParqueoReservas();
		}
		
		@Override
		@Transactional(readOnly = true)
		public List<Object> cantidadReservasMes() {
			
			return (List<Object>) reservaDiaDao.cantidadReservasMes();
		}
		@Override
		@Transactional(readOnly = true)
		public List<Object> cantidadMesReserva() {
			
			return (List<Object>) reservaDiaDao.cantidadMesReserva();
		}
		@Override
		@Transactional(readOnly = true)
		public List<ReservaDia> search2() {
			
			return (List<ReservaDia>) reservaDiaDao.search2();
		}
		
		
		@Override
		@Transactional(readOnly = true)
		public List<ReservaDia> findAll() {
			
			return (List<ReservaDia>) reservaDiaDao.findAll();
		}
		@Override
		@Transactional
		public ReservaDia save(ReservaDia parqueo) {

			return reservaDiaDao.save(parqueo);
		}

		@Override
		@Transactional
		public void delete(Long id) {
			reservaDiaDao.deleteById(id);
		}

		@Override
		@Transactional(readOnly = true)
		public ReservaDia findById(Long Id) {
			return reservaDiaDao.findById(Id).orElse(null);

		}


		public ArrayList<ReservaDia> findReservaDiaByReservaDiaHoraInicioAndReservaDiaEstado(String reservaHoraInicio,String estado){
			return reservaDiaDao.findReservaDiaByReservaDiaHoraInicioAndReservaDiaEstado(reservaHoraInicio,estado);
		}

		public void createReservaDia(ReservaDiaModel reservaDiaModel){
			ReservaDia reservaDia = new ReservaDia();
			reservaDia.setUsuarioId(reservaDiaModel.getUsuarioId());
			reservaDia.setReservaDiaEstado(reservaDiaModel.getReservaDiaEstado());
			reservaDia.setReservaDiaCosto(reservaDiaModel.getReservaDiaCosto());
			reservaDia.setReservaDiaHoraFin(reservaDiaModel.getReservaDiaHoraFin());
			reservaDia.setReservaDiaHoraInicio(reservaDiaModel.getReservaDiaHoraInicio());
			reservaDia.setReservaDiaFecha(reservaDiaModel.getReservaDiaFecha());
			reservaDia.setEspacioParqueoId(reservaDiaModel.getEspacioParqueoId());
			reservaDiaDao.save(reservaDia);

		}
	}


