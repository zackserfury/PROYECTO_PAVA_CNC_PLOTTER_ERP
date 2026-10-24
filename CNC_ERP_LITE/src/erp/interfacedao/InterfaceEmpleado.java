/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfacedao;

import erp.model.Empleado;
import java.sql.ResultSet;
/**
 *
 * @author Alumno
 */
public interface InterfaceEmpleado extends InterfaceDAO<Empleado>{
    public Empleado convertir(ResultSet p);
    public Empleado mostrarId(int id);
    public Empleado mostrarNombre(String nombre);
}
