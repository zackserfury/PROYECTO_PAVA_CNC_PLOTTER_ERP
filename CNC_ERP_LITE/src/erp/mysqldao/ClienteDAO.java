/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.mysqldao;

import erp.interfacedao.InterfaceCliente;
import erp.model.Cliente;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author Alumno
 */
public class ClienteDAO implements InterfaceCliente{
    private Connection conn;
    private String crear;
    private String mostrar;
    private String mostrarId;
    private String mostrarNombre;
    private String actualizar;
    private String eliminar;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
        crear = "INSERT INTO clientes (nombre, telefono, direccion, fecha_visita) VALUES (?, ?, ?, ?)";
        mostrar = "SELECT id, nombre, telefono, direccion, fecha_visita FROM clientes";
        mostrarId = "SELECT id, nombre, telefono, direccion, fecha_visita FROM clientes WHERE id = ?";
        mostrarNombre = "SELECT id, nombre, telefono, direccion, fecha_visita FROM clientes WHERE nombre = ?";
        actualizar = "UPDATE clientes SET nombre = ?, telefono = ?, direccion = ?, fecha_visita = ? WHERE id = ?";
        eliminar = "DELETE FROM clientes WHERE id = ?";
    }
    
    
    @Override
    public Cliente convertir(ResultSet p) {
        Cliente objCliente = null;
        try{
            int id = p.getInt("id");
            String nombre = p.getString("nombre");
            String telefono = p.getString("telefono");
            String direccion = p.getString("direccion");
            LocalDate fechaRegistro = p.getDate("fecha_visita").toLocalDate();
            
            objCliente = new Cliente(id, nombre, telefono, direccion, fechaRegistro);
        }catch(SQLException e){
            System.err.println("Error al convertir los datos" + e.getMessage());
        }
        return objCliente;
    }

    @Override
    public Cliente mostrarId(int id) {
        Cliente objCliente = null;
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarId)){
            p.setInt(1, id);
            r = p.executeQuery();
            if(r.next()){
                objCliente = convertir(r);
            }
        }catch(SQLException e){
            System.err.println("Error al momento de mostrar los datos" + e.getMessage());
        }
        if(r != null){
            try{
                r.close();
            }catch(SQLException e){
                System.err.println("Error al cerrar el recurso ResultSet" + e.getMessage());
            }  
        }
        return objCliente;
    }

    @Override
    public Cliente mostrarNombre(String nombre) {
        Cliente objCliente = null;
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarNombre)){
            p.setString(1, nombre);
            r = p.executeQuery();
            if(r.next()){
                objCliente = convertir(r);
            }
        }catch(SQLException e){
            System.err.println("Error al momento de mostrar los datos" + e.getMessage());
        }
        if(r != null){
            try{
                r.close();
            }catch(SQLException e){
                System.err.println("Error al cerrar el recurso ResultSet" + e.getMessage());
            }  
        }
        return objCliente;
    }

    @Override
    public void crear(Cliente a) {
        try(PreparedStatement p = conn.prepareStatement(crear)){
            p.setString(1, a.getNombre());
            p.setString(2, a.getTelefono());
            p.setString(3, a.getDireccion());
            p.setDate(4, Date.valueOf(a.getFechaVisita()));
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al crear los datos" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Cliente> mostrar() {
        ArrayList<Cliente> objArrayCliente;
        objArrayCliente = new ArrayList();
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrar)){
            r = p.executeQuery();
            while(r.next()){
                objArrayCliente.add(convertir(r));
            }
        }catch(SQLException e){
            System.err.println("Error al momento de mostrar los datos");
        }
        if(r != null){
            try{
                r.close();
            }catch(SQLException e){
                System.err.println("Error al cerrar el recurso ResultSet");
            }  
        }
        return objArrayCliente;
    }

    @Override
    public void actualizar(Cliente a) {
        try(PreparedStatement p = conn.prepareStatement(actualizar)){
            p.setString(1, a.getNombre());
            p.setString(2, a.getTelefono());
            p.setString(3, a.getDireccion());
            p.setDate(4, Date.valueOf(a.getFechaVisita()));
            p.setInt(5, a.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al modificar los datos" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Cliente a) {
        try(PreparedStatement p = conn.prepareStatement(eliminar)){
           p.setInt(1, a.getId());
           p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al eliminar elemento" + e.getMessage());
        }
    }
    
    
}
