/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcoscompany.ADREC02_marcos;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */
public class Main {
    
    static String rutaOrigen = "", rutaBackup = "", fichero = "";
    static ArrayList <String>  datosCopiado = new ArrayList();
    static boolean salir = false;
    static Scanner lector = new Scanner(System.in);
    
    public static void main (String[] args) throws IOException{
   
        int opc = 0;
        String aux = "";        
        do {
            System.out.println("_____________Bienvenido a la tarea ADREC02 de Acceso a Datos_____________\n");
            System.out.println("1.- Cargar datos.\n2.- BackUp de seguridad.\n3.- Generar Informe.\n4.- Salir.\n");            
            aux = lector.nextLine();
            if(comprobarNum(aux)){
                opc = Integer.parseInt(aux);
            }
            switch (opc){
                case 1:
                    ejercicio1();
                 break;
                 case 2:
                    ejercicio2();
                 break;
                 case 3:
                    ejercicio3();
                 break;
                 case 4:
                    out();
                 break;
                default:
                    System.out.println("__Opción no valida__");
                 break;
            }            
        }while (salir == false);    
    }
    
    public static void out(){
        System.out.println("Deseas salir (s/n)?");
        String fuera;
        fuera = lector.nextLine();
        if (fuera.toLowerCase().equals("s")){
            salir = true;
        }
    }
    
    public static boolean comprobarNum(String cadena) {
        boolean resultado;
            try {
                Integer.parseInt(cadena);
                resultado = true;
            } catch (NumberFormatException ex) {                
                resultado = false;
            }
            return resultado;
    }
    
    ///EJERCICIO 1
    public static void ejercicio1(){        
        fichero = ManejoDatos.leerFileJson("config.json");        
    }
    
    ///EJERCICIO 2
    public static void ejercicio2() throws IOException{
        Gson gson = new Gson();
        ConfigJason datos = gson.fromJson(fichero, ConfigJason.class);
        rutaOrigen = datos.getDirectorio_orixen();
        rutaBackup = datos.getDirectorio_backup();
        datosCopiado = (ArrayList<String>) ManejoDatos.backUp(rutaOrigen, rutaBackup);
        if(datosCopiado != null){
            System.out.println("BackUp realizado con exito!!\n\n");
        }
    }
    
    ///EJERCICIO 3
    public static void ejercicio3() throws IOException{        
        Report informe = new Report(datosCopiado.get(1), datosCopiado.get(0));
        ManejoDatos.reporte("informe.json", informe);
        out();
    }
    
}
