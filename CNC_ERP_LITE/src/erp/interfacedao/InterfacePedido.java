/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfacedao;

import erp.model.Pedido;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Alumno
 */
public interface InterfacePedido extends InterfaceDAO<Pedido>{
    public Pedido convertir(ResultSet p);
    public Pedido mostrarId(int id);
    public ArrayList<Pedido> mostrarFecha(LocalDate fecha);
}
