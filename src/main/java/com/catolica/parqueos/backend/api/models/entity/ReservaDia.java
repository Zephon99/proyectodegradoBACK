package com.catolica.parqueos.backend.api.models.entity;

import java.util.List;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "reservas_dia")
public class ReservaDia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserva_dia_id")
	private Long reservaDiaId;
	
	@Column(name = "reserva_dia_costo")
	private Long reservaDiaCosto;
	
	@Column(name = "reserva_dia_estado")
	private String reservaDiaEstado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "reserva_dia_fecha")
	private Date reservaDiaFecha;

	@Column(name = "reserva_dia_hora_fin")
	private String reservaDiaHoraFin;
	
	@Column(name = "reserva_dia_hora_inicio")
	private String reservaDiaHoraInicio;
	
	@Column(name = "usuario_id")
	private Long usuarioId;

	@Column(name = "espacio_parqueo_id")
	private Long espacioParqueoId;


	
/*	 sum(reserva_dia_id), reserva_dia_fecha from reserva_dia 
	 where reserva_dia_estado='RESERVADO'
	 group by reserva_dia_fecha;
	 	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="rel_roles_users",schema = "riesgos", joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="rol_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","rol_id"})} )
	private List<Role> roles;
	 */


	public Long getReservaDiaId() {
		return reservaDiaId;
	}

	public void setReservaDiaId(Long reservaDiaId) {
		this.reservaDiaId = reservaDiaId;
	}

	public Long getReservaDiaCosto() {
		return reservaDiaCosto;
	}

	public void setReservaDiaCosto(Long reservaDiaCosto) {
		this.reservaDiaCosto = reservaDiaCosto;
	}

	public String getReservaDiaEstado() {
		return reservaDiaEstado;
	}

	public void setReservaDiaEstado(String reservaDiaEstado) {
		this.reservaDiaEstado = reservaDiaEstado;
	}

	public Date getReservaDiaFecha() {
		return reservaDiaFecha;
	}

	public void setReservaDiaFecha(Date reservaDiaFecha) {
		this.reservaDiaFecha = reservaDiaFecha;
	}

	public String getReservaDiaHoraFin() {
		return reservaDiaHoraFin;
	}

	public void setReservaDiaHoraFin(String reservaDiaHoraFin) {
		this.reservaDiaHoraFin = reservaDiaHoraFin;
	}

	public String getReservaDiaHoraInicio() {
		return reservaDiaHoraInicio;
	}

	public void setReservaDiaHoraInicio(String reservaDiaHoraInicio) {
		this.reservaDiaHoraInicio = reservaDiaHoraInicio;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getEspacioParqueoId() {
		return espacioParqueoId;
	}

	public void setEspacioParqueoId(Long espacioParqueoId) {
		this.espacioParqueoId = espacioParqueoId;
	}
}
