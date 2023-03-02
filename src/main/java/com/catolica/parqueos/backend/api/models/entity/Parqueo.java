package com.catolica.parqueos.backend.api.models.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "parqueos")
public class Parqueo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parqueo_id")
	private Long parqueoId;
	
	@Column(name = "institucion_id")
	private Long institucionId;
	
	@Column(name = "parqueo_capacidad")
	private String parqueoCapacidad;

	@Column(name = "parqueo_lugar")
	private String parqueoLugar;

	@Column(name = "parqueo_nombre")
	private String parqueoNombre;
	
	@Column(name = "parqueo_tamaño")
	private Integer parqueoTamaño;

	public Long getParqueoId() {
		return parqueoId;
	}

	public void setParqueoId(Long parqueoId) {
		this.parqueoId = parqueoId;
	}

	public Long getInstitucionId() {
		return institucionId;
	}

	public void setInstitucionId(Long institucionId) {
		this.institucionId = institucionId;
	}

	public String getParqueoCapacidad() {
		return parqueoCapacidad;
	}

	public void setParqueoCapacidad(String parqueoCapacidad) {
		this.parqueoCapacidad = parqueoCapacidad;
	}

	public String getParqueoLugar() {
		return parqueoLugar;
	}

	public void setParqueoLugar(String parqueoLugar) {
		this.parqueoLugar = parqueoLugar;
	}

	public String getParqueoNombre() {
		return parqueoNombre;
	}

	public void setParqueoNombre(String parqueoNombre) {
		this.parqueoNombre = parqueoNombre;
	}

	public Integer getParqueoTamaño() {
		return parqueoTamaño;
	}

	public void setParqueoTamaño(Integer parqueoTamaño) {
		this.parqueoTamaño = parqueoTamaño;
	}
	
}





	

