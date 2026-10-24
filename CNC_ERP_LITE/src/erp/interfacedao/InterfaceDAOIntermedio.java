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
public interface InterfaceDAOIntermedio<T, K>{
    public void create(T a, K b);
    public ArrayList<K> readOne(T a);
    public ArrayList<T> readTwo(K b);
    public void delete(T a, K b);
}
