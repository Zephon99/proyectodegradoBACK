package com.catolica.parqueos.backend.api.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "horas")
public class Horas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "horas_id")
    private int horasId;

    @Column(name = "horas")
    private String horas;

    public int getHorasId() {
        return horasId;
    }

    public void setHorasId(int horasId) {
        this.horasId = horasId;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }
}
