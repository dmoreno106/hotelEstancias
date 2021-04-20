/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_exa;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;



import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener, ItemListener {
    Hoteles hoteles;
    String[] textoRadio;
    Hotel hotel;
    JPanel panelHoteles, panelExtras;
    JComboBox ciudadesCob;
    JComboBox hotelesCob;
    JLabel dniJl,nombreJl,fEJl,fSJl,ppdJl,extraJl;
    JTextField dniTf,nombreTf,fETf,fSTf;
    
    private ButtonGroup grupoBg = new ButtonGroup();
    JRadioButton[] listaRb;
    JCheckBox[] listaExtrasChs = null;
    JLabel[] listaLb =null;
    JButton facturarBt,grabarBt;

    public Ventana(Hoteles hoteles) {
        this.hoteles = hoteles;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Hoteles");
        this.setSize(600, 500);
        this.setLayout(null);

        panelHoteles = new JPanel();
        panelHoteles.setLayout(null);
        panelHoteles.setBounds(5, 5, 280, 400);
        panelHoteles.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(panelHoteles);

        panelExtras = new JPanel();
        panelExtras.setLayout(null);
        panelExtras.setBounds(300, 5, 250, 400);
        panelExtras.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(panelExtras);
        
         hotelesCob=new JComboBox();
         hotelesCob.setBounds(120,40,120,20);
        panelHoteles.add(hotelesCob);
        hotelesCob.addItemListener(this);
        
         ciudadesCob=new JComboBox();
         ciudadesCob.setBounds(20,40,80,20);
        panelHoteles.add(ciudadesCob);
        ciudadesCob.addActionListener(this);
        
        dniJl=new JLabel("DNI:");
        dniJl.setBounds(10,150,50,10);
        panelHoteles.add(dniJl);
        
        dniTf=new JTextField();
        dniTf.setBounds(40,145,70, 20);
        panelHoteles.add(dniTf);
        
         nombreJl=new JLabel("nombre:");
        nombreJl.setBounds(120,150,80,10);
        panelHoteles.add(nombreJl);
        
        nombreTf=new JTextField();
        nombreTf.setBounds(170,145,100, 20);
        panelHoteles.add(nombreTf);
        
        fEJl=new JLabel("Fecha Entrada:");
        fEJl.setBounds(10,190,100,10);
        panelHoteles.add(fEJl);
        
        fETf=new JTextField();
        fETf.setBounds(10,205,100, 20);
        panelHoteles.add(fETf);
        
        fSJl=new JLabel("Fecha Salida:");
        fSJl.setBounds(170,190,100,10);
        panelHoteles.add(fSJl);
        
        fSTf=new JTextField();
        fSTf.setBounds(170,205,100, 20);
        panelHoteles.add(fSTf);
        
        
        ppdJl=new JLabel();
        ppdJl.setBounds(20, 240,100,20);
         panelHoteles.add(ppdJl);
         
         extraJl=new JLabel("Extra: tarifa");
        
         
        facturarBt = new JButton("Facturar");
        facturarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double suma = 0;
//               ------escriba código aquí
                for (JCheckBox listaExtrasCh : listaExtrasChs) {
                    if(listaExtrasCh.isSelected()){
//                        System.out.println(listaExtrasCh.getText());
                        suma+=Double.parseDouble(listaExtrasCh.getText().split(":")[1]);
                    }
                }
                
               ppdJl.setText("PPD:"+suma);
              
            
              
               panelHoteles.repaint();
               grabarBt.setVisible(true);
            }
        });
          panelExtras.add(facturarBt);
        facturarBt.setBounds(70, 360,120,30);
        
        
        grabarBt=new JButton("grabar");
        grabarBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             
                
                 if(Comprueba.esFechaBuena(fETf.getText())){
                     if(Comprueba.esFechaBuena(fSTf.getText())){
                         if(LocalDate.parse(fSTf.getText()).compareTo(LocalDate.parse(fETf.getText()))>0){
                             if(Comprueba.esDniBueno(dniTf.getText())){
                                 if(!nombreTf.getText().isEmpty()){
                                     String extras=""; 
                                     if(listaExtrasChs!=null){
                                     for (int i = 0; i <listaExtrasChs.length; i++) {
                                         if(listaExtrasChs[i].isSelected()){
                                         extras=extras+"\n"+listaExtrasChs[i].getText();
                                         }
                                     }
                                     Double precioExtras=Double.parseDouble(ppdJl.getText().split(":")[1]);
                                     String linea=hotelesCob.getSelectedItem()+" "+hotel.getCiudad()+"\n"+hotel.getNombre()+"{"
                                             +"\nPrecio Hotel: "+hotel.getPrecio()+"\n DNI: "+dniTf.getText()+"\n Nombre: "+nombreTf.getText()
                                             +"\n Fecha de entrada: "+fETf.getText()+"\n Fecha de salida:"+fSTf.getText()
                                             +"\n Extras: "+extras+"\n"+"precio por dia:"+precioExtras+"\n Total: "+(precioExtras+hotel.getPrecio())+"\n }";
//                                     System.out.println(linea);
                                        
                                    String aux=(LocalDateTime.now()).toString();
                                    
                                    BufferedWriter output=IO.abreEscritura(aux.replace(":","_")+".txt");
                                     IO.escribeLinea(output,linea);
                                     IO.cierraEscritura(output);
                                     System.out.println("Reserva grabada correctamente");
                                    }else{
                                         System.out.println("por favor seleccione los extras que desee");
                                     }
                                 }else{
                                     System.out.println("nombre no válido");
                                     nombreTf.setText("");
                                 }
                             }else{
                                 System.out.println("dni incorrecto");
                                 dniTf.setText("");
                             }
                         }else{
                             System.out.println("fechas introducidas no válidas");
                         }
                     }else{
                         System.out.println("error fecha");
                         fSTf.setText("");
                     }
                 }else{
                     System.out.println("error fecha");
                     fETf.setText("");
                 }
            }
        });
        grabarBt.setBounds(85,310, 120, 50);
        panelHoteles.add(grabarBt);
        grabarBt.setVisible(false);
      
        hotel=hoteles.getListaHoteles().get(0);
        ponCiudades();
        this.setVisible(true);
    }
    public void cambiaHoteles(String nombreCiudad) throws FileNotFoundException{
        hotelesCob.removeAllItems();
            ArrayList<String> listaHoteles=new ArrayList<>();
            for (int i = 0; i <hoteles.getListaHoteles().size(); i++) {
            if(nombreCiudad.equalsIgnoreCase(hoteles.getListaHoteles().get(i).getCiudad())){
                listaHoteles.add(hoteles.getListaHoteles().get(i).getCodigoHotel());
            }
        }
            for (String hotel : listaHoteles) {
            hotelesCob.addItem(hotel);
        }
           ponExtras();
    }

    
    public void ponCiudades() {
        ArrayList<String> nombres=new ArrayList();
        for (int i = 0; i < hoteles.getListaHoteles().size(); i++) {
            if(!nombres.contains(hoteles.getListaHoteles().get(i).getCiudad())){
            nombres.add(hoteles.getListaHoteles().get(i).getCiudad());
        }
        }
        for (String nombre : nombres) {
            ciudadesCob.addItem(nombre);
        } 
        }
    
    public void ponExtras() throws FileNotFoundException {
        //listaExtrasChs
       panelExtras.removeAll();
        String aux=(String)hotelesCob.getSelectedItem();
        
        for (int i = 0; i <hoteles.getListaHoteles().size(); i++) {
            if(aux.equalsIgnoreCase(hoteles.getListaHoteles().get(i).getCodigoHotel())){
                hotel=hoteles.getListaHoteles().get(i);
                
            }
        }
        
        listaExtrasChs=new JCheckBox[hotel.getExtras().size()];
        
          int  i=0;
        for (String extra :hotel.getExtras()) {
            listaExtrasChs[i]= new JCheckBox(extra +": "+ hotel.getTarifas().get(extra));
            listaExtrasChs[i].setBounds(10, 50+100*i,200,60);
            panelExtras.add(listaExtrasChs[i]);
            i++;
        }
        
            panelExtras.add(facturarBt);
        facturarBt.setBounds(70, 360,120,30);
        
            extraJl.setBounds(30, 20, 100, 30);
         panelExtras.add(extraJl);
        
         this.repaint();
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie) {
      if(ie.getSource()==hotelesCob){
          try {
              ponExtras();
          } catch (FileNotFoundException ex) {
              System.out.println("archivo no existente");;
          }
      }
    }   
    

    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==ciudadesCob){    
          hotelesCob.removeItemListener(this);
          try {
              cambiaHoteles((String)ciudadesCob.getSelectedItem());
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
          }
      hotelesCob.addItemListener(this);
}
}
}
