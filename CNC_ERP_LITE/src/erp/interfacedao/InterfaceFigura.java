/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfacedao;

import erp.model.EnumTipoFigura;
import erp.model.Figura;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Alumno
 */
public interface InterfaceFigura extends InterfaceDAO<Figura>{
    public Figura convertir(ResultSet p);
    public Figura mostrarId(int id);
    public ArrayList<Figura> mostrarTipo(EnumTipoFigura tipo);
}
