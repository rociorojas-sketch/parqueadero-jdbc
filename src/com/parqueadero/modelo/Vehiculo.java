package com.parqueadero.modelo;

public class Vehiculo {

    private int id;
    private String placa;
    private String tipo;
    private String propietario;
    private String color;
    private String estado;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String tipo, String propietario, String color, String estado) {
        this.placa = placa;
        this.tipo = tipo;
        this.propietario = propietario;
        this.color = color;
        this.estado = estado;
    }

    public Vehiculo(int id, String placa, String tipo, String propietario, String color, String estado) {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.propietario = propietario;
        this.color = color;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
