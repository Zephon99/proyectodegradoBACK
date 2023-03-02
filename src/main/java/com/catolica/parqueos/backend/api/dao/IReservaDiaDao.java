package com.catolica.parqueos.backend.api.dao;
import java.util.ArrayList;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catolica.parqueos.backend.api.models.entity.ReservaDia;

@Repository
public interface IReservaDiaDao extends CrudRepository<ReservaDia, Long>{
	 
	@Query(value ="SELECT * FROM reservas_dia", nativeQuery = true)
	 public List<ReservaDia> search2();
		
	@Query(value ="SELECT r.reserva_dia_fecha FROM reservas_dia r where r.reserva_dia_estado='RESERVADO' group by r.reserva_dia_fecha;", nativeQuery = true)
	 public List<Object> cantidadFechasReservas();
	
	@Query(value ="SELECT count(r.reserva_dia_id) FROM reservas_dia r where r.reserva_dia_estado='RESERVADO' group by r.reserva_dia_fecha;", nativeQuery = true)
	 public List<Object> cantidadDiasReservas();

	@Query(value ="SELECT count(r.reserva_dia_id)\r\n"
			+ "from reservas_dia r inner join espacios_parqueos e on r.espacio_parqueo_id=e.espacio_parqueo_id \r\n"
			+ "where reserva_dia_estado='RESERVADO' \r\n"
			+ "group by e.espacio_parqueo_nombre;", nativeQuery = true)
	 public List<Object> cantidadReservasParqueo();
	
	@Query(value ="SELECT e.espacio_parqueo_nombre\r\n"
			+ "from reservas_dia r inner join espacios_parqueos e on r.espacio_parqueo_id=e.espacio_parqueo_id \r\n"
			+ "where reserva_dia_estado='RESERVADO' \r\n"
			+ "group by e.espacio_parqueo_nombre;", nativeQuery = true)
	 public List<Object> cantidadParqueoReservas();
	
	
	@Query(value ="SELECT count(r.reserva_dia_id) FROM reservas_dia r  where r.reserva_dia_estado='RESERVADO' group by extract(MONTH FROM r.reserva_dia_fecha);", nativeQuery = true)
	 public List<Object> cantidadReservasMes();
	
	@Query(value ="SELECT MONTHNAME(  r.reserva_dia_fecha)\r\n"
			+ "FROM reservas_dia r \r\n"
			+ "where r.reserva_dia_estado='RESERVADO' \r\n"
			+ "group by MONTHNAME(r.reserva_dia_fecha);", nativeQuery = true)
	 public List<Object> cantidadMesReserva();


	public ArrayList<ReservaDia> findReservaDiaByReservaDiaHoraInicioAndReservaDiaEstado(String reservaDiaHoraInicio,String estado);


}


