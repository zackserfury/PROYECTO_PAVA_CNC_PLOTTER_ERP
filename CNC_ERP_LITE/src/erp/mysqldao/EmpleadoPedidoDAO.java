/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.mysqldao;

import erp.interfacedao.InterfaceEmpleadoPedido;
import erp.model.Empleado;
import erp.model.Pedido;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
/**
 *
 * @author Alumno
 */
public class EmpleadoPedidoDAO implements InterfaceEmpleadoPedido{
    private Connection conn;
    private String create;
    private String readOne;
    private String readTwo;
    private String delete;
    
    public EmpleadoPedidoDAO(Connection conn) {
        this.conn = conn;
        create = "INSERT INTO empleados_pedidos (id_empleados, id_pedidos) VALUES (?,?)";
        readOne = "SELECT p.* FROM pedidos p INNER JOIN empleados_pedidos ep ON p.id = ep.id_pedidos WHERE ep.id_empleados = ?";
        readTwo = "SELECT e.* FROM empleados e INNER JOIN empleados_pedidos ep ON e.id = ep.id_empleados WHERE ep.id_pedidos = ?";
        delete = "DELETE FROM empleados_pedidos WHERE id_empleados = ? AND id_pedidos = ?";
        
    }
    
    
    public Empleado convertirEmpleado(ResultSet r){
        Empleado objEmpleado = null;
        try{
           int id = r.getInt("id");
           String nombre = r.getString("nombre");
           int edad = r.getInt("edad");
           String telefono = r.getString("telefono");
           
           objEmpleado = new Empleado(id, nombre, edad, telefono);
           
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        
        return objEmpleado;
    }
    
    public Pedido convertirPedido(ResultSet r){
        Pedido objPedido = null;
        try{
           int id = r.getInt("id");
           LocalDate fechaRegistro = r.getDate("fecha_registro").toLocalDate();
           LocalDate fechaEntrega = r.getDate("fecha_entrega").toLocalDate();
           float precio = r.getFloat("precio_total");
           int idCliente = r.getInt("id_clientes");
           
           objPedido = new Pedido(id, fechaRegistro, fechaEntrega, precio, idCliente);
           
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        
        return objPedido;
    }
    
    
    @Override
    public void create(Empleado a, Pedido b) {
        try(PreparedStatement p = conn.prepareStatement(create)){
            p.setInt(1, a.getId());
            p.setInt(2, b.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Pedido> readOne(Empleado a) {
        ArrayList<Pedido> objArrayPedido = new ArrayList<>();

    try (PreparedStatement p = conn.prepareStatement(readOne)) {

        p.setInt(1, a.getId());

        try (ResultSet r = p.executeQuery()) {

            while (r.next()) {     
                objArrayPedido.add(convertirPedido(r));
            }

        }

    } catch (SQLException e) {
        System.err.println("ERROR " + e.getMessage());
    }

    return objArrayPedido;
    }

    @Override
    public ArrayList<Empleado> readTwo(Pedido b) {
        ArrayList<Empleado> objArrayEmpleado = new ArrayList<>();

    try (PreparedStatement p = conn.prepareStatement(readTwo)) {

        p.setInt(1, b.getId());

        try (ResultSet r = p.executeQuery()) {

            while (r.next()) {                
                objArrayEmpleado.add(convertirEmpleado(r));
            }

        }

    } catch (SQLException e) {
        System.err.println("ERROR " + e.getMessage());
    }

    return objArrayEmpleado;
    }

    @Override
    public void delete(Empleado a, Pedido b) {
        try (PreparedStatement p = conn.prepareStatement(delete)) {

        p.setInt(1, a.getId());
        p.setInt(2, b.getId());

        p.executeUpdate();

    } catch (SQLException e) {
        System.err.println("ERROR " + e.getMessage());
    }
    }

    
    
}
