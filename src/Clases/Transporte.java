/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author emque
 */
public class Transporte {


    private String idTransporte;
    private String destino;
    private String kilometros;
    private String costo;
    private String matricula;
    private String fecha_trasporte;
   
    public Transporte() {
    }

    public Transporte(String idTransporte, String destino, String kilometros, String costo, String matricula, String fecha_trasporte) {
        this.idTransporte = idTransporte;
        this.destino = destino;
        this.kilometros = kilometros;
        this.costo = costo;
        this.matricula = matricula;
        this.fecha_trasporte = fecha_trasporte;
    }

     @Override
    public String toString() {
        return "Trasporte{" + "idTransporte=" + idTransporte + ", destino=" + destino + ", kilometros=" + kilometros + ", costo=" + costo + ", matricula=" + matricula + ", fecha_trasporte=" + fecha_trasporte + '}';
    }
    
    
    public String getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(String idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getKilometros() {
        return kilometros;
    }

    public void setKilometros(String kilometros) {
        this.kilometros = kilometros;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFecha_trasporte() {
        return fecha_trasporte;
    }

    public void setFecha_trasporte(String fecha_trasporte) {
        this.fecha_trasporte = fecha_trasporte;
    }

   
}
