/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package erp.mysqldao;

import erp.interfacedao.InterfaceProveedor;
import erp.model.Proveedor;
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
public class ProveedorDAO implements InterfaceProveedor {

    private Connection conn;
    private String crear;
    private String mostrar;
    private String mostrarId;
    private String mostrarNombre;
    private String actualizar;
    private String eliminar;

    public ProveedorDAO(Connection conn) {
        this.conn = conn;

        crear = "INSERT INTO proveedores(telefono, nombre_proveedor, fecha_registro, direccion) VALUES (?, ?, ?, ?)";
        mostrar = "SELECT id, telefono, nombre_proveedor, fecha_registro, direccion FROM proveedores";
        mostrarId = "SELECT id, telefono, nombre_proveedor, fecha_registro, direccion FROM proveedores WHERE id = ?";
        mostrarNombre = "SELECT id, telefono, nombre_proveedor, fecha_registro, direccion FROM proveedores WHERE nombre_proveedor = ?";
        actualizar = "UPDATE proveedores SET telefono = ?, nombre_proveedor = ?, fecha_registro = ?, direccion = ? WHERE id = ?";
        eliminar = "DELETE FROM proveedores WHERE id = ?";
    }

    @Override
    public Proveedor convertir(ResultSet p) {
        Proveedor objProveedor = null;

        try {
            int id = p.getInt("id");
            String telefono = p.getString("telefono");
            String nombreProveedor = p.getString("nombre_proveedor");
            LocalDate fechaRegistro = p.getDate("fecha_registro").toLocalDate();
            String direccion = p.getString("direccion");

            objProveedor = new Proveedor(
                id,
                telefono,
                nombreProveedor,
                fechaRegistro,
                direccion
            );

        } catch (SQLException e) {
            System.err.println("Error al convertir los datos: " + e.getMessage());
        }

        return objProveedor;
    }

    @Override
    public Proveedor mostrarId(int id) {
        Proveedor objProveedor = null;

        try (PreparedStatement p = conn.prepareStatement(mostrarId)) {
            p.setInt(1, id);

            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    objProveedor = convertir(r);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al mostrar el proveedor: " + e.getMessage());
        }

        return objProveedor;
    }

    @Override
    public Proveedor mostrarNombre(String nombre) {
        
       Proveedor objProveedor = new Proveedor();

        try (PreparedStatement p = conn.prepareStatement(mostrarNombre)) {
            p.setString(1, nombre);

            try (ResultSet r = p.executeQuery()) {
                if(r.next()) {
                    objProveedor = convertir(r);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar proveedores: " + e.getMessage());
        }

        return objProveedor;
    }

    @Override
    public void crear(Proveedor a) {
        try (PreparedStatement p = conn.prepareStatement(crear)) {
            p.setString(1, a.getTelefono());
            p.setString(2, a.getNombreProveedor());
            p.setDate(3, Date.valueOf(a.getFechaRegistro()));
            p.setString(4, a.getDireccion());

            p.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al crear el proveedor: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Proveedor> mostrar() {
        ArrayList<Proveedor> objArrayProveedor = new ArrayList<>();

        try (PreparedStatement p = conn.prepareStatement(mostrar);
             ResultSet r = p.executeQuery()) {

            while (r.next()) {
                objArrayProveedor.add(convertir(r));
            }

        } catch (SQLException e) {
            System.err.println("Error al mostrar proveedores: " + e.getMessage());
        }

        return objArrayProveedor;
    }

    @Override
    public void actualizar(Proveedor a) {
        try (PreparedStatement p = conn.prepareStatement(actualizar)) {
            p.setString(1, a.getTelefono());
            p.setString(2, a.getNombreProveedor());
            p.setDate(3, Date.valueOf(a.getFechaRegistro()));
            p.setString(4, a.getDireccion());
            p.setInt(5, a.getId());

            p.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar el proveedor: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Proveedor a) {
        try (PreparedStatement p = conn.prepareStatement(eliminar)) {
            p.setInt(1, a.getId());

            p.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar el proveedor: " + e.getMessage());
        }
    }
}
