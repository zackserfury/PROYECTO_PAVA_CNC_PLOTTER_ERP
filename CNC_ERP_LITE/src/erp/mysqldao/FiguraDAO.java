/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.mysqldao;

import erp.interfacedao.InterfaceFigura;
import erp.model.EnumProcesosFigura;
import erp.model.EnumTipoFigura;
import erp.model.Figura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author Alumno
 */
public class FiguraDAO implements InterfaceFigura{
    private Connection conn;
    private String crear;
    private String mostrar;
    private String mostrarId;
    private String mostrarTipo;
    private String actualizarEstatus;
    private String eliminar;

    public FiguraDAO(Connection conn) {
        this.conn = conn;
        crear = "INSERT INTO figuras(tipo_figura, costo, estatus, id_pedidos, id_maquinas) VALUES(?, ?, ?, ?, ?)";
        mostrar = "SELECT id, tipo_figura, costo, estatus, id_pedidos, id_maquinas FROM figuras";
        mostrarId = "SELECT id, tipo_figura, costo, estatus, id_pedidos, id_maquinas FROM figuras WHERE id = ?";
        mostrarTipo = "SELECT id, tipo_figura, costo, estatus, id_pedidos, id_maquinas FROM figuras WHERE tipo_figura = ?";
        actualizarEstatus = "UPDATE figuras SET estatus = ? WHERE id = ?";
        eliminar = "DELETE FROM figuras WHERE id = ?";
    }
    
    @Override
    public Figura convertir(ResultSet p) {
        Figura objFigura = null;
        try{
            int id = p.getInt("id");
            EnumTipoFigura tipoFigura = EnumTipoFigura.valueOf(p.getString("tipo_figura"));
            float costo = p.getFloat("costo");
            EnumProcesosFigura estatus = EnumProcesosFigura.valueOf(p.getString("estatus"));
            int idPedidos = p.getInt("id_pedidos");
            int idMaquinas = p.getInt("id_maquinas");
            
            objFigura = new Figura(id, tipoFigura, costo, estatus, idPedidos, idMaquinas);
        }catch(SQLException e){
            System.err.println("Error al convertir los datos" + e.getMessage());
        }
        return objFigura;
    }

    @Override
    public Figura mostrarId(int id) {
        Figura objFigura = null;
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarId)){
            p.setInt(1, id);
            r = p.executeQuery();
            if(r.next()){
                objFigura = convertir(r);
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
        return objFigura;
    }

    @Override
    public ArrayList<Figura> mostrarTipo(EnumTipoFigura tipo) {
        ArrayList<Figura> objArrayTipo = new ArrayList();
        //Figura objFigura = null;
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrarTipo)){
            p.setString(1, tipo.toString());
            r = p.executeQuery();
            while(r.next()){
                objArrayTipo.add(convertir(r));
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
        return objArrayTipo;
    }

    @Override
    public void crear(Figura a) {
        try(PreparedStatement p = conn.prepareStatement(crear)){
            p.setString(1, a.getTipoFigura().toString());
            p.setFloat(2, a.getCosto());
            p.setString(3, a.getEstastus().toString());
            p.setInt(4, a.getIdPedidos());
            p.setInt(5, a.getIdMaquinas());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al crear los datos" + e.getMessage());
        }
    }

    @Override
    public ArrayList<Figura> mostrar() {
        ArrayList<Figura> objArrayFigura;
        objArrayFigura = new ArrayList();
        ResultSet r = null;
        try(PreparedStatement p = conn.prepareStatement(mostrar)){
            r = p.executeQuery();
            while(r.next()){
                objArrayFigura.add(convertir(r));
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
        return objArrayFigura;
    }

    @Override
    public void actualizar(Figura a) {
        try(PreparedStatement p = conn.prepareStatement(actualizarEstatus)){
            p.setString(1, a.getEstastus().toString());
            p.setInt(2, a.getId());
            p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al modificar los datos" + e.getMessage());
        }
    }

    @Override
    public void eliminar(Figura a) {
        try(PreparedStatement p = conn.prepareStatement(eliminar)){
           p.setInt(1, a.getId());
           p.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error al eliminar elemento" + e.getMessage());
        }    
    }
    
}
