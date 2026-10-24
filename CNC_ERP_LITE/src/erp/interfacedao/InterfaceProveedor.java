/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfacedao;

import erp.model.Proveedor;
import java.sql.ResultSet;

/**
 *
 * @author Alumno
 */
public interface InterfaceProveedor extends InterfaceDAO<Proveedor>{
    public Proveedor convertir(ResultSet p);
    public Proveedor mostrarId(int id);
    public Proveedor mostrarNombre(String nombre);
}
