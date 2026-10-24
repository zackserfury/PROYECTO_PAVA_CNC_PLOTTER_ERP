/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.model;

import java.time.LocalDate;

/**
 *
 * @author Alumno
 */
public class Insumo {
    private int id;
    private String marca;
    private String nombreInsumo;
    private float precio;
    private int cantidadPiezas;
    private LocalDate fechaRegistro;
    private int numeroEstanteria;

    public Insumo() {
    }

    public Insumo(int id, String marca, String nombreInsumo, float precio, int cantidadPiezas, LocalDate fechaRegistro, int numeroEstanteria) {
        this.id = id;
        this.marca = marca;
        this.nombreInsumo = nombreInsumo;
        this.precio = precio;
        this.cantidadPiezas = cantidadPiezas;
        this.fechaRegistro = fechaRegistro;
        this.numeroEstanteria = numeroEstanteria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidadPiezas() {
        return cantidadPiezas;
    }

    public void setCantidadPiezas(int cantidadPiezas) {
        this.cantidadPiezas = cantidadPiezas;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getNumeroEstanteria() {
        return numeroEstanteria;
    }

    public void setNumeroEstanteria(int numeroEstanteria) {
        this.numeroEstanteria = numeroEstanteria;
    }

    @Override
    public String toString() {
        return "Insumo{" + "id=" + id + ", marca=" + marca + ", nombreInsumo=" + nombreInsumo + ", precio=" + precio + ", cantidadPiezas=" + cantidadPiezas + ", fechaRegistro=" + fechaRegistro + ", numeroEstanteria=" + numeroEstanteria + '}';
    }
    
    
}
