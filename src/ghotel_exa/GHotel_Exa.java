package ghotel_exa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;

public class GHotel_Exa {

    public static void main(String[] args) throws FileNotFoundException {
        Hoteles hoteles;
        hoteles = new Hoteles();
        
        Comprueba.esFechaBuena("aoiwd");
        
        //Los dos métodos siguientes se ejecutan una sola vez para crear el objeto hoteles 
        // y serializarlo,una vez hecho esto comentarlos,
                //Llena el objeto hoteles a partir de los datos del fichero de texto HotelesTarifas.txt
                cargaHoteles(hoteles);
                //Serializa el objeto hoteles en el fichero hoteles.ser
//                serializaHoteles(hoteles);
        
        //Deserializamos el objeto hoteles desde fichero hoteles.ser
//        ObjectInputStream entradaSer;
//        entradaSer = IOSerializada.abrirFicheroEntrada("hoteles.ser");
//        hoteles = (Hoteles) IOSerializada.leerRegistro(entradaSer);
        
        //        System.out.println("Listado:\n" + hoteles); //para probar la deserilización
        
        
        new Ventana(hoteles);
    }

    //Llena el objeto hoteles a partir de los datos del fichero de texto HotelesTarifas.txt
    public static void cargaHoteles(Hoteles hoteles) throws FileNotFoundException {
       
        Hotel hotel;
        String linea;
            //---------- escriba código aquí
            BufferedReader input=new BufferedReader(new FileReader("Hoteles.txt"));
        linea=IO.leeLinea(input);
        while(linea!=null){
         String[] elementos=linea.split("/");
        hotel=new Hotel(elementos[0],elementos[1],elementos[2],Double.parseDouble(elementos[3]));
       hoteles.insertaHotel(hotel);
       
        linea=IO.leeLinea(input);
        }
//        System.out.println(hoteles);
        
        String lineaExtra;
        BufferedReader inputExtra= new BufferedReader(new FileReader("Extras.txt"));
        lineaExtra=IO.leeLinea(inputExtra);
        while(lineaExtra!=null){
            String[] elem=lineaExtra.split("/");
            for (int i = 0; i < hoteles.getListaHoteles().size(); i++) {
                if(elem[0].equalsIgnoreCase(hoteles.getListaHoteles().get(i).getCodigoHotel())){
                    hotel=hoteles.getListaHoteles().get(i);
                    String[] extras=elem[1].split(",");
                    for (int j = 0; j <extras.length; j++) { 
                     String[] valores=extras[j].split(":");
                     hotel.insertaTarifa(valores[0], Double.parseDouble(valores[1]));
                    }
                    
                    
                    
                    
                }
            }
            
        lineaExtra=IO.leeLinea(inputExtra);
    }
        
    }
    
    
     //Serializa el objeto hoteles en el fichero hoteles.ser
    public static void serializaHoteles(Hoteles hoteles) {
        System.out.println("crearficheros");
        //crea el fichero hoteles.ser
        ObjectOutputStream salidaSer = IOSerializada.abrirFicheroSalida("hoteles.ser");
        //Escribe hoteles en el fichero.ser
        IOSerializada.escribirObjeto(salidaSer, hoteles);
        //Cierra el fichero
        IOSerializada.cerrarFicheroSalida(salidaSer);

    }

}
