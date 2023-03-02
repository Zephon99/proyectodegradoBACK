package com.catolica.parqueos.backend.api.modelos;

public class ReservaModel {
    private int reservaId;
    private Long usuarioId;
    private Long espacioParqueoid;
    private int horasId;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getEspacioParqueoid() {
        return espacioParqueoid;
    }

    public void setEspacioParqueoid(Long espacioParqueoid) {
        this.espacioParqueoid = espacioParqueoid;
    }

    public int getHorasId() {
        return horasId;
    }

    public void setHorasId(int horasId) {
        this.horasId = horasId;
    }
}
