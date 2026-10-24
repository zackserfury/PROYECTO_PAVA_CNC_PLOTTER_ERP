/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.mysqldao;

import erp.interfacedao.InterfaceMaquina;
import erp.model.EnumEstatusMaquina;
import erp.model.EnumProcesosFigura;
import erp.model.Maquina;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author Alumno
 */
public class MaquinaDAO implements InterfaceMaquina{
    private Connection conn;
    private String crear;
    private String mostrar;
    private String mostrarId;
    private String mostrarEstatus;
    private String actualizarEstatus;
    private String eliminar;

    public MaquinaDAO(Connection conn) {
        this.conn = conn;
        crear = "INSERT INTO maquinas (modelo, numero_mesa, costo_maquina, consumo_energia, estatus) VALUES (?, ?, ?, ?, ?)";
        mostrar = "SELECT id, modelo, numero_mesa, costo_maquina, consumo_energia, estatus FROM maquinas";
        mostrarId = "SELECT id, modelo, numero_mesa, costo_maquina, consumo_energia, estatus FROM maquinas WHERE id = ?";
        mostrarEstatus = "SELECT id, modelo, numero_mesa, costo_maquina, consumo_energia, estatus FROM maquinas WHERE estatus = ?";
        actualizarEstatus = "UPDATE maquinas SET estatus = ? WHERE id = ?";
        eliminar = "DELETE FROM maquinas WHERE id = ?";
    }
    
    

    @Override
    public Maquina convertir(ResultSet p) {
        Maquina objMaquina = null;
        try{
            int id = p.getInt("id");
            String modelo = p.getString("modelo");
            int numeroMesa = p.getInt("numero_mesa");
            float costoMaquina = p.getFloat("costo_maquina");
            float consumoEnergia = p.getFloat("consumo_energia");
            EnumEstatusMaquina estatus = EnumEstatusMaquina.valueOf(p.getString("estatus"));
            
            objMaquina = new Maquina(id, modelo, numeroMesa, costoMaquina, consumoEnergia, estatus);
        }catch(SQLException e){
            System.err.println("Error al convertir los datos" + e.getMessage());
        }
        return objMaquina;
    }

    @Override
    public Maquina mostrarId(int id) {
        Maquina objMaquina = null;
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarId)){
            p.setInt(1, id);
            r = p.executeQuery();
            if(r.next()){
                objMaquina = convertir(r);
            }
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        if(r != null){
            try{
                r.close();
            }catch(SQLException e){
                System.err.println("Error al cerrar el recurso ResultSet" + e.getMessage());
            }  
        }
        return objMaquina;
    }

    @Override
    public ArrayList<Maquina> mostrarEstatus(EnumEstatusMaquina a) {
        ArrayList<Maquina> objArrayMaquina = new ArrayList<>();
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarEstatus)){
            p.setString(1, a.toString());
            r = p.executeQuery();
            while(r.next()){
                objArrayMaquina.add(convertir(r));
            }
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        if(r != null){
            try{
                r.close();
            }catch(SQLException e){
                System.err.println("Error al cerrar el recurso ResultSet" + e.getMessage());
            }  
        }
        return objArrayMaquina;
        
    }

    @Override
    public void crear(Maquina a) {
        try(PreparedStatement p = conn.prepareStatement(crear)){
            p.setString(1, a.getModelo());
            p.setInt(2, a.getNumeroMesa());
            p.setFloat(3, a.getCostoMaquina());
            p.setFloat(4, a.getConsumoEnergia());
            p.setString(5, a.getEstatus().toString());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Maquina> mostrar() {
        ArrayList<Maquina> objArrayMaquina = new ArrayList<>();
        try(PreparedStatement p = conn.prepareStatement(mostrar);
        ResultSet r = p.executeQuery()){
            while(r.next()){
                objArrayMaquina.add(convertir(r));
            }
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        return objArrayMaquina;
    }

    @Override
    public void actualizar(Maquina a) {
        try(PreparedStatement p = conn.prepareStatement(actualizarEstatus)){
            p.setString(1, a.getEstatus().toString());
            p.setInt(2, a.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Maquina a) {
         try(PreparedStatement p = conn.prepareStatement(eliminar)){
           p.setInt(1, a.getId());
           p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al eliminar elemento" + e.getMessage());
        }    
    }
    
}
