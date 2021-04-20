/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghotel_exa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class IO {

    static BufferedReader abreLectura(String nomFichero) {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(nomFichero));
            return input;
        } catch (IOException ex) {
            System.out.println("Algo va mal");
        }
        return input;
    }

    static BufferedWriter abreEscritura(String nomFichero) {
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(nomFichero));
            return output;
        } catch (IOException ex) {
            System.out.println("Algo va mal");
        }
        return output;
    }

    static String leeLinea(BufferedReader input) {
        String linea = "";
        try {
            linea = input.readLine();
            return linea;
        } catch (IOException ex) {
            System.out.println("Algo va mal");
        }
        return linea;
    }

    static void escribeLinea(BufferedWriter output, String linea) {

        try {
            output.write(linea);
           // output.newLine();
        } catch (IOException ex) {
            System.out.println("Algo va mal");
        }
    }

    static void cierraLectura(BufferedReader input) {
        try {
            input.close();
        } catch (IOException ex) {
            System.out.println("Algo va mal");
        }
    }

    static void cierraEscritura(BufferedWriter output) {
        try {
            output.close();

        } catch (IOException ex) {
            System.out.println("Algo va mal");
        }
    }
}
