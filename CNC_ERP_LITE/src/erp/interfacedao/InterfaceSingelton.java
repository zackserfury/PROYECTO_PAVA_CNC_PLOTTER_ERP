/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfacedao;

import erp.mysqldao.ClienteDAO;
import erp.mysqldao.EmpleadoDAO;
import erp.mysqldao.EmpleadoPedidoDAO;
import erp.mysqldao.FiguraDAO;
import erp.mysqldao.InsumoFiguraDAO;
import erp.mysqldao.InsumoProveedorDAO;
import erp.mysqldao.InsumoDAO;
import erp.mysqldao.MaquinaDAO;
import erp.mysqldao.PedidoDAO;
import erp.mysqldao.ProveedorDAO;

/**
 *
 * @author Alumno
 */
public interface InterfaceSingelton {
    
    public ClienteDAO getClienteDAO();
    public EmpleadoDAO getEmpleadoDAO();
    public FiguraDAO getFiguraDAO();
    public InsumoDAO getInsumoDAO();
    public MaquinaDAO getMaquinaDAO();
    public PedidoDAO getPedidosDAO();
    public ProveedorDAO getProveedorDAO();
    public InsumoFiguraDAO getInsumoByFiguraDAO();    
    public InsumoProveedorDAO getInsumoByProveedorDAO();
    public EmpleadoPedidoDAO getEmpleadoByPedidoDAO();
    
}
