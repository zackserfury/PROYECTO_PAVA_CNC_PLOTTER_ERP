/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erp.model;

/**
 *
 * @author Alumno
 */
public class Maquina {
    private int id;
    private String modelo;
    private int numeroMesa;
    private float costoMaquina;
    private float consumoEnergia;
    private EnumEstatusMaquina estatus;

    public Maquina() {
    }

    public Maquina(int id, String modelo, int numeroMesa, float costoMaquina, float consumoEnergia, EnumEstatusMaquina estatus) {
        this.id = id;
        this.modelo = modelo;
        this.numeroMesa = numeroMesa;
        this.costoMaquina = costoMaquina;
        this.consumoEnergia = consumoEnergia;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public float getCostoMaquina() {
        return costoMaquina;
    }

    public void setCostoMaquina(float costoMaquina) {
        this.costoMaquina = costoMaquina;
    }

    public float getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(float consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public EnumEstatusMaquina getEstatus() {
        return estatus;
    }

    public void setEstatus(EnumEstatusMaquina estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Maquinas{" + "id=" + id + ", modelo=" + modelo + ", numeroMesa=" + numeroMesa + ", costoMaquina=" + costoMaquina + ", consumoEnergia=" + consumoEnergia + ", estatus=" + estatus + '}';
    }
    
    
}
