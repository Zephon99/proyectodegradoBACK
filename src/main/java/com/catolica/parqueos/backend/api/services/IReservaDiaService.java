package com.catolica.parqueos.backend.api.services;
import java.util.List;

import com.catolica.parqueos.backend.api.models.entity.ReservaDia;

public interface IReservaDiaService {

	public List<Object> cantidadReservasMes();
	public List<Object> cantidadMesReserva();
	public List<Object> cantidadParqueoReservas();
	
	public List<Object> cantidadReservasParqueo();
	
	public List<Object> cantidadDiasReservas();
	
	public List<Object> cantidadFechasReservas();
	
	public List<ReservaDia> findAll();
	
	
	public List<ReservaDia> search2();
	
	public ReservaDia save(ReservaDia reservaDia);

	public void delete(Long id);

	public ReservaDia findById(Long Id);
}



