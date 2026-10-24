/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.mysqldao;

import erp.interfacedao.InterfaceEmpleado;
import erp.model.Empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author Alumno
 */
public class EmpleadoDAO implements InterfaceEmpleado{
    private Connection conn;
    private String crear;
    private String mostrar;
    private String mostrarId;
    private String mostrarNombre;
    private String actualizar;
    private String eliminar;

    public EmpleadoDAO(Connection conn) {
        this.conn = conn;
        crear = "INSERT INTO empleados (nombre, edad, telefono) VALUES (?, ?, ?)";
        mostrarId = "SELECT id, nombre, edad, telefono FROM empleados WHERE id = ?";
        mostrarNombre = "SELECT id, nombre, edad, telefono FROM empleados WHERE nombre = ?";
        mostrar = "SELECT id, nombre, edad, telefono FROM empleados";
        actualizar = "UPDATE empleados SET nombre = ?, edad = ?, telefono = ? WHERE id = ?";
        eliminar = "DELETE FROM empleados WHERE id = ?";
        
    }
    
    @Override
    public Empleado convertir(ResultSet p) {
        Empleado objEmpleado = null;
        try{
            int id = p.getInt("id");
            String nombre = p.getString("nombre");
            int edad = p.getInt("edad");
            String telefono = p.getString("telefono");
            
            objEmpleado = new Empleado(id, nombre, edad, telefono);
            
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        return objEmpleado;
    }

    @Override
    public Empleado mostrarId(int id) {
        Empleado objEmpleado = null;
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarId)){
            p.setInt(1, id);
            r = p.executeQuery();
            if(r.next()){
                objEmpleado = convertir(r);
            }
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        return objEmpleado;
    }

    @Override
    public Empleado mostrarNombre(String nombre) {
        Empleado objEmpleado = null;
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarNombre)){
            p.setString(1, nombre);
            r = p.executeQuery();
            if(r.next()){
                objEmpleado = convertir(r);
            }
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        return objEmpleado;
    }

    @Override
    public void crear(Empleado a) {
        try(PreparedStatement p = conn.prepareStatement(crear)){
            p.setString(1, a.getNombre());
            p.setInt(2, a.getEdad());
            p.setString(3, a.getTelefono());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Empleado> mostrar() {
        ArrayList<Empleado> objArrayEmpleado = new ArrayList<>();
        try(PreparedStatement p = conn.prepareStatement(mostrar);
            ResultSet r = p.executeQuery()){
            while(r.next()){
                objArrayEmpleado.add(convertir(r));
            }
            
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        return objArrayEmpleado;
    }

    @Override
    public void actualizar(Empleado a) {
        try(PreparedStatement p = conn.prepareStatement(actualizar)){
            p.setString(1, a.getNombre());
            p.setInt(2, a.getEdad());
            p.setString(3, a.getTelefono());
            p.setInt(4, a.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Empleado a) {
        try(PreparedStatement p = conn.prepareStatement(eliminar)){
            p.setInt(1, a.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }
    
}
