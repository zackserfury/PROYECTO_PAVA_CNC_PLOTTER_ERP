/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.controller;

import erp.conn.ConnDB;
import erp.interfacedao.InterfaceSingelton;
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
import java.sql.Connection;

/**
 *
 * @author Alumno
 */
//static: el atributo pertenece a la clase, no a cada objeto que se cree de ella.

/*Un método static es un método que pertenece a la clase y no necesita que crees
un objeto para poder utilizarlo.*/



public class ManagerDAO implements InterfaceSingelton{
    private Connection conn;
    private ConnDB objConn;
    private ClienteDAO objClienteDao = null;
    private EmpleadoDAO objEmpleadoDao = null;
    private FiguraDAO objFiguraDao = null;
    private InsumoDAO objInsumoDao = null;
    private MaquinaDAO objMaquinaDao = null;
    private PedidoDAO objPedidoDao = null;
    private ProveedorDAO objProveedorDao = null;
    private EmpleadoPedidoDAO objEmpleadoByPedido = null;
    private InsumoProveedorDAO objInsumoByProveedor = null;
    private InsumoFiguraDAO objInsumoByFigura = null;
    private static ManagerDAO objManagerDao = null;
    
    private ManagerDAO() {
        objConn = ConnDB.getConnDB();
        conn = objConn.connection();
    }

    public static ManagerDAO getManagerDao(){
        if(objManagerDao == null){
            objManagerDao = new ManagerDAO();
        }
        return objManagerDao;
    }
    
    @Override
    public ClienteDAO getClienteDAO() {
        if(objClienteDao == null){
            objClienteDao = new ClienteDAO(conn);
        }
        return objClienteDao;
    }

    @Override
    public EmpleadoDAO getEmpleadoDAO() {
        if(objEmpleadoDao == null){
            objEmpleadoDao = new EmpleadoDAO(conn);
        }
        return objEmpleadoDao;
    }

    @Override
    public FiguraDAO getFiguraDAO() {
        if(objFiguraDao == null){
            objFiguraDao = new FiguraDAO(conn);
        }
        return objFiguraDao;
    }

    @Override
    public InsumoDAO getInsumoDAO() {
        if(objInsumoDao == null){
            objInsumoDao = new InsumoDAO(conn);
        }
        return objInsumoDao;
    }

    @Override
    public MaquinaDAO getMaquinaDAO() {
        if(objMaquinaDao == null){
            objMaquinaDao = new MaquinaDAO(conn);
        }
        return objMaquinaDao;
    }

    @Override
    public PedidoDAO getPedidosDAO() {
        if(objPedidoDao == null){
            objPedidoDao = new PedidoDAO(conn);
        }
        return objPedidoDao;
    }

    @Override
    public ProveedorDAO getProveedorDAO() {
        if(objProveedorDao == null){
            objProveedorDao = new ProveedorDAO(conn);
        }
        return objProveedorDao;
    }

    @Override
    public InsumoFiguraDAO getInsumoByFiguraDAO() {
        if(objInsumoByFigura == null){
            objInsumoByFigura = new InsumoFiguraDAO(conn);
        }
        return objInsumoByFigura;
    }

    @Override
    public InsumoProveedorDAO getInsumoByProveedorDAO() {
        if(objInsumoByProveedor == null){
            objInsumoByProveedor = new InsumoProveedorDAO(conn);
        }
        return objInsumoByProveedor;
    }

    @Override
    public EmpleadoPedidoDAO getEmpleadoByPedidoDAO() {
        if(objEmpleadoByPedido == null){
            objEmpleadoByPedido = new EmpleadoPedidoDAO(conn);
        }
        return objEmpleadoByPedido;
    }
    
    
    
    
}
