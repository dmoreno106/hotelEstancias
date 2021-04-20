/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_exa;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOSerializada {

    private static ObjectOutputStream salida;
    File fichero;
    



    public static ObjectInputStream  abrirFicheroEntrada(String fichero) {
        ObjectInputStream entrada=null;
//       --escriba código aquí
return entrada;
    } 
    
     public static ObjectOutputStream abrirFicheroSalida(String fichero) {
        ObjectOutputStream salida;
        try 
        {
                salida=new ObjectOutputStream(new FileOutputStream(fichero));
               return salida;
        } 
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo de salida.");
            return null;
        } 
    } 


    public static Object leerRegistro(ObjectInputStream entrada) {
       
//         --escriba código aquí
                 return null;
   
    } 
            

    
    public static void escribirObjeto(ObjectOutputStream salida, Object obj) {
        try 
        {
                salida.writeObject(obj);
        } 
        catch (IOException ioException) {
            System.err.println("Error al escribir el archivo.");
        } 
    } 

// cierra el archivo
    public static void cerrarFicheroEntrada( ObjectInputStream entrada) {
        try 
        {
            if (entrada != null) {
                entrada.close();
            }
 
        } 
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
        } 
    } 
    
    public static void cerrarFicheroSalida(ObjectOutputStream salida) {
        try 
        {
            if (salida != null) {
                salida.close();
            }
        } 
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
        } 
    } 
      
}
