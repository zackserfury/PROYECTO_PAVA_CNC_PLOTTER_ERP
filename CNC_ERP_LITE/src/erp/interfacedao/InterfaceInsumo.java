/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfacedao;

import erp.model.Insumo;
import java.sql.ResultSet;
/**
 *
 * @author Alumno
 */
public interface InterfaceInsumo extends InterfaceDAO<Insumo>{
    public Insumo convertir(ResultSet p);
    public Insumo mostrarId(int id);
    public Insumo mostrarNombre(String nombre);
}
