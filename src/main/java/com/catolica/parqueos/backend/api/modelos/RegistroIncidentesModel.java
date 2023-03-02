package com.catolica.parqueos.backend.api.modelos;

import javax.persistence.Column;
import java.util.Date;

public class RegistroIncidentesModel {

    private Long idControlIncidente;


    private Long idUsuarioOriginante;


    private Long idUsuarioDestinante;


    private String fecha;


    private String hora;

    private boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getIdControlIncidente() {
        return idControlIncidente;
    }

    public void setIdControlIncidente(Long idControlIncidente) {
        this.idControlIncidente = idControlIncidente;
    }

    public Long getIdUsuarioOriginante() {
        return idUsuarioOriginante;
    }

    public void setIdUsuarioOriginante(Long idUsuarioOriginante) {
        this.idUsuarioOriginante = idUsuarioOriginante;
    }

    public Long getIdUsuarioDestinante() {
        return idUsuarioDestinante;
    }

    public void setIdUsuarioDestinante(Long idUsuarioDestinante) {
        this.idUsuarioDestinante = idUsuarioDestinante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
