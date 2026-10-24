/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.mysqldao;

import erp.interfacedao.InterfaceInsumo;
import erp.model.Insumo;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;/**
 *
 * @author Alumno
 */
public class InsumoDAO implements InterfaceInsumo{
    private Connection conn;
    private String crear;
    private String mostrar;
    private String mostrarId;
    private String mostrarNombre;
    private String actualizar;
    private String eliminar;

    public InsumoDAO(Connection conn) {
        this.conn = conn;
        crear = "INSERT INTO insumos (marca, nombre_insumo, precio, cantidad_piezas, fecha_registro, numero_estanteria) VALUES (?, ?, ?, ?, ?, ?)";
        mostrar = "SELECT id, marca, nombre_insumo, precio, cantidad_piezas, fecha_registro, numero_estanteria FROM insumos";
        mostrarId = "SELECT id, marca, nombre_insumo, precio, cantidad_piezas, fecha_registro, numero_estanteria FROM insumos WHERE id = ?";
        mostrarNombre = "SELECT id, marca, nombre_insumo, precio, cantidad_piezas, fecha_registro, numero_estanteria FROM insumos WHERE nombre_insumo = ?";
        actualizar = "UPDATE insumos SET marca = ?, nombre_insumo = ?, precio = ?, cantidad_piezas = ?, fecha_registro = ?, numero_estanteria = ? WHERE id = ?";
        eliminar = "DELETE FROM insumos WHERE id = ?";

    }
    
    @Override
    public Insumo convertir(ResultSet p) {
        Insumo objInsumo = null;
        try{
            int id = p.getInt("id");
            String marca = p.getString("marca");
            String nombreInsumo = p.getString("nombre_insumo");
            float precio = p.getFloat("precio");
            int cantidadPiezas = p.getInt("cantidad_piezas");
            LocalDate fechaRegistro = p.getDate("fecha_registro").toLocalDate();
            int numeroEstanteria = p.getInt("numero_estanteria");
            objInsumo = new Insumo(id, marca, nombreInsumo, precio, cantidadPiezas, fechaRegistro, numeroEstanteria);
        }catch(SQLException e){
            System.err.println("Error al convertir los datos" + e.getMessage());
        }
        return objInsumo;
    }

    @Override
    public Insumo mostrarId(int id) {
        Insumo objInsumo = null;
        //ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarId)){
            p.setInt(1, id);
                try(ResultSet r = p.executeQuery()){
                    if(r.next()){
                    objInsumo = convertir(r);
                    }
                }catch(SQLException e){
                    System.err.println("ERROR" + e.getMessage());
                }
            }catch(SQLException e){
                System.err.println("ERROR" + e.getMessage());
            }                   
        return objInsumo;
    }    


    @Override
    public Insumo mostrarNombre(String nombre) {
        Insumo objInsumo = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarNombre)){
            p.setString(1, nombre);
            try(ResultSet r = p.executeQuery()){
                if(r.next()){
                    objInsumo = convertir(r);
                }
            }catch(SQLException e){
                System.err.println("ERROR" + e.getMessage());
            }
            
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        return objInsumo;
    }

    @Override
    public void crear(Insumo a) {
        try(PreparedStatement p = conn.prepareStatement(crear)){
            p.setString(1, a.getMarca());
            p.setString(2, a.getNombreInsumo());
            p.setFloat(3, a.getPrecio());
            p.setInt(4, a.getCantidadPiezas());
            p.setDate(5, Date.valueOf(a.getFechaRegistro()));
            p.setInt(6, a.getNumeroEstanteria());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Insumo> mostrar() {
        ArrayList<Insumo> objArrayInsumo = new ArrayList<>();
        try(PreparedStatement p = conn.prepareStatement(mostrar)){
            try(ResultSet r = p.executeQuery()){
                while(r.next()){
                    objArrayInsumo.add(convertir(r));
                }
            }catch(SQLException e){
                System.err.println("ERROR" + e.getMessage());
            }
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        return objArrayInsumo;
    }

    @Override
    public void actualizar(Insumo a) {
        try(PreparedStatement p = conn.prepareStatement(actualizar)){
            p.setString(1, a.getMarca());
            p.setString(2, a.getNombreInsumo());
            p.setFloat(3, a.getPrecio());
            p.setInt(4, a.getCantidadPiezas());
            p.setDate(5, Date.valueOf(a.getFechaRegistro()));
            p.setInt(6, a.getNumeroEstanteria());
            p.setInt(7, a.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Insumo a) {
        try(PreparedStatement p = conn.prepareStatement(eliminar)){
            p.setInt(1, a.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }
    
}
