/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class ConnDB {
    //En Java, un método estático no puede acceder a atributos que no sean estáticos.
    private static ConnDB objConnDB = null;
    private Connection conn;
    private String url;
    private String usuario;
    private String contraseña;

    private ConnDB() {
        url = "jdbc:mysql://localhost:3306/formulario";
        usuario = "root";
        contraseña = "";
        
        try {
            conn = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            System.err.println("ERROR" + e.getMessage());
        }
    }
    
    public static ConnDB getConnDB(){
        if(objConnDB == null){
            objConnDB = new ConnDB();
        }
        return objConnDB;
    }
    
    public Connection connection(){
        return conn;
    }
    
    public void cerrarConexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexion cerrada correctamente");
            }
        }catch (SQLException e){
            System.err.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }
    
    /*public static void main(String[] args){
        ConnDB objConn = new ConnDB();
        objConn.getConnDB();
    }*/
          
}
