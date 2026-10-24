/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfacedao;

import erp.model.EnumEstatusMaquina;
import erp.model.Maquina;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public interface InterfaceMaquina extends InterfaceDAO<Maquina>{
    public Maquina convertir(ResultSet p);
    public Maquina mostrarId(int id);
    public ArrayList<Maquina> mostrarEstatus(EnumEstatusMaquina a);   
}
