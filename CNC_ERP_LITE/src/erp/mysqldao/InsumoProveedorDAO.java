/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package erp.mysqldao;

import erp.interfacedao.InterfaceInsumoProveedor;
import erp.model.Insumo;
import erp.model.Proveedor;
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
public class InsumoProveedorDAO implements InterfaceInsumoProveedor {

    private Connection conn;
    private String create;
    private String readOne;
    private String readTwo;
    private String delete;

    public InsumoProveedorDAO(Connection conn) {
        this.conn = conn;

        create = "INSERT INTO insumos_proveedores "
               + "(id_insumos, id_proveedores) VALUES (?,?)";

        readOne = "SELECT p.* FROM proveedores p "
                + "INNER JOIN insumos_proveedores ip "
                + "ON p.id = ip.id_proveedores "
                + "WHERE ip.id_insumos = ?";

        readTwo = "SELECT i.* FROM insumos i "
                + "INNER JOIN insumos_proveedores ip "
                + "ON i.id = ip.id_insumos "
                + "WHERE ip.id_proveedores = ?";

        delete = "DELETE FROM insumos_proveedores "
               + "WHERE id_insumos = ? AND id_proveedores = ?";
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

    public Proveedor convertirProveedor(ResultSet r) {
        Proveedor objProveedor = null;

        try {
            int id = r.getInt("id");
            String telefono = r.getString("telefono");
            String nombreProveedor = r.getString("nombre_proveedor");
            LocalDate fechaRegistro = r.getDate("fecha_registro").toLocalDate();
            String direccion = r.getString("direccion");

            objProveedor = new Proveedor(
                id, telefono, nombreProveedor,
                fechaRegistro, direccion
            );

        } catch (SQLException e) {
            System.err.println("ERROR " + e.getMessage());
        }

        return objProveedor;
    }

    @Override
    public void create(Insumo a, Proveedor b) {
        try (PreparedStatement p = conn.prepareStatement(create)) {
            p.setInt(1, a.getId());
            p.setInt(2, b.getId());
            p.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERROR " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Proveedor> readOne(Insumo a) {
        ArrayList<Proveedor> objArrayProveedor = new ArrayList<>();

        try(PreparedStatement p = conn.prepareStatement(readOne)) {

            p.setInt(1, a.getId());

            try(ResultSet r = p.executeQuery()) {

                while(r.next()) {
                    objArrayProveedor.add(convertirProveedor(r));
                }

            }

        } catch (SQLException e) {
            System.err.println("ERROR " + e.getMessage());
        }

        return objArrayProveedor;
    }

    @Override
    public ArrayList<Insumo> readTwo(Proveedor b) {
        ArrayList<Insumo> objArrayInsumo = new ArrayList<>();

        try(PreparedStatement p = conn.prepareStatement(readTwo)) {

            p.setInt(1, b.getId());

            try (ResultSet r = p.executeQuery()) {

                while(r.next()) {
                    Insumo objInsumo = convertirInsumo(r);
                    objArrayInsumo.add(objInsumo);
                }

            }

        } catch (SQLException e) {
            System.err.println("ERROR " + e.getMessage());
        }

        return objArrayInsumo;
    }

    @Override
    public void delete(Insumo a, Proveedor b) {
        try (PreparedStatement p = conn.prepareStatement(delete)) {

            p.setInt(1, a.getId());
            p.setInt(2, b.getId());
            p.executeUpdate();

        } catch (SQLException e) {
            System.err.println("ERROR " + e.getMessage());
        }
    }
}
