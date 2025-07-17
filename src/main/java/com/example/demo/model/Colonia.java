package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "colonia")
public class Colonia {
    @Id
    @Column(name = "clave", length = 4)
    private String clave;

    @Column(name = "cp", length = 6)
    private String cp;

    @Column(name = "descripcion")
    private String descripcion;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}