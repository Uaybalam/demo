package com.example.demo.model;

import jakarta.persistence.*;
@Entity
@Table(name = "localidad")
public class Localidad {
    @Id
    @Column(name = "clave", length = 2)
    private String clave;

    @Column(name = "estado", length = 4)
    private String estado;

    @Column(name = "descripcion")
    private String descripcion;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}