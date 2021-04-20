/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_exa;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class Hoteles implements Serializable{
    private ArrayList<Hotel> listaHoteles;

    public Hoteles() {
        listaHoteles = new ArrayList<Hotel>();
    }

    public void insertaHotel(Hotel h){
        listaHoteles.add(h);
        
    }
    public ArrayList<Hotel> getListaHoteles() {
        return listaHoteles;
    }

    public void setListaHoteles(ArrayList<Hotel> listaHoteles) {
        this.listaHoteles = listaHoteles;
    }

    @Override
    public String toString() {
        return "Hoteles{" + "listaHoteles=" + listaHoteles + '}';
    }
  
}
