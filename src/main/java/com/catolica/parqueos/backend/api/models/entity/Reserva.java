package com.catolica.parqueos.backend.api.models.entity;


import javax.persistence.*;

@Entity
@Table (name="reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private int reservaId;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "espacio_parqueoid")
    private Long espacioParqueoid;

    @Column(name = "horas_id")
    private int horasId;

    @Column(name= "status")
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
