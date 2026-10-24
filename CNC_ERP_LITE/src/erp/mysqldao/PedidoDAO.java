/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.mysqldao;

import erp.interfacedao.InterfacePedido;
import erp.model.Pedido;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Date;
/**
 *
 * @author Alumno
 */
public class PedidoDAO implements InterfacePedido{
    private Connection conn;
    private String crear;
    private String mostrar;
    private String mostrarId;
    private String mostrarFecha;
    private String actualizar;
    private String eliminar;
    
    public PedidoDAO(Connection conn){
        this.conn = conn;
        crear = "INSERT INTO pedidos(fecha_registro, fecha_entrega, precio_total, id_clientes) VALUES (?, ?, ?, ?)";
        mostrar = "SELECT id, fecha_registro, fecha_entrega, precio_total, id_clientes FROM pedidos";
        mostrarId = "SELECT id, fecha_registro, fecha_entrega, precio_total, id_clientes FROM pedidos WHERE id = ?";
        mostrarFecha = "SELECT id, fecha_registro, fecha_entrega, precio_total, id_clientes FROM pedidos WHERE fecha_registro = ?";
        actualizar = "UPDATE pedidos SET fecha_entrega = ?, precio_total = ? WHERE id = ?";
        eliminar = "DELETE FROM pedidos WHERE id = ?";
    }
            
    
    @Override
    public Pedido convertir(ResultSet p) {
        Pedido objPedido = null;
        try{
            int id = p.getInt("id");
            LocalDate fechaRegistro = p.getDate("fecha_registro").toLocalDate();
            LocalDate fechaEntrega = p.getDate("fecha_entrega").toLocalDate();
            float precioTotal = p.getFloat("precio_total"); 
            int idCliente = p.getInt("id_clientes");
            objPedido = new Pedido(id, fechaRegistro, fechaEntrega, precioTotal, idCliente);
        }catch(SQLException e){
            System.err.println("Error al convertir los datos" + e.getMessage());
        }
        return objPedido;
    }

    @Override
    public Pedido mostrarId(int id) {
        Pedido objPedido = null;
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarId)){
            p.setInt(1, id);
            r = p.executeQuery();
            if(r.next()){
                objPedido = convertir(r);
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
        return objPedido;
    }

    @Override
    public ArrayList<Pedido> mostrarFecha(LocalDate fecha) {
        ArrayList<Pedido> objArrayFecha = new ArrayList<>();
        //Figura objFigura = null;
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarFecha)){
            p.setDate(1, Date.valueOf(fecha));
            r = p.executeQuery();
            while(r.next()){
                objArrayFecha.add(convertir(r));
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
        return objArrayFecha;
    }

    @Override
    public void crear(Pedido a) {
        try(PreparedStatement p = conn.prepareStatement(crear)){
            p.setDate(1, Date.valueOf(a.getFechaRegistro()));
            p.setDate(2, Date.valueOf(a.getFechaEntrega()));
            p.setFloat(3, a.getPrecioTotal());
            p.setInt(4, a.getIdClientes());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al crear los datos" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Pedido> mostrar() {
        ArrayList<Pedido> objArrayPedido = new ArrayList<>();
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrar)){
             r = p.executeQuery();
            while(r.next()){
                objArrayPedido.add(convertir(r));
            }
        }catch(SQLException e){
            System.err.println("Error" + e.getMessage());
        }
        if(r != null){
            try{
                r.close();
            }catch(SQLException e){
                System.err.println("Error al cerrar el recurso ResultSet" + e.getMessage());
            }  
        }
        return objArrayPedido;
    }

    //ME QUEDE EN EL METODO ACTUALIZAR
    @Override
    public void actualizar(Pedido a) {
        try(PreparedStatement p = conn.prepareStatement(actualizar)){
            p.setDate(1, Date.valueOf(a.getFechaEntrega()));
            p.setFloat(2, a.getPrecioTotal());
            p.setInt(3, a.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al actualizar" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Pedido a) {
        try(PreparedStatement p = conn.prepareStatement(eliminar)){
            p.setInt(1, a.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al eliminar" + e.getMessage());
        }
    }
    
}
