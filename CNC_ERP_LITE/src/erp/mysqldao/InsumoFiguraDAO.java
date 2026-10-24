/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.mysqldao;

import erp.interfacedao.InterfaceInsumoFigura;
import erp.model.EnumProcesosFigura;
import erp.model.EnumTipoFigura;
import erp.model.Figura;
import erp.model.Insumo;
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
public class InsumoFiguraDAO implements InterfaceInsumoFigura{
    private Connection conn;
    private String create;
    private String readOne;
    private String readTwo;
    private String delete;
    
    public InsumoFiguraDAO(Connection conn) {
        this.conn = conn;
        create = "INSERT INTO insumos_figuras "
               + "(id_insumos, id_figuras) VALUES (?,?)";

        readOne = "SELECT p.* FROM figuras p "
                + "INNER JOIN insumos_figuras ip "
                + "ON p.id = ip.id_figuras "
                + "WHERE ip.id_insumos = ?";

        readTwo = "SELECT i.* FROM insumos i "
                + "INNER JOIN insumos_figuras ip "
                + "ON i.id = ip.id_insumos "
                + "WHERE ip.id_figuras = ?";

        delete = "DELETE FROM insumos_figuras "
               + "WHERE id_insumos = ? AND id_figuras = ?";
    }
    
    public Figura convertirFigura(ResultSet r){
        Figura objFigura = null;
        try{
           int id = r.getInt("id");
           EnumTipoFigura tipoFigura = EnumTipoFigura.valueOf(r.getString("tipo_figura"));
           float costo = r.getFloat("costo");
           EnumProcesosFigura estatus = EnumProcesosFigura.valueOf(r.getString("estatus"));
           int idPedidos = r.getInt("id_pedidos");
           int idMaquinas = r.getInt("id_maquinas");
           
           objFigura = new Figura(id, tipoFigura, costo, estatus, idPedidos, idMaquinas);
            
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        
        return objFigura;
    }
    
    public Insumo convertirInsumo(ResultSet r) {
        Insumo objInsumo = null;

        try {
            int id = r.getInt("id");
            String marca = r.getString("marca");
            String nombreInsumo = r.getString("nombre_insumo");
            float precio = r.getFloat("precio");
            int cantidadPiezas = r.getInt("cantidad_piezas");
            LocalDate fechaRegistro = r.getDate("fecha_registro").toLocalDate();
            int numeroEstanteria = r.getInt("numero_estanteria");

            objInsumo = new Insumo(
                id, marca, nombreInsumo, precio,
                cantidadPiezas, fechaRegistro, numeroEstanteria
            );

        } catch (SQLException e) {
            System.err.println("ERROR " + e.getMessage());
        }

        return objInsumo;
    }
    
    @Override
    public void create(Insumo a, Figura b) {
        try(PreparedStatement p = conn.prepareStatement(create)){
            p.setInt(1, a.getId());
            p.setInt(2, b.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e);
        }
    }

    @Override
    public ArrayList<Figura> readOne(Insumo a) {
        ArrayList<Figura> objArrayFigura = new ArrayList<>();
        try(PreparedStatement p = conn.prepareStatement(readOne)){
            p.setInt(1, a.getId());
            try(ResultSet r = p.executeQuery()){
                while(r.next()){
                    objArrayFigura.add(convertirFigura(r));
                }
            }catch(SQLException e){
                System.err.println("ERROR" + e.getMessage());
            }
            
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
        return objArrayFigura;
    }

    @Override
    public ArrayList<Insumo> readTwo(Figura b) {
        ArrayList<Insumo> objArrayInsumo = new ArrayList<>();
        try(PreparedStatement p = conn.prepareStatement(readTwo)){
            p.setInt(1, b.getId());
            try(ResultSet r = p.executeQuery()){
                while(r.next()){
                    objArrayInsumo.add(convertirInsumo(r));
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
    public void delete(Insumo a, Figura b) {
        try(PreparedStatement p = conn.prepareStatement(delete)){
            p.setInt(1, a.getId());
            p.setInt(2, b.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("ERROR" + e.getMessage());
        }
    }
    
}
