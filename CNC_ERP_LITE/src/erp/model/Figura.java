/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.model;

/**
 *
 * @author Alumno
 */
public class Figura {
    private int id;
    private EnumTipoFigura tipoFigura;
    private float costo;
    private EnumProcesosFigura estastus;
    private int idPedidos;
    private int idMaquinas;

    public Figura() {
    }

    public Figura(int id, EnumTipoFigura tipoFigura, float costo, EnumProcesosFigura estastus, int idPedidos, int idMaquinas) {
        this.id = id;
        this.tipoFigura = tipoFigura;
        this.costo = costo;
        this.estastus = estastus;
        this.idPedidos = idPedidos;
        this.idMaquinas = idMaquinas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnumTipoFigura getTipoFigura() {
        return tipoFigura;
    }

    public void setTipoFigura(EnumTipoFigura tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public EnumProcesosFigura getEstastus() {
        return estastus;
    }

    public void setEstastus(EnumProcesosFigura estastus) {
        this.estastus = estastus;
    }

    public int getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(int idPedidos) {
        this.idPedidos = idPedidos;
    }

    public int getIdMaquinas() {
        return idMaquinas;
    }

    public void setIdMaquinas(int idMaquinas) {
        this.idMaquinas = idMaquinas;
    }

    @Override
    public String toString() {
        return "Figura{" + "id=" + id + ", tipoFigura=" + tipoFigura + ", costo=" + costo + ", estastus=" + estastus + ", idPedidos=" + idPedidos + ", idMaquinas=" + idMaquinas + '}';
    }

    
    
}
