/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.services;

import erp.interfaceservices.InterfaceServiceInventario;
import erp.model.Insumo;
import erp.mysqldao.InsumoDAO;
import java.util.ArrayList;

/**
 *
 * @author EQUIPOONE
 */
public class InventarioService implements InterfaceServiceInventario{
    private InsumoDAO objInsumoDao;
    
    /*recibe un objeto de tipo insumoDAO para poder mandarle los
    datos evaluados al DAO*/
    public InventarioService(InsumoDAO objInsumoDao) {
        this.objInsumoDao = objInsumoDao;
    }
    
    @Override
    public boolean registrarInsumo(Insumo a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public ArrayList<Insumo> consultarInventario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Insumo readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Insumo readByName(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateInsumo(Insumo a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteInsumo(Insumo a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
