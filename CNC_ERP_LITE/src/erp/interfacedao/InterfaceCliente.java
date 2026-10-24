/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfacedao;

import erp.model.Cliente;
import java.sql.ResultSet;
/**
 *
 * @author Alumno
 */
public interface InterfaceCliente extends InterfaceDAO<Cliente>{
    public Cliente convertir(ResultSet p);
    public Cliente mostrarId(int id);
    public Cliente mostrarNombre(String nombre);
}
