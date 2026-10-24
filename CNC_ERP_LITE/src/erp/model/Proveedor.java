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
public class Proveedor {
    private int id;
    private String telefono;
    private String nombreProveedor;
    private LocalDate fechaRegistro;
    private String direccion;

    public Proveedor() {
    }

    public Proveedor(int id, String telefono, String nombreProveedor, LocalDate fechaRegistro, String direccion) {
        this.id = id;
        this.telefono = telefono;
        this.nombreProveedor = nombreProveedor;
        this.fechaRegistro = fechaRegistro;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", telefono=" + telefono + ", nombreProveedor=" + nombreProveedor + ", fechaRegistro=" + fechaRegistro + ", direccion=" + direccion + '}';
    }

    
    
}
