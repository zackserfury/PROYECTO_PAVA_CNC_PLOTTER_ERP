/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfaceservices;

import erp.model.Insumo;
import java.util.ArrayList;

/**
 *
 * @author EQUIPOONE
 */
public interface InterfaceServiceInventario {
    boolean registrarInsumo(Insumo a);

    ArrayList<Insumo> consultarInventario();

    Insumo readById(int id);

    Insumo readByName(String nombre);

    boolean updateInsumo(Insumo a);

    boolean deleteInsumo(Insumo a);
}
