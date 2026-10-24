/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package erp.interfacedao;

import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public interface InterfaceDAO <T>{
    public void crear(T a);
    public ArrayList<T> mostrar();
    public void actualizar(T a);
    public void eliminar(T a);
}
