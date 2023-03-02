package com.catolica.parqueos.backend.api.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quejas")
public class Queja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "queja_id")
	private Long quejaId;
	
	@Column(name = "usuario_id")
	private Long usuarioId;
	
	@Column(name = "queja_description")
	private String quejaDescription;

	@Column(name = "queja_date_registration")
	private Date quejaDateRegistration;
	
	public Long getQuejaId() {
		return quejaId;
	}

	public void setQuejaId(Long quejaId) {
		this.quejaId = quejaId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getQuejaDescription() {
		return quejaDescription;
	}

	public void setQuejaDescription(String quejaDescription) {
		this.quejaDescription = quejaDescription;
	}

	public Date getQuejaDateRegistration() {
		return quejaDateRegistration;
	}

	public void setQuejaDateRegistration(Date quejaDateRegistration) {
		this.quejaDateRegistration = quejaDateRegistration;
	}
	
	
}
