/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_exa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author juan
 */
public class Hotel implements Serializable {
    private String codigoHotel;
    private String nombre;
    private String ciudad;
    private double precio;

    private HashMap<String,Double> tarifas;

    public Hotel(String ciudad,String codigoHotel ,String nombre,double precio) {
        this.nombre = nombre;
        this.codigoHotel=codigoHotel;
        this.ciudad = ciudad;
        this.precio=precio;

        tarifas = new HashMap<String,Double>();
    }
    

    public void insertaTarifa(String extra, Double precio){
        tarifas.put(extra, precio); 
    }

    public HashMap<String, Double> getTarifas() {
        return tarifas;
    }

//    public void setTarifas(HashMap<String, Double> tarifas) {
//        this.tarifas = tarifas;
//    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Set<String> getExtras(){
        return tarifas.keySet();
    }

    public String getCodigoHotel() {
        return codigoHotel;
    }

    public void setCodigoHotel(String codigoHotel) {
        this.codigoHotel = codigoHotel;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        String salida = "";
        Set<String> extras = tarifas.keySet();
        
       salida = "\nHotel{" +"codigo="+codigoHotel+ ", nombre=" + nombre + ", ciudad=" + ciudad+"\n";
        for (String extra : extras) {
            salida+= extra + ": "+this.tarifas.get(extra)+"\n";
        }
               
       return salida;
    }
    
    
}
