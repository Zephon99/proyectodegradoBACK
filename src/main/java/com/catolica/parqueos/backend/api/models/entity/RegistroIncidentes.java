package com.catolica.parqueos.backend.api.models.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "control_incidentes")
public class RegistroIncidentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_control_incidente")
    private Long idControlIncidente;

    @Column(name = "id_usuario_originante")
    private Long idUsuarioOriginante;

    @Column(name = "id_usuario_destinante")
    private Long idUsuarioDestinante;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "estado")
    private boolean estado;


    public Long getIdControlIncidente() {
        return idControlIncidente;
    }

    public void setIdControlIncidente(Long idControlIncidente) {
        this.idControlIncidente = idControlIncidente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
