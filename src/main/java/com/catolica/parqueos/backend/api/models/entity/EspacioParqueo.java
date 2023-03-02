package com.catolica.parqueos.backend.api.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "espacios_parqueos")
public class EspacioParqueo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "espacio_parqueo_id")
	private Long espacioParqueoId;
	
	@Column(name = "espacio_parqueo_fechadisponible")
	private Date espacioParqueoFechaDisponible;
	
	@Column(name = "espacio_parqueo_nombre")
	private String espacioParqueoNombre;

	@Column(name = "espacio_parqueo_tamaño")
	private Integer espacioParqueoTamaño;

	@Column(name = "espacio_parqueo_tipo")
	private String espacioParqueoTipo;
	
	@Column(name = "parqueo_id")
	private Long parqueoId;

	public Long getEspacioParqueoId() {
		return espacioParqueoId;
	}

	public void setEspacioParqueoId(Long espacioParqueoId) {
		this.espacioParqueoId = espacioParqueoId;
	}

	public Date getEspacioParqueoFechaDisponible() {
		return espacioParqueoFechaDisponible;
	}

	public void setEspacioParqueoFechaDisponible(Date espacioParqueoFechaDisponible) {
		this.espacioParqueoFechaDisponible = espacioParqueoFechaDisponible;
	}

	public String getEspacioParqueoNombre() {
		return espacioParqueoNombre;
	}

	public void setEspacioParqueoNombre(String espacioParqueoNombre) {
		this.espacioParqueoNombre = espacioParqueoNombre;
	}

	public Integer getEspacioParqueoTamaño() {
		return espacioParqueoTamaño;
	}

	public void setEspacioParqueoTamaño(Integer espacioParqueoTamaño) {
		this.espacioParqueoTamaño = espacioParqueoTamaño;
	}

	public String getEspacioParqueoTipo() {
		return espacioParqueoTipo;
	}

	public void setEspacioParqueoTipo(String espacioParqueoTipo) {
		this.espacioParqueoTipo = espacioParqueoTipo;
	}

	public Long getParqueoId() {
		return parqueoId;
	}

	public void setParqueoId(Long parqueoId) {
		this.parqueoId = parqueoId;
	}
	
}
