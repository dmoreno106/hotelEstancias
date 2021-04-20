/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_exa;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class Comprueba {
    
    public static boolean esFechaBuena(String fecha){
        
        try{
            LocalDate.parse(fecha);
            return true;
        }catch(DateTimeParseException e){
        return false;
    }
   }
     public static boolean esDniBueno (String dni){
        HashMap<Integer, Character> letradni = new HashMap<Integer, Character>();
        letradni.put(0,'T');
        letradni.put(1,'R');
        letradni.put(2,'W');
        letradni.put(3,'A');
        letradni.put(4,'G');
        letradni.put(5,'M');
        letradni.put(6,'Y');
        letradni.put(7,'F');
        letradni.put(8,'P');
        letradni.put(9,'D');
        letradni.put(10,'X');
        letradni.put(11,'B');
        letradni.put(12,'N');
        letradni.put(13,'J');
        letradni.put(14,'Z');
        letradni.put(15,'S');
        letradni.put(16,'Q');
        letradni.put(17,'V');
        letradni.put(18,'H');
        letradni.put(19,'L');
        letradni.put(20,'C');
        letradni.put(21,'K');
        letradni.put(22,'E');
        
        dni.toUpperCase();
        if (dni.length()==9){
            String numerosdni = dni.substring(0,8);
            char letra = dni.charAt(8);
            if (esNumero(numerosdni) && esLetra(letra)) {
               int resto =  Integer.parseInt(numerosdni)%23; 
               char letrabuena = letradni.get(resto);
                if (letrabuena== letra) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean esLetra (char c){
        String cad = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        return cad.contains(Character.toString(c));
    }
    
    public static boolean esNumerico (char c){
        String cad = "123456789";
        return cad.contains(Character.toString(c));
    }
    
    public static boolean esNumero (String cad){
        for (int i = 0; i < cad.length(); i++) {
            if(!esNumerico(cad.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    
    
}
