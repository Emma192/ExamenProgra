/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.net.URL;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author emque
 */
public class TransporteCon extends Conexion{
    
    public ResultSet cargarTrasporte(){
    
        try {
            obj_Procedimiento = getConexion().prepareCall("CALL cargarDatosT");
            rs = obj_Procedimiento.executeQuery();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
        return rs;
    }
    public boolean insertarTransporte(Transporte trans) {
        boolean rpta = false;
        try {
            //Nos conectamos
            conectarBD();
            //Busca los datos del profesor
            String call = "{CALL insertarTransporte(?,?,?,?,?,?)}";
            //Preparamos la sentencia
            obj_Procedimiento = conexion.prepareCall(call);
            //Identificacion
            obj_Procedimiento.setString(1, trans.getIdTransporte());
            obj_Procedimiento.setString(2, trans.getDestino());
            obj_Procedimiento.setString(3, trans.getKilometros());
            obj_Procedimiento.setString(4, trans.getCosto());
            obj_Procedimiento.setString(5, trans.getMatricula());
            obj_Procedimiento.setString(6, trans.getFecha_trasporte());

            rpta = obj_Procedimiento.executeUpdate() == 1;
            desconectarBD();
        } catch (SQLException ex) {
            desconectarBD();
            System.err.println(ex);
        } catch (Exception ex) {
            desconectarBD();
            System.err.println(ex);
        }
        return rpta;
    }
             public boolean editarTransporte(Transporte trans){
     
          boolean rpta = false;
        try {
            //Nos conectamos
            conectarBD();
            //Busca los datos del profesor
            String call = "{CALL editarTransporte(?,?,?,?,?,?)}";
            //Preparamos la sentencia
            obj_Procedimiento = conexion.prepareCall(call);
            //Identificacion
         obj_Procedimiento.setString(1, trans.getIdTransporte());
         obj_Procedimiento.setString(2, trans.getDestino());
         obj_Procedimiento.setString(3, trans.getKilometros());
         obj_Procedimiento.setString(4, trans.getCosto());
         obj_Procedimiento.setString(5, trans.getMatricula());
         obj_Procedimiento.setString(6, trans.getFecha_trasporte());
         
     
               rpta = obj_Procedimiento.executeUpdate() ==1;
            desconectarBD();
        } catch (SQLException ex) {
            desconectarBD();
            System.err.println(ex);
        } catch (Exception ex) {
            desconectarBD();
            System.err.println(ex);

        }
        return rpta;
     
   
     }
    public boolean eliminarTransporte(String IdTransporte) {
        boolean rpt = false;
        try {
            conectarBD();
            obj_Procedimiento = getConexion().prepareCall("{CALL eliminarTransporte(?)}");
            obj_Procedimiento.setString(1, IdTransporte);
            rpt = obj_Procedimiento.executeUpdate() == 1;
            desconectarBD();
        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return rpt;
    }
    public Transporte buscarTrasporte(String IdTransporte){

        Transporte transporte = null;

        try {
            conectarBD();
            obj_Procedimiento = getConexion().prepareCall("{CALL buscarTransporteId(?)}");
            obj_Procedimiento.setString(1, IdTransporte);
            rs = obj_Procedimiento.executeQuery();
            if (rs.next()) {
                transporte = new Transporte();
                transporte.setIdTransporte(rs.getString(1));
                transporte.setDestino(rs.getString(2));
                transporte.setKilometros(rs.getString(3));
                transporte.setCosto(rs.getString(4));
                transporte.setMatricula(rs.getString(5));
                transporte.setFecha_trasporte(rs.getString(6));
               
            }
            desconectarBD();
        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }
        return transporte;
    } 
    
       public void cargarReporteTransporte() {

        conectarBD();
        JasperReport reportes;
        JasperPrint reporte_view;
        try {
            URL in = this.getClass().getResource("/views/Transporte.jasper");
            reportes = (JasperReport) JRLoader.loadObject(in);
            reporte_view = JasperFillManager.fillReport(reportes, null, getConexion());
            JasperViewer.viewReport(reporte_view, false); 
        } catch (JRException ex) {
            
            System.err.println(ex.toString());
        }

    }

     public Transporte FiltrarTrasporte(String IdTransporte){

        Transporte transporte = null;

        try {
            conectarBD();
            obj_Procedimiento = getConexion().prepareCall("{CALL buscarTransporteId(?)}");
            obj_Procedimiento.setString(1, IdTransporte);
            rs = obj_Procedimiento.executeQuery();
            if (rs.next()) {
                transporte = new Transporte();
                transporte.setIdTransporte(rs.getString(1));
                
               
            }
            desconectarBD();
        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }
        return transporte;
    }   
}
    
    
    
 
    
    
    
    
   
    
    
    



