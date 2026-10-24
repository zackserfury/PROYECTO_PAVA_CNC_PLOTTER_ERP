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
public class Pedido {
    private int id;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrega;
    private float precioTotal;
    private int idClientes;

    public Pedido() {
    }

    public Pedido(int id, LocalDate fechaRegistro, LocalDate fechaEntrega, float precioTotal, int idClientes) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.fechaEntrega = fechaEntrega;
        this.precioTotal = precioTotal;
        this.idClientes = idClientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "id=" + id + ", fechaRegistro=" + fechaRegistro + ", fechaEntrega=" + fechaEntrega + ", precioTotal=" + precioTotal + ", idClientes=" + idClientes + '}';
    }
    
    
    
}
