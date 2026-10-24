/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package erp.test.mysqldao;

import erp.mysqldao.FiguraDAO;
import erp.model.Figura;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.sql.Connection;
import org.junit.Test;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author guido
 */
public class FiguraDAOTest {
    private FiguraDAO objFiguraDao;
    private Connection conn;
    private ResultSet r;
    private Figura objF;
    
    public FiguraDAOTest() {
    }

    /**
     * Test of convertir method, of class FiguraDAO.
     */
    
    private String crear = "INSERT INTO figuras(tipo_figura, costo, estatus, id_pedidos, id_maquinas) VALUES(?, ?, ?, ?, ?)";
    private String mostrarId = "SELECT id, fecha_registro, fecha_entrega, precio_total, id_clientes FROM pedidos WHERE id = 1";
        
    @Before
    public void setUp() throws Exception {
        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERPL", "root", "");
        objFiguraDao = new FiguraDAO(conn);
    }
    @Test
    public void testConvertir()  {
        try {
            //PreparedStatement p = conn.prepareStatement("INSERT INTO figuras (tipo_figura, costo, estatus, id_pedidos, id_maquinas) VALUES (?, ?, ?, ?, ?)");
            PreparedStatement j = conn.prepareStatement(mostrarId);
            r=j.executeQuery();
        } catch (SQLException ex) {
            System.getLogger(FiguraDAOTest.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            fail();
        }
        assertNotNull(objFiguraDao.convertir(r));   
    }
    
    /**
     * Test of mostrarId method, of class FiguraDAO.
     */
    @Test
    public void testMostrarId() {
    }

    /**
     * Test of mostrarTipo method, of class FiguraDAO.
     */
    @Test
    public void testMostrarTipo() {
    }

    /**
     * Test of crear method, of class FiguraDAO.
     */
   
    @Test
    public void testCrear() {
        //assertNotNull(objFiguraDao.crear(objF));
        
    }

    /**
     * Test of mostrar method, of class FiguraDAO.
     */
    @Test
    public void testMostrar() {
    }

    /**
     * Test of actualizar method, of class FiguraDAO.
     */
    @Test
    public void testActualizar() {
    }

    /**
     * Test of eliminar method, of class FiguraDAO.
     */
    @Test
    public void testEliminar() {
    }
    
}
