package com.catolica.parqueos.backend.api.modelos;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class ReservaDiaModel {

    private Long reservaDiaId;


    private Long reservaDiaCosto;


    private String reservaDiaEstado;


    private Date reservaDiaFecha;


    private String reservaDiaHoraFin;


    private String reservaDiaHoraInicio;


    private Long usuarioId;

    private Long espacioParqueoId;


    public Long getEspacioParqueoId() {
        return espacioParqueoId;
    }

    public void setEspacioParqueoId(Long espacioParqueoId) {
        this.espacioParqueoId = espacioParqueoId;
    }

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
}
