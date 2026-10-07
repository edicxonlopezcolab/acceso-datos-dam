package com.example;

import java.time.LocalDate;

public class EmpleadoModel 
{
    private String dni;
    private String nombre;
    private LocalDate fechaAlta;
    private double salarioMensual;
    private boolean activo;
    
    public EmpleadoModel()
    {

    }
    
    public EmpleadoModel(String dni, String nombre, LocalDate fechaAlta, double salarioMensual, boolean activo) 
    {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.salarioMensual = salarioMensual;
        this.activo = activo;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public double getSalarioMensual() {
        return salarioMensual;
    }
    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "EmpleadoModel [dni=" + dni + ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + ", salarioMensual="
                + salarioMensual + ", activo=" + activo + "]";
    }

    
}
